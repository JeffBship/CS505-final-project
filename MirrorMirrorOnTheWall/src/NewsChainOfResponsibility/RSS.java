package NewsChainOfResponsibility;

import java.util.ArrayList;
import javax.swing.text.SimpleAttributeSet;
import NewsWidget.Story;

/**
 * RSS is the first handler in the Chain of Responsibility.
 * The constructor makes the requests that are passed down the chain.
 * To allow this functionality, RSS is concrete as well as the superclass
 * of the rest of the handlers.
 * @author Jeff Blankenship 
 */
public class RSS extends RSShandler{
  
  public RSS() {
    setSuccessor(new CnnRSS());
    storyList = successor.getStoryList();
    bigFont = successor.getBigFont();
    smallFont = successor.getSmallFont();
  }
  
  @Override
  public ArrayList<Story>  makeStoryList(){
    return new ArrayList<>();
  };
  
  @Override
  public ArrayList<Story> getStoryList(){
    return storyList;
  };
  
  @Override
  public SimpleAttributeSet getBigFont(){
    return bigFont;
  };
  
  @Override
  public SimpleAttributeSet getSmallFont(){
    return smallFont;
  };
  
  public void setSuccessor(RSS rss){
    successor = rss;
  }

  @Override
  void setSuccessor(RSShandler rss){
    successor = rss;
  }
  
}