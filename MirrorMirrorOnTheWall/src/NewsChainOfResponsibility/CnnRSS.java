package NewsChainOfResponsibility;

import NewsWidget.Story;
import java.net.URL;
import java.io.*;
import java.util.ArrayList;
import javax.swing.text.SimpleAttributeSet;

/**
 * CnnRSS is a concrete handler in the RSS Chain of Responsibility
 * @author Jeff Blankenship 
 */
class CnnRSS extends RSShandler {
    
  public CnnRSS(){
    successor = null;
    //try to get storyList
    storyList = makeStoryList();
    bigFont = Font.bigCNN();
    smallFont = Font.smallCNN();
    //if no storyList, go to successor
    if (storyList.isEmpty() || storyList.get(0).getTitle().equals("IOException") ) {
      successor = new FoxRSS();
      storyList = successor.getStoryList();
      bigFont = successor.getBigFont();
      smallFont = successor.getSmallFont();
    }
  };
  
  @Override
  public ArrayList<Story>  makeStoryList(){
    ArrayList<Story> cnnList = new ArrayList<>();
    String source = ""; 
      try{
        //designate and open the rss feed
        URL url = new URL ("http://rss.cnn.com/rss/edition.rss");
        url = new URL ("jeffbship.com"); //for testing, force a fail from this RSShandler
        
        InputStreamReader streamReader = new InputStreamReader(url.openStream());
        BufferedReader reader = new BufferedReader(streamReader);
        //obtain all data from the rss feed, load it into source
        String line; 
        while( (line=reader.readLine()) != null ){
          source += line;
        }
        reader.close();
      //Report IOExceptions associated with the rss stream    
      } catch (IOException ex){
        cnnList.add(new Story("IOException"));
      }
    //expressions to look for in parsing the stream
    final String TITLESTART = "<title><![CDATA[";
    final String TITLEEND   = "]]></title>";
    final String DESCSTART  = "<description><![CDATA[";
    final String DESCEND    = "]]></description>";
    //add another title if one exists
    Story newStory;
    while ( source.contains(TITLESTART) ){
      //remove leading characters
      source = source.substring( source.indexOf(TITLESTART) + TITLESTART.length());
      //extract the title
      newStory = (new Story( source.substring(0, source.indexOf(TITLEEND))   ));
      //remove the title from source
      source = source.substring( source.indexOf(TITLEEND) + TITLEEND.length() );
      //check if newStory has a description 
      if (source.indexOf(DESCSTART)<source.indexOf(TITLESTART)){
        //remove, extract,remove as with title
        source = source.substring( source.indexOf(DESCSTART) + DESCSTART.length());
        newStory.setDescription(source.substring(0,source.indexOf(DESCEND)));
        source = source.substring( source.indexOf(DESCEND) + DESCEND.length() );
      }
      cnnList.add(newStory);
    }
    return cnnList;
  };
  
  
  @Override
  public ArrayList<Story> getStoryList(){
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
  void setSuccessor(RSShandler rss){
    successor = rss;
  }

}