package cs505.group1.adapter;

import cs505.group1.state.ButtonState;
import java.awt.Robot;

/**
 * @author Jeff Blankenship
 * 
 * This is an Adapter design pattern which adapts button methods
 * of the state package to keyboard input for the NewsWidget.  In this
 * implementation the Adapter does not implement an interface, instead it 
 * sends keyboard events to the input buffer using marvin the robot.
 * 
 * Client is a widget that requires keyboard input: NewsWidget
 * Adaptee is a ButtonState concrete subclass:  NewsState
 * 
 * 
 * A robot is used to create keyboard or mouse input
 * Robot javadoc is at https://docs.oracle.com/javase/7/docs/api/java/awt/Robot.html
 * List of KeyEvents is at https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html
 * 
 */

public abstract class ButtonToRobotAdapter {
  
  public static Robot marvin;
  
  //constructor
  ButtonState buttonState;
  public ButtonToRobotAdapter(ButtonState buttonState){
    this.buttonState = buttonState;
  };
  
  public abstract void singlePress();
    
  public abstract void doublePress();
    
  public abstract void longPress();
  
}
