package NewsWidget;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;
import java.util.ArrayList;

public class CnnRSS {
  final String URL = "http://rss.cnn.com/rss/edition.rss";
  ArrayList<Story> storyList = getRSS(URL);
  
  
  public CnnRSS() {
    storyList = getRSS(URL);
  }
  
  public ArrayList<Story> getStoryList(){
    return this.storyList;
  }

  @SuppressWarnings("ConvertToTryWithResources")
  private static ArrayList<Story> getRSS(String url){
    ArrayList<Story> result = new ArrayList<>();
    String source = ""; 
    //loading one object for testing and debugging purposes
    //result.add(new Story("Fake News"));
    //result.get(0).setDescription("It's all make believe.");
      try{
        //designate and open the rss feed
        URL rssUrl = new URL (url);
        InputStreamReader streamReader = new InputStreamReader(rssUrl.openStream());
        BufferedReader reader = new BufferedReader(streamReader);
        //obtain all data from the rss feed, load it into source
        String line; 
        while( (line=reader.readLine()) != null ){
          source += line;
        }
        reader.close();
      //Report IOExceptions associated with the rss stream    
      } catch (IOException ex){
        result.add(new Story("IOException"));
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
      result.add(newStory);
    }
    return result;
  }
}