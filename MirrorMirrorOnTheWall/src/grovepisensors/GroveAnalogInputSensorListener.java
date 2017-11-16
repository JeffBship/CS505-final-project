package grovepisensors;

import org.iot.raspberry.grovepi.GroveAnalogInListener;
import org.iot.raspberry.grovepi.GroveAnalogIn;
import org.iot.raspberry.grovepi.GrovePi;
import java.io.IOException;
/**
 * This class extends GroveInputSensorListener and implements the GroveAnalogInListener interface.
 * An instance of this class makes intermittent reads to the Grove analog sensor it is associated with, 
 * and notifies its observers of the values read.
 * @author James Luczynski
 * @See GroveInputSensorListener
 * @See GroveAnalogInListener
 */
public class GroveAnalogInputSensorListener extends GroveInputSensorListener implements GroveAnalogInListener{
    /**
     * The Grove analog input sensor an instance of this class makes reads from.
     */
    protected final GroveAnalogIn sensor;
    /**
     * The amount of time in milliseconds between consecutive reads of the Grove analog input sensor values.
     */    
    private final int READ_DELAY = 250;
    /**
     * Instantiates a GroveAnalogInputSensorListener and begins making reads of its associated Grove input sensor immediately.
     * @param grovePi the GrovePi instance representing the physical GrovePi device.
     * @param pin the number of the port that the sensor, that an instance of this class reads from, is plugged into.
     * @param bufferSize the number of bytes to be read from the sensor.
     * @throws IOException if the GrovePi board is not connected to the Raspberry Pi or if there is no sensor plugged into the sensor port designated by pin.
     */
    public GroveAnalogInputSensorListener(GrovePi grovePi, int pin, int bufferSize) throws IOException{
        sensor = new GroveAnalogIn(grovePi, pin, bufferSize);
        sensor.setListener(this);
        startListening(sensor, READ_DELAY);
    }
    
    /**
     * Notifies all observers of the new values read from the input sensor
     * @param b the byte array read from the sensor.
     */
    protected void notifyObservers(byte[] b){
        for (GroveInputSensorObserver o : observers){
            o.update(b);
        }
    }
    
    /**
     * Tells an instance of this class to notify its observers of the new values read from the input sensor.
     * @param newValue The byte array read from the input sensor.
     */
    public void onChange(byte[] newValue){
        notifyObservers(newValue);
    }    
}