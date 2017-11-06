package grovepisensors;

import org.iot.raspberry.grovepi.GroveUtil;
/**
 * The RotaryStateDeterminer class receives updates from a GroveAnalogInputSensorListener object.
 * An instance of this class is responsible for analyzing the degree of a Grove Rotary Angle Sensor.
 * Private static variables of this class define distinct angle degree intervals. When the Grove Rotary Angle Sensor's angle 
 * moves to a different degree interval, the appropriate object is notified.
 * @author James Luczynski
 * @see GroveInputSensorObserver
 * @see GroveAnalogInputSensorListener
 */
public class RotaryStateDeterminer implements GroveInputSensorObserver
{
    /**
     * Reference voltage of ADC is 5v
     */
    private static final double ADC_REF = 5;
    /**
     * Vcc of the grove interface is 5 volts
     */
    private static final double GROVE_VCC = 5;
    /**
     * Grove rotary sensor has only 300 degrees of rotation
     */
    private static final double FULL_ANGLE = 300;
    /**
     * The number of different states 
     */
    private int NUM_STATES = 4;
    /**
     * The range in degrees of an interval that is associated with a distinct state.
     */
    private double DEGREE_RANGE = FULL_ANGLE / NUM_STATES;
    /**
     * The current state.
     */
    private int state;
    /**
     * The previous state.
     */
    private int oldState;
    /**
     * Updates an instance of this class of the current angle of a Grove rotary sensor. If the state has changed,
     * notifies the appropriate object elsewhere.
     * @param b  Read from the Grove input sensor, passed to this instance via an instance of
     * GroveDigitalInputSensorListener
     * @Override update in interface GroveSensorObserver
     * @See GroveInputSensorObserver
     * @See GroveAnalogInputSensorListener
     * @See GroveRotarySensor
     * @See GroveRotaryValue
     */    
    public void update(byte[] b){
        double degrees = getDegrees(b);
        oldState = state;
        for (int i = 0; i < NUM_STATES; i++)
            if (i * DEGREE_RANGE < degrees && degrees < (i+1) * DEGREE_RANGE)
                 state = i+1;
        if (oldState != state)
            System.out.println("State: " + state);
    }
     /**
     * Computes the current angle in degrees of the Grove rotary sensor based on the byte array read from the sensor
     * @param b the byte[] read from the rotary sensor
     * @return the angle of the rotary sensor
     */
    public double getDegrees(byte[] b){
        int[] v = GroveUtil.unsign(b);
        double sensorValue = (v[1]*256) + v[2];
        double voltage = sensorValue * ADC_REF / 1023;
        double degrees = voltage * FULL_ANGLE / GROVE_VCC;
        return degrees;
    }
}