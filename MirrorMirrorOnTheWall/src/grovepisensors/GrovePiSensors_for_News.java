package grovepisensors;


import newswidget.NewsFrame;
import com.pi4j.io.i2c.I2CFactory;
import edu.ccsu.cs505.compob.OBComponent;
import org.iot.raspberry.grovepi.pi4j.GrovePi4J;
import java.io.IOException;
import org.iot.raspberry.grovepi.devices.GroveTemperatureAndHumiditySensor;
import static org.iot.raspberry.grovepi.devices.GroveTemperatureAndHumiditySensor.Type.DHT11;

/**
 * Short program to show that the sensors are working properly.
 * @author James Luczynski
 */
public class GrovePiSensors_for_News {
  
  private static GroveTemperatureAndHumiditySensor dhtSensor;  
  private static GrovePi4J gp;
  
  public static GroveTemperatureAndHumiditySensor getDhtSensor(){
    return dhtSensor;
  }
  public static GrovePi4J getGrovePi4J(){
    return gp;
  }
  
  

    public static void main(String[] args) throws IOException, I2CFactory.UnsupportedBusNumberException, Exception {
        int buttonPin = 6;
        int rotaryPin = 2;
        int bufferLength = 4;
        int nStates = 4; //number of states for the rotary to detect
        GrovePi4J gp = new GrovePi4J();
        
        GroveDigitalInputSensorListener buttonListener = 
                new GroveDigitalInputSensorListener(gp, buttonPin);
        GroveAnalogInputSensorListener rotaryListener = 
                new GroveAnalogInputSensorListener(gp, rotaryPin, bufferLength);
        
        
        
        buttonListener.addObserver(new ButtonPressDistinguisher_for_news());
        rotaryListener.addObserver(new RotaryStateDeterminer(nStates));   
        
        //Start the NewsFrame
        NewsFrame.main(null);
        
        buttonListener.startListening();
        rotaryListener.startListening();
        
        
    }    
}