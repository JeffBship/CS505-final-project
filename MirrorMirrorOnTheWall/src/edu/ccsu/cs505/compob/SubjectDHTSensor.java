package edu.ccsu.cs505.compob;

import grovepisensors.GrovePiSensors;
import grovepisensors.GrovePiSensors_for_News;
import java.util.*;
import java.util.TimerTask;
import java.io.IOException;
import org.iot.raspberry.grovepi.GrovePi;
import org.iot.raspberry.grovepi.devices.GroveTemperatureAndHumiditySensor;
import static org.iot.raspberry.grovepi.devices.GroveTemperatureAndHumiditySensor.Type.DHT11;
import org.iot.raspberry.grovepi.devices.GroveTemperatureAndHumidityValue;

/**
 * This is subject class in the observer pattern. This class has an attribute
 * class DHTDigitalSensor, which is imported from Professor Williams's example in
 * GrovePi package. The subject read temperature and humidity data from this DHT
 * sensor. And update to observers by timer.
 *
 *
 * @author CS505-Group5
 * @version 0.2
 * @since 0.1
 */
public class SubjectDHTSensor extends SubjectSensor {

    /**
     * Represents the interval time, scale is second.
     */
    private double interval = 0;

    /**
     * Represents the temperature data.
     */
    private double temperature;

    /**
     * Represents the humidity data.
     */
    private double humidity;

    /**
     * Represents the scale of temperature, 0 is C, and 1 is F.
     */
    private int scale = 0;

    /**
     * Represents the DHT Sensor class.
     */
    final GroveTemperatureAndHumiditySensor dhtSensor;

    /**
     * Represents the pin number of DHT sensor on the Grove Pi, default value is 3.
     * Means using D3 for DHT sensor by default.
     */
    private int pinNum = 3;

    /**
     * Constructor.
     *
     * @throws java.io.IOException, throws IOException
     * @throws java.lang.InterruptedException, throws InterruptedException
     *
     */
    public SubjectDHTSensor() throws IOException, InterruptedException, Exception {
        super();
        //altered for org library
        this.dhtSensor = GrovePiSensors_for_News.getDhtSensor();
        startTimer();
    }

    /**
     * Constructor.
     *
     * @param interval, interval time, by seconds.
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     *
     */
    public SubjectDHTSensor(double interval) throws IOException, InterruptedException, Exception {
        super();
        this.interval = interval;
        
        //altered for org library
        this.dhtSensor = GrovePiSensors_for_News.getDhtSensor();
        startTimer();
    }

    /**
     * Constructor.
     *
     * @param scale, scale of temperature.
     * @param interval, interval time, by seconds.
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     *
     */
    public SubjectDHTSensor(int scale, double interval) throws IOException, InterruptedException, Exception {
        super();
        this.scale = scale;
        this.interval = interval;
        
        //altered for org library
        this.dhtSensor = GrovePiSensors_for_News.getDhtSensor();
        startTimer();
    }

    /**
     * Constructor.
     *
     * @param scale, scale of temperature.
     * @param interval, interval time, by seconds.
     * @param pinNum , Pin number.
     * @throws java.io.IOException, throws IOException
     * @throws java.lang.InterruptedException, throws InterruptedException
     *
     */
    public SubjectDHTSensor(int scale, double interval, int pinNum) throws IOException, InterruptedException, Exception {
        super();
        this.scale = scale;
        this.interval = interval;
        this.pinNum = pinNum;
        
        //altered for org library
        this.dhtSensor = GrovePiSensors_for_News.getDhtSensor();
        
        startTimer();
    }

    /**
     * Once the subject initialized, it will run by interval time, the Java
     * default timer schedule function is running by interval, the unit is
     * millisecond, so we have to * 1000 to get seconds.
     */
    private void startTimer() {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
              try {
                read();
              } catch (IOException ex) { }
                notifyObservers();
            }
        }, (long) interval * 1000, (long) interval * 1000);
    }

    /**
     * Read temperature and humidity from DHTDigitalSensor's read function
     */
    private void read() throws IOException {
        //float data[] = this.dhtSensor.read();
        //altered for org library
        GroveTemperatureAndHumidityValue  tempHum = this.dhtSensor.get();
        this.temperature = tempHum.getTemperature();
        this.humidity = tempHum.getHumidity();
        System.out.println("temperature:"+temperature+"  humidity:"+humidity);
    }

    /**
     * Gets temperature data.
     *
     * @return temperature
     */
    public double getTemperature() {
        return this.temperature;
    }

    /**
     * Gets humidity data.
     *
     * @return humidity
     */
    public double getHumidity() {
        return this.humidity;
    }

    /**
     * Gets interval time(seconds).
     *
     * @return interval
     */
    public double getInterval() {
        return this.interval;
    }

}
