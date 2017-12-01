
package trafficwidget;

import cs505.group1.state.ButtonState;

public class TrafficState implements ButtonState {
    
  public static void main(String[] args){
      //increment destination and reload the frame
      TrafficInterface.nextDestination();
      TrafficInterface.loadInfo();
    }
  
    @Override
    public ButtonState singlePress() {
      //increment destination and reload the frame
      TrafficInterface.nextDestination();
      TrafficInterface.loadInfo();
      return this;
    }

    @Override
    public ButtonState doublePress() {
      //increment destination and reload the frame
      TrafficInterface.nextDestination();
      TrafficInterface.loadInfo();
      return this;
    }

    @Override
    public ButtonState longPress() {
      //Not used in this widget
      return this;
    }
    
}
