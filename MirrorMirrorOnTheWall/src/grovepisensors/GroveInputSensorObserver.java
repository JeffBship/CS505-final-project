package grovepisensors;
/**
 * The GroveInputSensorObserver should be implemented by all classes that observe
 * GroveInputSensorListener subclasses.  Classes that implement this interface should 
 * provide the logic that analyzes inputs of a Grove input sensor, determines when 
 * a specific event has occurred, and provide a means of notifying other objects elsewhere.
 * @author James Luczynski
 * @see GroveDigitalInputSensor
 */
public interface GroveInputSensorObserver{
    /**
     * Allows subclasses to immediately update their data they are concerned with
     * based on new behavior of the GroveInputSensorListener they are observing.
     * @param b The data read from the Grove input sensor and passed from a subclass of GroveInputSensorListener
     */
    public void update(byte[] b);
}