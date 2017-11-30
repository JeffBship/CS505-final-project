package NewsChainOfResponsibility;

import java.awt.Color;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 * Globally accessible fonts for use in StyleDocuments within swing components.
 * 
 * A special thanks to "camicker" on Stackoverflow for helping with 
 * this method through responding to my question at 
 * https://stackoverflow.com/questions/47372655/attributeset-construction/47373016#47373016
 * camickr's profile:  https://stackoverflow.com/users/131872/camickr
 * 
 * @author Jeff Blankenship
 */
public class Font {
  
  public SimpleAttributeSet big;
  public SimpleAttributeSet small;

  public static SimpleAttributeSet bigCNN() {
    SimpleAttributeSet result = new SimpleAttributeSet();
    StyleConstants.setFontFamily(result,"Helvetica Bold");
    StyleConstants.setFontSize(result, 40);
    StyleConstants.setForeground(result, Color.red);
    return result;
  }
  
  public static SimpleAttributeSet smallCNN() {
    SimpleAttributeSet result = new SimpleAttributeSet();
    StyleConstants.setFontFamily(result,"Helvetica ");
    StyleConstants.setFontSize(result, 30);
    StyleConstants.setForeground(result, Color.white);
    return result;
  }
  
  public static SimpleAttributeSet bigFOX() {
    SimpleAttributeSet result = new SimpleAttributeSet();
    StyleConstants.setFontFamily(result,"FF Good OT Black");
    StyleConstants.setFontSize(result, 40);
    StyleConstants.setForeground(result, Color.blue);
    return result;
  }
  
  public static SimpleAttributeSet smallFOX() {
    SimpleAttributeSet result = new SimpleAttributeSet();
    StyleConstants.setFontFamily(result,"ITC Avant Garde Gothic");
    StyleConstants.setFontSize(result, 30);
    StyleConstants.setForeground(result, Color.LIGHT_GRAY);
    return result;
  }
  
  public static SimpleAttributeSet bigFAIL() {
    SimpleAttributeSet result = new SimpleAttributeSet();
    StyleConstants.setFontFamily(result,"Helvetica Bold");
    StyleConstants.setFontSize(result, 40);
    StyleConstants.setForeground(result, Color.GREEN);
    return result;
  }
  
  public static SimpleAttributeSet smallFAIL() {
    SimpleAttributeSet result = new SimpleAttributeSet();
    StyleConstants.setFontFamily(result,"Helvetica ");
    StyleConstants.setFontSize(result, 30);
    StyleConstants.setForeground(result, Color.GREEN);
    return result;
  }

 

}