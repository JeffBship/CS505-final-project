

package trafficwidget;
 
import WeatherWidget.Widget;
import cs505.group1.state.ButtonState;
import java.util.Observable;
 

public class TrafficWidget extends Widget {

  private static TrafficWidget traffic = null;
  
  public TrafficWidget(ButtonState buttonState) {
    super(buttonState);
    this.buttonState = buttonState; 
  }

  @Override
  public void singlePress() {
    ButtonState currentState = getState();
    currentState.singlePress();
    }

  @Override
  public void doublePress() {
    ButtonState currentState = getState();
    currentState.doublePress();
    }

  @Override
  public void longPress() {
    ButtonState currentState = getState();
    currentState.longPress();
    }

  @Override
  public void showInactiveState(){}
  @Override
  public void showNoNetworkState(){}
  @Override
  public String toString(){return null;}
  @Override
  public void update(Observable o, Object arg) {}
  
  public static TrafficWidget getInstance(){
    if (traffic==null){
      traffic = new TrafficWidget(new TrafficState());
    }
    return traffic;
  }
  public static void resetSingleton(){
    traffic = new TrafficWidget(new TrafficState());
  }
  
  

}
