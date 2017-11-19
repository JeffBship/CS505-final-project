package NewsWidget;

import cs505.group1.state.ButtonState;

/**
 * @author Jeff Blankenship
 */
public class NewsState implements ButtonState {
  
    

    @Override
    public ButtonState singlePress() {
        //scroll down 
        return this;
    }

    @Override
    public ButtonState doublePress() {
        //scroll up
        return this;
    }

    @Override
    public ButtonState longPress() {
        //refresh using Chain of Responsibility
        return this;
    }
    
}
