
package NewsWidget;

import cs505.group1.adapter.*;
import grovepisensors.ButtonPressDistinguisher_for_news;
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
    for(int i=0;i<10;i++){
    System.out.println("\t\t\t\t============== SinglePress in NewsAdapter reached ====================");
    }
    // move the mouse over the frame, then scroll down
    marvin.mouseMove(100,100);
    marvin.mouseWheel(2);
  };
    
  /**
   * Scrolls the webpage down one increment.
   */
  @Override
  public void doublePress(){
    //scroll up
    for(int i=0;i<10;i++){
    System.out.println("\t\t\t\t@@@   @@@@   @@@@@   @@@@@@   @@@@@@   @@@@@@   @@@@  newsAdapter double");
    }
    
    marvin.mouseMove(100,100);
    marvin.mouseWheel(-2);
  };
    
  /**
   * Refresh and return to home
   */
  @Override
  public void longPress(){
    //construct a new newsState.  This refreshes the RSS call, randomizes the news outlet,
    //and sets the scroll to the top
    for(int i=0;i<10;i++){
    System.out.println("\t\t\t\t%%%%%%%%  long newsAdapter  %%%%%%%%  %%%%%%%%  %%%%%%%%  %%%%%%%%  ");
    }
    
    NewsFrame.main(null);
    
    
  };
}
