package NewsChainOfResponsibility;

import java.util.ArrayList;
import javax.swing.text.SimpleAttributeSet;
import NewsWidget.Story;

/**
 * RSShandler is the abstract for the RSS Chain of Responsibility.
 * @author Jeff Blankenship 
 */
abstract class RSShandler {
  
  protected RSShandler successor;
  protected ArrayList<Story> storyList = new ArrayList<>();
  protected SimpleAttributeSet bigFont = null;
  protected SimpleAttributeSet smallFont = null;
  
  abstract ArrayList<Story>  makeStoryList();  
  
  abstract ArrayList<Story> getStoryList();
  
  abstract SimpleAttributeSet getBigFont();
  
  abstract SimpleAttributeSet getSmallFont();
  
  abstract void setSuccessor(RSShandler rss);
  
}