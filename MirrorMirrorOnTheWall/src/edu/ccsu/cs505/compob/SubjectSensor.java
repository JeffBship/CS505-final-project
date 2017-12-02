package edu.ccsu.cs505.compob;

import java.util.*;

/**
 * This is an abstract subject class in the observer pattern. It has a list
 * attributes which used to store the observers. An addObserver and an
 * removeObserver methods used to maintain the observer lists. Subject use
 * notifyObservers function to notify all the observers in observer list
 * recursively.
 *
 * @author CS505-Group5
 * @version 0.2
 * @since 0.1
 */
public abstract class SubjectSensor {

    /**
     * Represents the list of observers.
     */
    public List<ObserverSensor> observers = new ArrayList<>();

    /**
     * Add an observerSensor o into observer list, as one observer of this
     * class.
     *
     * @param o, type ObserverSensor, sent as a parameter to add as concrete
     * observer
     */
    public void addObserver(ObserverSensor o) {
        this.observers.add(o);
    }

    /**
     * Remove an observerSensor o from existing observer list.
     *
     * @param o, type ObserverDSensor is send as a parameter to delete from
     * list.
     */
    public void removeObserver(ObserverSensor o) {
        this.observers.remove(o);
    }

    /**
     * Notify all the observers, could be overridden by sub-class.
     */
    public void notifyObservers()  {
        this.observers.forEach(ObserverSensor::update);
    }

}
