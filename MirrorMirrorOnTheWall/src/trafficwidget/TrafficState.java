
package trafficwidget;

import cs505.group1.state.ButtonState;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrafficState implements ButtonState {
    
  public static void main(String[] args){
    try {
      String[] info = TrafficProxyAbstract.loadInfo();
      TrafficFrame.main(info);
    } catch (IOException ex) {
    }
    }
  
    @Override
    public ButtonState singlePress() {
    try {
      //increment destination and reload the frame
      TrafficProxyAbstract.nextDestination();
      String[] info = TrafficProxyAbstract.loadInfo();
      TrafficFrame.main(info);
      
    } catch (IOException ex) {
    }
    return this;
    }

    @Override
    public ButtonState doublePress() {
    try {
      //increment destination and reload the frame
      TrafficProxyAbstract.previousDestination();
      String[] info = TrafficProxyAbstract.loadInfo();
      TrafficFrame.main(info);
    } catch (IOException ex) {
    }
    return this;
    }

    @Override
    public ButtonState longPress() {
      //Not used in this widget
      return this;
    }
    
}
