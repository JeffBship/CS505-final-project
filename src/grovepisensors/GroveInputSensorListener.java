package grovepisensors;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Subclasses of this class make intermittent reads to either a digital or analog Grove input sensor, and notify their observers.
 * This class provides the methods for adding and removing observers.
 * @author James Luczynski
 * @See GroveInputSensorObserver
 */
public abstract class GroveInputSensorListener {
    /**
     * A list of all observers that this listener notifies.
     */
    protected CopyOnWriteArrayList<GroveInputSensorObserver> observers = new CopyOnWriteArrayList<GroveInputSensorObserver>();
    /**
     * Responsible for making the intermittent calls to read the input sensor
     */
    protected final ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
    /**
     * Adds the observer to the list of observers.
     * @param observer the observer to be added
     */
    public void addObserver(GroveInputSensorObserver observer){
        observers.add(observer);
    }
    /**
     * Removes the observer from the list of observers.
     * @param observer 
     */
    public void removeObserver(GroveInputSensorObserver observer){
        observers.remove(observer);
    }
    
    /**
     * Initiates the readings of the input sensor's values
     * @param r an object that implements the Runnable interface. The run() method of r is the method that is intermittently called
     * @param delay the number of milliseconds between consecutive reads or calls of r's run() method
     */
    protected void startListening(Runnable r, int delay){
        exec.scheduleAtFixedRate(r, 0, delay, TimeUnit.MILLISECONDS);
    }
    
    /**
     * Implementation to be provided by subclasses. Notifies all observers of the values recently read from the input sensor.
     * @param b the byte array that was read from the sensor.
     */
    protected abstract void notifyObservers(byte[] b);
}