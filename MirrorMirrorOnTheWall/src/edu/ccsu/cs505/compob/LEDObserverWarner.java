package edu.ccsu.cs505.compob;

import grovepisensors.GrovePiSensors;
import grovepisensors.GrovePiSensors_for_News;
import java.io.IOException;
import org.iot.raspberry.grovepi.GrovePi;
import org.iot.raspberry.grovepi.devices.GroveLed;
import org.iot.raspberry.grovepi.devices.GroveTemperatureAndHumidityValue;

/**
 * This class implements the interface ObserverSensor and it is sub-class of
 * Template class. This is observer class in the observer pattern. This class
 * has an attribute class Led, which is imported from Professor Williams's
 * example inGrovePi package. If the observer get updated temperature from
 * subject class, and the temperature is higher than warning temperature, it
 * will turn on the LED light to warn.
 *
 * @author CS505-Group5
 * @version 0.2
 * @since 0.1
 */
public class LEDObserverWarner extends TempObserverWarner {

    /**
     * Represents the warning temperature
     */
    private double warnTemp;

    /**
     * Represents the warning state, true means on warning, false is not.
     */
    private boolean warnState;

    /**
     * Represents LED sensor class from GrovePi.
     */
    private GroveLed ledWarner;

    /**
     * Constructor.
     *
     * @param sub, SubjectDHTSensor class.
     * @param temp , temperature.
     * @param ledNum, Led pin number.
     *
     */
    public LEDObserverWarner(SubjectDHTSensor sub, 
                              double temp, int ledNum) {
        super();
        this.subject = sub;
        this.warnTemp = temp;
        this.warnState = false;

        try {
            //altered for org library
            GrovePi grovePi = GrovePiSensors_for_News.getGrovePi4J();
            this.ledWarner = new GroveLed(grovePi,ledNum);
            ledWarner.set(0);
        } catch (IOException e) {
        }
    }


    /**
     * Implementation of Hook method
     *
     */
    @Override
    public void hookOb() {
        //altered for org library
        GroveTemperatureAndHumidityValue  tempHum = null;
        try {
          tempHum = this.subject.dhtSensor.get();
        } catch (IOException ex) {}
        
      
        //If the temperature over warntemp, and LED is turned on, keep it.
        if (tempHum.getTemperature() > this.warnTemp && this.warnState) {
            return;
        }
        //If the temeprature equal or below the warntemp, and LED is turned off, keep it.
        if (tempHum.getTemperature() <= this.warnTemp && !this.warnState) {
            return;
        }
        //Otherwise, change the LED status, off -> on, or on ->off
        warn(this.warnState);
        this.warnState = !this.warnState;

    }

    /**
     * Change LED status, if LED is on, turn off, is LED is off, turn on. 
     *
     */
    private void warn(boolean warningStatus) {
        if (warningStatus) {
            try {
                this.ledWarner.set(0);
            } catch (IOException ex) {
            }
            System.out.println("no warning");
        } else {
            try {
                this.ledWarner.set(255);
            } catch (IOException ex) {
            }
            System.out.println("start warning");
        }
    }

    /**
     * Set WarnTemp.
     *
     * @param temp, temperature data, double type.
     */
    public void setWarnTemp(double temp) {
        this.warnTemp = temp;
    }

    /**
     * Gets warning temperature.
     *
     * @return warnTemp
     */
    public double getWarnTemp() {
        return this.warnTemp;
    }

}
