package newschainofresponsibility;

import java.util.ArrayList;
import newswidget.Story;
import java.util.Collections;

/**
 * RSS is the first handler in the Chain of Responsibility.
 * The constructor builds the chain and makes the requests that are 
 * passed down the chain, providing familiar and transparent functionality
 * to the user.
 * @author Jeff Blankenship 
 */
public class RSS extends RSShandler{
  
  public RSS() {
    
    rssObject = new RSSobject();
    
    //build the chain, an ArrayList<RSShandler>
    ArrayList<RSShandler> rssChain = new ArrayList<>();
    rssChain.add(new CnnRSS());
    rssChain.add(new FoxRSS());
    
    //shuffle the list...no biased reporting here!!
    Collections.shuffle(rssChain);
    
    //add the failRSS on the end of the shuffled list
    rssChain.add(new FailRSS());
    
    //assign the successors
    this.rssObject.setSuccessor(rssChain.get(0));
    for( int i=0; i<rssChain.size()-1; i++ ){
      rssChain.get(i).rssObject.setSuccessor(rssChain.get(i+1));
    }
  }
    
  @Override
  protected ArrayList<Story>  makeStoryList(){
    return new ArrayList<>();
  };
  
}