/*
 *
 */
package cs505.group1.state;

import static MirrorMirrorOnTheWall.Mirror.widgetDim;
import java.awt.Color;
import javax.swing.JPanel;

/**
 * @author CS505 Fall17 Group1
 * @version 2017.10.29
 */
public abstract class ButtonState {
    protected JPanel statePanel = new JPanel();
  
    /**
     * removes all objects from the JPanel
     */
    protected void ResetStatePanel(){
        statePanel.removeAll();
    }
    
    public JPanel GetStatePanel(){
        statePanel.setBackground(Color.BLACK);
        statePanel.setPreferredSize(widgetDim);
        return statePanel;
    }
  
   /**
    * 
   * Calls singlePress method of the concrete subclass.
   * @return a ButtonState object set by the concrete subclass.
   */  
  public abstract ButtonState singlePress();
    
  /**
   * Calls doublePress method of the concrete subclass.
   * @return a ButtonState object set by the concrete subclass.
   */  
  public abstract ButtonState doublePress();
    
  /**
   * Calls longPress method of the concrete subclass.
   * @return a ButtonState object set by the concrete subclass.
   */  
  public abstract ButtonState longPress();
   
  
  /**
   * Calls toString method of the concrete subclass.
   * @return a string set by the concrete subclass.
   */  
  @Override
  public abstract String toString();
}
