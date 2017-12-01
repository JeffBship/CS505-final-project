
package newswidget;

import WeatherWidget.Widget;
import cs505.group1.state.ButtonState;
import edu.ccsu.cs505.compob.OBComponent;
import java.util.Observable;

/**
 *
 * @author Jeff Blankenship
 */
public class NewsWidget extends Widget {

  public NewsWidget(ButtonState buttonState) {
    super(buttonState);
    
    
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
