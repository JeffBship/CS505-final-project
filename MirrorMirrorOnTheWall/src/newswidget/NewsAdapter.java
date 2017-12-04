package newswidget;


import static MirrorMirrorOnTheWall.Mirror.screenDim;
import java.awt.AWTException;
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
    try {
      marvin = new Robot();
    } catch (AWTException ex) {
      System.out.println("This will all end in tears.");
    }
  };
  
  /**
     * Scrolls the webpage down one increment.
     */
  public void singlePress(){
    for(int i=0;i<10;i++){
    //System.out.println("\t\t\t\t============== SinglePress in NewsAdapter reached ====================");
    }
    // move the mouse over the frame, then scroll down
    marvin.mouseMove(screenDim.width-50, screenDim.height-50);
    marvin.mouseWheel(2);
  };
    
  /**
   * Scrolls the webpage down one increment.
   */
  public void doublePress(){
    //scroll up
    for(int i=0;i<10;i++){
    //System.out.println("\t\t\t\t@@@   @@@@   @@@@@   @@@@@@   @@@@@@   @@@@@@   @@@@  newsAdapter double");
    }
    marvin.mouseMove(screenDim.width-50, screenDim.height-50);
    marvin.mouseWheel(-2);
  };
    
  /**
   * Refresh and return to home
   */
  public void longPress(){
    //construct a new newsState.  This refreshes the RSS call, randomizes the news outlet,
    //and sets the scroll to the top
    for(int i=0;i<10;i++){
    //System.out.println("\t\t\t\t============== LongPress in NewsAdapter reached ====================");
    }
    //start temperature monitor when things are instantiated.
    
  };
}
