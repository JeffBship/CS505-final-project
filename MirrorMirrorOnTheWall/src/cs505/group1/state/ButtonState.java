/*
 *
 */
package cs505.group1.state;

/**
 * @author CS505 Fall17 Group1
 * @version 2017.10.29
 */
public interface ButtonState {
  
   /**
   * Calls singlePress method of the concrete subclass.
   * @return a ButtonState object set by the concrete subclass.
   */  
  public ButtonState singlePress();
    
  /**
   * Calls doublePress method of the concrete subclass.
   * @return a ButtonState object set by the concrete subclass.
   */  
  public ButtonState doublePress();
    
  /**
   * Calls longPress method of the concrete subclass.
   * @return a ButtonState object set by the concrete subclass.
   */  
  public ButtonState longPress();
   
  
  /**
   * Calls toString method of the concrete subclass.
   * @return a string set by the concrete subclass.
   */  
  @Override
  public String toString();
}
