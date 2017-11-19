package grovepisensors;

import org.iot.raspberry.grovepi.GroveDigitalInListener;
import org.iot.raspberry.grovepi.GroveDigitalIn;
import org.iot.raspberry.grovepi.GrovePi;
import java.io.IOException;
/**
 * This class extends GroveInputSensorListener and implements the GroveDigitalInListener interface.
 * An instance of this class makes intermittent reads to the Grove digital sensor it is associated with, 
 * and notifies its observers of the values read.
 * @author James Luczynski
 * @See GroveInputSensorListener
 * @See GroveDigitalInListener
 */
public class GroveDigitalInputSensorListener extends GroveInputSensorListener implements GroveDigitalInListener{
    /**
     * The digital sensor an instance of this class makes reads from.
     */
    protected GroveDigitalIn sensor;
    /**
     * The amount of time in milliseconds between consecutive reads of the Grove digital input sensor values.
     */
    protected int READ_DELAY = 75;
     /**
     * Instantiates a GroveDigitalInputSensorListener and begins making reads of its associated Grove input sensor immediately.
     * @param grovePi the GrovePi instance representing the physical GrovePi device.
     * @param pin the number of the port that the sensor, that an instance of this class reads from, is plugged into.
     * @throws IOException if the GrovePi board is not connected to the Raspberry Pi or if there is no sensor plugged into the sensor port designated by pin.
     */
    public GroveDigitalInputSensorListener(GrovePi grovePi, int pin) throws IOException{
        sensor = new GroveDigitalIn(grovePi, pin);
        sensor.setListener(this);
    }
    
    /**
     * Initiates the readings of the input sensor's values
     */
    public void startListening(){
        this.startListening(sensor, READ_DELAY);
    }
    
     /**
     * Notifies all observers of the new values read from the input sensor
     * @param b the byte array read from the sensor.
     * @Override notifyObservers in GroveInputSensorListener
     */
    public void notifyObservers(byte[] b){
        for (GroveInputSensorObserver o : observers){
            o.update(new byte[] {0});  //for digital sensor, value passed is meaningless.
        }
    }
    
    /**
     * Tells an instance of this class to notify its observers of the new values read from the input sensor.
     * @param newValue The new state of the digital sensor.
     * @param oldValue The old state of the digital sensor.
     * @Override onChange in GroveDigitalInListener
     */
    public void onChange(boolean oldValue, boolean newValue){
        notifyObservers(null);
    }
}
