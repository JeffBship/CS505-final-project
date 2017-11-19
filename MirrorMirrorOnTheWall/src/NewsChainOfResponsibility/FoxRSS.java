package NewsChainOfResponsibility;

import NewsWidget.Story;
import java.net.URL;
import java.io.*;
import java.util.ArrayList;
import javax.swing.text.SimpleAttributeSet;

/**
 * FoxRSS is a concrete handler in the RSS Chain of Responsibility
 * @author Jeff Blankenship 
 */
class FoxRSS extends RSShandler {
    
  public FoxRSS(){
    successor = null;
    //try to get storyList
    storyList = makeStoryList();
    bigFont = Font.bigFOX();
    smallFont = Font.smallFOX();
    //if no storyList, go to successor
    if (storyList.isEmpty() || storyList.get(0).getTitle().equals("IOException") ) {
      successor = new failRSS();
      storyList = successor.getStoryList();
      bigFont = successor.getBigFont();
      smallFont = successor.getSmallFont();
    }
  };
  
  @Override
  public ArrayList<Story>  makeStoryList(){
    ArrayList<Story> foxList = new ArrayList<>();
    String source = ""; 
      try{
        //designate and open the rss feed
        URL url = new URL ("http://feeds.foxnews.com/foxnews/latest");
        //url = new URL ("jeffbship.com"); //for testing, force a fail from this RSShandler
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
        foxList.add(new Story("IOException from FOX"));
      }
    //expressions to look for in parsing FOX stream
    final String FOXHEADER = "]]><";
    final String TITLESTART = "<title>";
    final String TITLEEND = "</title>";
    final String ITEMSTART  = "<description>";
    final String ITEMEND    = "</description>";
    
    //strip the FOX header
    source = source.substring( source.indexOf(FOXHEADER) + FOXHEADER.length());
    
    Story newStory;
    //add another title if one exists
    while ( source.contains(TITLESTART) ){
      //remove leading characters
      source = source.substring( source.indexOf(TITLESTART) + TITLESTART.length());
      //extract the title
      newStory = (new Story( source.substring(0, source.indexOf(TITLEEND))   ));
      //remove the title from source
      source = source.substring( source.indexOf(TITLEEND) + TITLEEND.length() );
      //check if newStory has a description 
      if (source.indexOf(ITEMSTART)<source.indexOf(TITLESTART)){
        //remove, extract,remove as with title
        source = source.substring( source.indexOf(ITEMSTART) + ITEMSTART.length());
        newStory.setDescription(source.substring(0,source.indexOf(ITEMEND)));
        source = source.substring( source.indexOf(ITEMEND) + ITEMEND.length() );
      }
      foxList.add(newStory);
    } 
    return foxList;
  }
  
    
    
    
  @Override
  public ArrayList<Story> getStoryList(){
    return storyList;
  }
  
  @Override
  public SimpleAttributeSet getBigFont(){
    return Font.bigFOX();
  };
  
  @Override
  public SimpleAttributeSet getSmallFont(){
    return smallFont;
  };
  
  @Override
  public void setSuccessor(RSShandler rss){
    successor = rss;
  }
}