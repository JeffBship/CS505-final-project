
package NewsWidget;

import cs505.group1.adapter.*;
import java.awt.event.KeyEvent;

/**
 *
 * @author Jeff Blankenship
 */

class NewsAdapter extends ButtonToRobotAdapter{

  //constructor
  NewsState newsState;
  public NewsAdapter(NewsState newsState){
    super(newsState);
  };
  
  /**
     * Scrolls the webpage down one increment.
     */
  @Override
  public void singlePress(){
    // Scroll down
    marvin.mouseWheel(-5);
  };
    
  /**
   * Scrolls the webpage down one increment.
   */
  @Override
  public void doublePress(){
    //scroll up
    marvin.mouseWheel(5);
  };
    
  /**
   * Refresh and return to home
   */
  @Override
  public void longPress(){
    // insert a refresh and return to home (HOME key)
    marvin.keyPress(KeyEvent.VK_F5 );
    marvin.keyRelease(KeyEvent.VK_F5 );
    marvin.keyPress(KeyEvent.VK_HOME );
    marvin.keyRelease(KeyEvent.VK_HOME );
  };
}
