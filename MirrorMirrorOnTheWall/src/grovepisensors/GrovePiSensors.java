package grovepisensors;

import com.pi4j.io.i2c.I2CFactory;
import org.iot.raspberry.grovepi.pi4j.GrovePi4J;
import java.io.IOException;
/**
 * Short program to show that the sensors are working properly.  Currently, I do not think that 
 * the sensors work properly when looking at both sensors at the same time.
 * If you want to use the button, set 'testingButton = true;' If you want to test the rotary,
 * set 'testingButton = false;'  Ensure that button is connected to port 6 on the GrovePi, and 
 * that the rotary is connected to port 2 on the GrovePi.
 * @author James Luczynski
 */
public class GrovePiSensors {
    /**
     * Decides which type of sensor will be used. If true, then button. If false, then rotary.
     */
    private static boolean testingButton = true;

    public static void main(String[] args) throws IOException, I2CFactory.UnsupportedBusNumberException {
        int buttonPin = 6;
        int rotaryPin = 2;
        int bufferLength = 4;
        GrovePi4J gp = new GrovePi4J();
        
        if (testingButton){
            GroveDigitalInputSensorListener buttonListener = 
                    new GroveDigitalInputSensorListener(gp, buttonPin);
            buttonListener.addObserver(new ButtonPressDistinguisher());
        }else{ //testing Rotary
            GroveAnalogInputSensorListener rotaryListener = 
                    new GroveAnalogInputSensorListener(gp, rotaryPin, bufferLength);
            rotaryListener.addObserver(new RotaryStateDeterminer());    
        }
    }    
}
