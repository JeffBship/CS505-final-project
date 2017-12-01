package NewsChainOfResponsibility;

import java.util.ArrayList;
import javax.swing.text.SimpleAttributeSet;
import NewsWidget.Story;

/**
 * RSShandler is the abstract for the RSS Chain of Responsibility.
 * !! Note:  It is critical that clients access the Chain via RSS Constructor !!
 * This CoR obtains a ArrayList of Story objects from a group of handlers
 * which each parse an assigned RSS feed from a news organization.  Each handler
 * uses a customized parsing algorithm to build the story list, since each news 
 * organization formats their RSS differently.<br>
 * <br>
 * To remain unbiased in news reporting, the successor order is 
 * randomized each time the RSS constructor is activated.<br>
 * <br>
 * To demonstrate the value of the CoR, an artificial fail rate is used which 
 * will force the handlers to pass the request to their successor that percent
 * of the time.  This is in addition to the passing  criteria of any IOexception 
 * or failure to find any story.
 * 
 * 
 * @author Jeff Blankenship 
 */
abstract class RSShandler {
  
  protected final int FAILRATE = 30;  //simulated fail percentage
  
  protected int position;  //the position of the handler in the chain
  
  protected RSSobject rssObject;
  
  protected abstract ArrayList<Story>  makeStoryList();  
  
  
  public ArrayList<Story> getStoryList() {
    //if this storyList is bad, go to successor
    if (rssObject.getStoryList().isEmpty() 
      || rssObject.getStoryList().get(0).getTitle().equals("IOException") ) 
      {
      return rssObject.getSuccessor().getStoryList();
      }else{
      //else use this.
      return rssObject.getStoryList();
    }
  }


  public SimpleAttributeSet getBigFont(){
    //if this storyList is bad, go to successor
    if (rssObject.getStoryList().isEmpty() 
      || rssObject.getStoryList().get(0).getTitle().equals("IOException") ) 
      {
      return rssObject.getSuccessor().getBigFont();
      }else{
      //else use this.
      return rssObject.getBigFont();
    }
  }
  
 

  public SimpleAttributeSet getSmallFont(){
    //if this storyList is bad, go to successor
    if (rssObject.getStoryList().isEmpty() 
      || rssObject.getStoryList().get(0).getTitle().equals("IOException") ) 
      {
      return rssObject.getSuccessor().getSmallFont();
      }else{
      //else use this.
      return rssObject.getSmallFont();
    }
  }

  protected void setSuccessor(RSShandler rss) {
    rssObject.setSuccessor(rss);
  }
  
}
  