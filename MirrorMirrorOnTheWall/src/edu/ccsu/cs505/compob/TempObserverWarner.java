package edu.ccsu.cs505.compob;

/**
 * In Observer pattern, this is an abstract class of observer. Also, this class
 * designed by Template pattern, the abstract method warn is the hook method.
 * Each subclass could have their own warn method.
 *
 * @author CS505-Group5
 * @version 0.2
 * @since 0.1
 */
public abstract class TempObserverWarner extends SubjectSensor implements ObserverSensor {

    /**
     * Represents the subject of DHT sensor class.
     */
    public SubjectDHTSensor subject;

    /**
     * Realized from the observer interface. Represents the concrete template
     * method in Template Pattern. Cannot be overridden by sub-class.
     */
    @Override
    public final void update() {
        //Call Hook method;
        hookOb();
    }

    /**
     * Represents the Hook method in Template Pattern.
     * Must be implemented in concrete class.
     */
    public abstract void hookOb();
}
