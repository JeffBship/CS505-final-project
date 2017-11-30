package edu.ccsu.cs505.compob;

import java.util.*;
import java.util.TimerTask;
import java.io.IOException;
import com.dexterind.grovepi.sensors.*;

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
    private final DHTDigitalSensor dhtSensor;

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
        this.dhtSensor = new DHTDigitalSensor(this.pinNum, 0, this.scale);
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
        this.dhtSensor = new DHTDigitalSensor(this.pinNum, 0, this.scale);
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
        this.dhtSensor = new DHTDigitalSensor(this.pinNum, 0, this.scale);
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
        this.dhtSensor = new DHTDigitalSensor(this.pinNum, 0, this.scale);
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
                read();
                notifyObservers();
            }
        }, (long) interval * 1000, (long) interval * 1000);
    }

    /**
     * Read temperature and humidity from DHTDigitalSensor's read function
     */
    private void read() {
        float data[] = this.dhtSensor.read();
        this.temperature = data[0];
        this.humidity = data[1];
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
