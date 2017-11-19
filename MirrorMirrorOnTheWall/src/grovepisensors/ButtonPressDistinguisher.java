package grovepisensors;

/**
 * This class implements the interface Runnable so that instances of this class can be handled by a Thread.
 * The ButtonPressDistinguisher class receives updates from a GroveDigitalInputSensorListener 
 * object. An instance of this class is responsible for analyzing the times of button presses
 * and button releases to discern whether a Single, Double, or Long Press has occurred. When 
 * one of these types of presses has occurred, an instance of this class notifies the appropriate object.
 * @author James Luczynski
 * @see GroveInputSensorObserver
 * @see Runnable
 * @see GroveDigitalInputSensorListener
 */
public class ButtonPressDistinguisher implements GroveInputSensorObserver, Runnable{
    /**
     * Holds the current state of the button sensor.
     */
    private boolean buttonDown = false;             //button starts up/unpressed
    /**
     * True if a Single Press has recently occurred, and an instance of this class is waiting to observe a second press.
     */
    private boolean waitingForSecondPress = false;
    /**
     * Holds the time in milliseconds of the last button press.
     */
    private long lastPress;
    /**
     * Holds the time in milliseconds of the last button release.
     */
    private long lastRelease;
    /**
     * The Thread object that invokes the run() method.
     */
    private Thread thread = new Thread(this);
    /**
     * The number of milliseconds the button must be held down for a Long Press.
     */
    private final int LONG_PRESS_TIME_INTERVAL = 1000;
    /**
     * The length of the time interval in which two presses must occur in for a Double Press.
     */
    private final int DOUBLE_PRESS_TIME_INTERVAL = 1000;
    /**
     * Holds what last type of press was.
     */
    private ButtonPress pressType;
    /**
     * Updates the recorded times of button presses and releases. If a Long Press or a Double Press
     * occurs, this method notifies the appropriate object.  If a Single Press is detected, this method
     * calls the run method to start a thread which waits to determine if the detected Single Press is
     * really just the first of a Double Press
     * @param b  the byte array read from the Grove input sensor, passed to this instance via GroveDigitalInputSensorListener object
     * @See GroveDigitalInputSensorListener
     * @Override update in GroveInputSensorObserver
     */
    public void update(byte[] b){  //parameter value of no use here
        long timeOfAction = System.currentTimeMillis();
        
        buttonDown = !buttonDown;           //the button has changed state
        if (buttonDown) {                   //if this update results from button being pressed down.
            lastPress = timeOfAction;
        } else{                             //button was just released
            lastRelease = timeOfAction;           
            if (lastRelease - lastPress > LONG_PRESS_TIME_INTERVAL){
                pressType = ButtonPress.LONG;
                notifyWidgets();
            }
            else{
                if (thread.isAlive()){ //if thread still waiting, it's a double press        
                    pressType = ButtonPress.DOUBLE;
                    notifyWidgets();
                    waitingForSecondPress = false;
                }else{ //this press is not second press of a double press, must wait
                    waitingForSecondPress = true;
                    thread = new Thread(this);
                    thread.start();
                }                    
            }
        }   
    }        
    /**
     * Invoked by update method of this class when it detects a Single Press.  If the Single Press is not followed by another within
     * the predetermined period of time.  The run method determines that a Single Press has occurred and notifies the appropriate objec
     * @Override run in interface Runnable
     */
    public void run(){
        try{
            Thread.sleep(DOUBLE_PRESS_TIME_INTERVAL);  //after "enough" time has elapsed,
            if(waitingForSecondPress){              //and still waiting for second press, then it's a single press
                pressType = ButtonPress.SINGLE;
                notifyWidgets();
                waitingForSecondPress = false;
            }                
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    
    /**
     * Responsible for notifying active widget of press type that has just occurred.
     */
    public void notifyWidgets(){
        System.out.println(pressType + " press");
    }
}
