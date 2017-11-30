
package NewsWidget;


import edu.ccsu.cs505.compob.OBComponentDemo;
import java.awt.Robot;

/**
 *
 * @author Jeff Blankenship
 */

class NewsAdapter{

  //Robot provides interaction with system.IO
  private static Robot marvin;
  
  //constructor
  NewsState newsState;
  public NewsAdapter(NewsState newsState){
    this.newsState = newsState;
  };
  
  /**
     * Scrolls the webpage down one increment.
     */
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
  public void longPress(){
    //construct a new newsState.  This refreshes the RSS call, randomizes the news outlet,
    //and sets the scroll to the top
    NewsFrame.main(null);
    //start temperature monitor when things are instantiated.
    try {
      OBComponentDemo.main(null);
    } catch (InterruptedException ex) {
    } catch (Exception ex) {
    }
  };
}
