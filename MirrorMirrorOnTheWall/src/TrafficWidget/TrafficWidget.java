

package trafficwidget;
 
import WeatherWidget.Widget;
import cs505.group1.state.ButtonState;
import java.util.Observable;
 

public class TrafficWidget extends Widget {

  public TrafficWidget(ButtonState buttonState) {
    super(buttonState);
    TrafficFrame.main(null);
  }

  @Override
  public void singlePress() {
    this.buttonState.singlePress();
    }

  @Override
  public void doublePress() {
    this.buttonState.doublePress();
    }

  @Override
  public void longPress() {
    this.buttonState.longPress();
    }

  @Override
  public void showInactiveState(){}
  @Override
  public void showNoNetworkState(){}
  @Override
  public String toString(){return null;}
  @Override
  public void update(Observable o, Object arg) {}
  

}
