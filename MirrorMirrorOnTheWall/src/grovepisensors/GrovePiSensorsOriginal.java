package grovepisensors;

import com.pi4j.io.i2c.I2CFactory;
import org.iot.raspberry.grovepi.pi4j.GrovePi4J;
import java.io.IOException;

/**
 * Short program to show that the sensors are working properly.
 * @author James Luczynski
 */
public class GrovePiSensorsOriginal {

    public static void main(String[] args) throws IOException, I2CFactory.UnsupportedBusNumberException {
        int buttonPin = 6;
        int rotaryPin = 2;
        int bufferLength = 4;
        int nStates = 4; //number of states for the rotary to detect
        GrovePi4J gp = new GrovePi4J();
        
        GroveDigitalInputSensorListener buttonListener = 
                new GroveDigitalInputSensorListener(gp, buttonPin);
        GroveAnalogInputSensorListener rotaryListener = 
                new GroveAnalogInputSensorListener(gp, rotaryPin, bufferLength);
        
        buttonListener.addObserver(new ButtonPressDistinguisher());
        rotaryListener.addObserver(new RotaryStateDeterminer(nStates));   
        
        buttonListener.startListening();
        rotaryListener.startListening();
    }    
}