package cs505.group1.font;

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
public class FontFactory extends SimpleAttributeSet{
    
  public static SimpleAttributeSet createBig(String type){
    SimpleAttributeSet result;
    type = type.toUpperCase();
    switch (type){
      case "CNN":  result = bigCnn();       break;
      case "FOX":  result = bigFox();       break;
      case "FAIL": result = bigFail();      break;
      default:     result = defaultFont();  break;
    }
    return result;
  }
  
  public static SimpleAttributeSet createSmall(String type){
    SimpleAttributeSet result;
    type = type.toUpperCase();
    switch (type){
      case "CNN":  result = smallCnn();     break;
      case "FOX":  result = smallFox();     break;
      case "FAIL": result = smallFail();    break;
      case "TRAFFIC": result = smallTraffic();    break;
      
      default:     result = defaultFont();  break;
    }
    return result;
  }

  private static SimpleAttributeSet bigCnn() {
    SimpleAttributeSet result = new SimpleAttributeSet();
    StyleConstants.setFontFamily(result,"Helvetica Bold");
    StyleConstants.setFontSize(result, 40);
    StyleConstants.setForeground(result, Color.red);
    return result;
  }
  
  private static SimpleAttributeSet smallCnn() {
    SimpleAttributeSet result = new SimpleAttributeSet();
    StyleConstants.setFontFamily(result,"Helvetica ");
    StyleConstants.setFontSize(result, 20);
    StyleConstants.setForeground(result, Color.white);
    return result;
  }
  
  private static SimpleAttributeSet bigFox() {
    SimpleAttributeSet result = new SimpleAttributeSet();
    StyleConstants.setFontFamily(result,"FF Good OT Black");
    StyleConstants.setFontSize(result, 30);
    StyleConstants.setForeground(result, Color.blue);
    return result;
  }
  
  private static SimpleAttributeSet smallFox() {
    SimpleAttributeSet result = new SimpleAttributeSet();
    StyleConstants.setFontFamily(result,"ITC Avant Garde Gothic");
    StyleConstants.setFontSize(result, 20);
    StyleConstants.setForeground(result, Color.LIGHT_GRAY);
    return result;
  }
  
  private static SimpleAttributeSet bigFail() {
    SimpleAttributeSet result = new SimpleAttributeSet();
    StyleConstants.setFontFamily(result,"Helvetica Bold");
    StyleConstants.setFontSize(result, 30);
    StyleConstants.setForeground(result, Color.GREEN);
    return result;
  }
  
  private static SimpleAttributeSet smallFail() {
    SimpleAttributeSet result = new SimpleAttributeSet();
    StyleConstants.setFontFamily(result,"Helvetica ");
    StyleConstants.setFontSize(result, 20);
    StyleConstants.setForeground(result, Color.GREEN);
    return result;
  }
  
  private static SimpleAttributeSet smallTraffic() {
    SimpleAttributeSet result = new SimpleAttributeSet();
    StyleConstants.setFontFamily(result,"Helvetica ");
    StyleConstants.setFontSize(result, 30);
    StyleConstants.setForeground(result, Color.CYAN);
    return result;
  }
  
  private static SimpleAttributeSet defaultFont() {
    SimpleAttributeSet result = new SimpleAttributeSet();
    StyleConstants.setFontFamily(result,"Times New Roman");
    StyleConstants.setFontSize(result, 20);
    StyleConstants.setForeground(result, Color.YELLOW);
    return result;
  }
  
}