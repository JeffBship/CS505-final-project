
package newschainofresponsibility;

import newswidget.Story;
import java.util.ArrayList;
import javax.swing.text.SimpleAttributeSet;

/**
 * failRSS is the end of the RSS Chain of Responsibility.
 * A fail indicator is provided.
 * @author Jeff Blankenship
 */
class FailRSS extends RSShandler{
  
  public FailRSS(){
    rssObject = new RSSobject();
    rssObject.setSuccessor(null);
    rssObject.setStoryList(makeStoryList());
    rssObject.setBigFont("Fail");
    rssObject.setSmallFont("Fail");
  }

  @Override
  protected ArrayList<Story> makeStoryList() {
    
    ArrayList<Story> failList = new ArrayList<>();
    failList.add(new Story("Failed to load any RSS feeds."));
    return failList;
  }
  
  @Override
  public ArrayList<Story> getStoryList() {
    return rssObject.getStoryList();
  }

  @Override
  public SimpleAttributeSet getBigFont(){
    return rssObject.getBigFont();
  };
  
  @Override
  public SimpleAttributeSet getSmallFont(){
    return rssObject.getSmallFont();
  };

  @Override
  protected void setSuccessor(RSShandler rss) {
    //fail can have no successor
    rssObject.setSuccessor(null);
  }
  
}
