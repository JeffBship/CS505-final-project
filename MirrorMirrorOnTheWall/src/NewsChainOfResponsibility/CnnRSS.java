package NewsChainOfResponsibility;

import NewsWidget.Story;
import cs505.group1.font.Font;
import java.net.URL;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
/**
 * CnnRSS is a concrete handler in the RSS Chain of Responsibility.
 * It provides news from http://rss.cnn.com/rss/edition.rss
 * licensed for non-commercial use by TERMS OF USE at 
 * http://www.cnn.com/services/rss/#terms
 * 
 * @author Jeff Blankenship 
 */
class CnnRSS extends RSShandler {
    
  public CnnRSS(){
    rssObject = new RSSobject();
    rssObject.setSuccessor(null);
    rssObject.setStoryList(makeStoryList());
    rssObject.setBigFont(Font.bigCnn());
    rssObject.setSmallFont(Font.smallCnn());
  }
  
  @Override
  public ArrayList<Story>  makeStoryList(){
    ArrayList<Story> cnnList = new ArrayList<>();
    String source = ""; 
      try{
        //designate and open the rss feed, ramdom bad url to exercise the chain
        URL url;
        if (new Random().nextInt(100)<FAILRATE){
          url = new URL("http://JeffBlankenship.com");
        }else{
          url = new URL ("http://rss.cnn.com/rss/edition.rss");
        }
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
  }
}