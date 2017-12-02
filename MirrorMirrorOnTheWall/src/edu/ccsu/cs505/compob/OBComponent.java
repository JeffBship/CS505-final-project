package edu.ccsu.cs505.compob;

import java.io.IOException;



/**
 * This is a demo about how to using our component. Anyone who wants to use this
 * component, just need to initialize the SubjectDHTSensor, which is the subject
 * in Observer Pattern. The next step is initializing an observer class. In our
 * demo, we are using our own LEDObserverWarner as an observer. Last step is
 * register its observers class on subject by addObserver method. After the
 * above steps, the subject would run automatically and send notify message to
 * observers by interval time.
 *
 *
 * @author CS505-Group5
 * @version 0.2
 * @since 0.1
 */
public class OBComponent extends Thread{

    /**
     * main function, to run demo
     *
     * @param args, main function
     * @throws IOException, throws IOException
     * @throws java.lang.InterruptedException, throws InterruptedException.
     */
    public static void main(String[] args) throws IOException, InterruptedException, Exception {

        /**
         * Initialize the subject DHT Sensor by scale(C), interval(seconds) and PIN
         * number on Grove Pi;
         * In this case, use D3 for DHT sensor.
         */
        SubjectDHTSensor dhtSensor = new SubjectDHTSensor(0, 5, 3);
        
        
        //add the listener for temperature and humidity
        //GrovePi grovePi = GrovePiSensors.getGrovePi4J();
        //int pin = 3;
        //GroveTemperatureAndHumiditySensor.Type dhtType = DHT11;
        //GroveTemperatureAndHumiditySensor dhtSensor =
        //  new GroveTemperatureAndHumiditySensor(grovePi, pin, dhtType);
        

        /**
         * Initialize the observer by subject class, warn temperature and PIN
         * number on Grove Pi;
         * In this case, use D2 for LED sensor.
         */
        LEDObserverWarner ledWarner = new LEDObserverWarner(dhtSensor, 20.0, 2);

        /**
         * Register observer on subject.
         */
        dhtSensor.addObserver(ledWarner);
    }

}
