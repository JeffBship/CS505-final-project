package NewsChainOfResponsibility;

import NewsWidget.Story;
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

  public void setBigFont(SimpleAttributeSet bigFont) {
    this.bigFont = bigFont;
  }

  public SimpleAttributeSet getSmallFont() {
    return smallFont;
  }

  public void setSmallFont(SimpleAttributeSet smallFont) {
    this.smallFont = smallFont;
  }
  
}
