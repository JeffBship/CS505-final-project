/*
 *
 */
package cs505.group1.state;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
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
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        statePanel.setPreferredSize(new Dimension(screen.width/2, screen.height/2));
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
