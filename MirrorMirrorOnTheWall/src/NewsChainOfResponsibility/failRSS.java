/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewsChainOfResponsibility;

import NewsWidget.Story;
import java.util.ArrayList;
import javax.swing.text.SimpleAttributeSet;

/**
 * failRSS is the end of the RSS Chain of Responsibility.
 * A fail indicator is returned.
 * @author Jeff Blankenship
 */
class failRSS extends RSShandler{
  
  public failRSS(){
    successor = null;
    storyList = makeStoryList();
    bigFont = Font.bigFAIL();
    smallFont = Font.smallFAIL();
  };

  @Override
  ArrayList<Story> makeStoryList() {
    
    ArrayList<Story> failList = new ArrayList<>();
    failList.add(new Story("Failed to load any RSS feeds."));
    System.out.println("in failRSS make list" + failList.toString());
    return failList;
  }
  
  @Override
  ArrayList<Story> getStoryList() {
    return storyList;
  }

  @Override
  public SimpleAttributeSet getBigFont(){
    return bigFont;
  };
  
  @Override
  public SimpleAttributeSet getSmallFont(){
    return smallFont;
  };

  @Override
  void setSuccessor(RSShandler rss) {}
  
}
