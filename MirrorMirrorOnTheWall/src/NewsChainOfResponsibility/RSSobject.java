package NewsChainOfResponsibility;

import NewsWidget.Story;
import cs505.group1.font.FontFactory;
import java.util.ArrayList;
import javax.swing.text.SimpleAttributeSet;

/**
 * This object holds the information needed by each RSS handler.
 * @author Jeff Blankenship
 */
class RSSobject {
  
  private RSShandler successor;
  private ArrayList<Story> storyList = new ArrayList<>();
  private SimpleAttributeSet bigFont = null;
  private SimpleAttributeSet smallFont = null;

  public RSShandler getSuccessor() {
    return successor;
  }

  public void setSuccessor(RSShandler successor) {
    this.successor = successor;
  }

  public ArrayList<Story> getStoryList() {
    return storyList;
  }

  public void setStoryList(ArrayList<Story> storyList) {
    this.storyList = storyList;
  }

  public SimpleAttributeSet getBigFont() {
    return bigFont;
  }

  public void setBigFont(String type) {
    this.bigFont = FontFactory.createBig(type);
  }

  public SimpleAttributeSet getSmallFont() {
    return smallFont;
  }

  public void setSmallFont(String type) {
    this.smallFont = FontFactory.createSmall(type);
  }
  
}
