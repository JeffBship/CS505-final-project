/*
 */
package cs505.group1.state;

/**
 * @author CS505 Fall17 Group1
 * @version 2017.10.29
 */
public abstract class ButtonContext {
    
    private ButtonState buttonState;
    
    
    /**
     * Implements code for a single button press.
     * @return State allows a state change 
     */
    public abstract void singlePress();
    
    /**
     * Implements code for a double button press.
     * @return State allows a state change 
     */
    public abstract void doublePress();
    
    /**
     * Implements code for a long button press.
     * @return State allows a state change 
     */
    public abstract void longPress();
    
    /**
     * Sets the state to be equal to the passed State.
     * @param newState 
     */
    public void setState(ButtonState  newState){
        buttonState = newState;
    }
    
    /**
     * Gets the current state.
     * @return State
     */
    public ButtonState getState(){
    
        return buttonState;
    }
    
    /**
     * Invokes the toString method of the concrete class for the
     * current state.  
     * @return A string description of the context or a null string.
     */
    public abstract String toString();
    
}
