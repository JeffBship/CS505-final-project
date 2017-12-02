
package newswidget;

import cs505.group1.state.ButtonState;

/**
 * @author Jeff Blankenship
 */
public class NewsState extends ButtonState {
  
    private final NewsAdapter newsAdapter = new NewsAdapter(this);
  
    @Override
    public ButtonState singlePress() {
        //scroll down 
        newsAdapter.singlePress();
        return this;
    }

    @Override
    public ButtonState doublePress() {
        //scroll up
        newsAdapter.doublePress();
        return this;
    }

    @Override
    public ButtonState longPress() {
        //refresh using Chain of Responsibility
        newsAdapter.longPress();
        
        return this;
    }
    
    @Override
    public String toString() {
        return "NEWSTATE";
    }
    
}
