
package newswidget;

import WeatherWidget.Widget;
import cs505.group1.state.ButtonState;
import java.util.Observable;

/**
 *
 * @author Jeff Blankenship
 */
public class NewsWidget extends Widget {

  public static NewsWidget news = new NewsWidget(new NewsState());
  private NewsWidget(ButtonState buttonState) {
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
  public String toString(){return "NEWS";}
  @Override
  public void update(Observable o, Object arg) {}
  
  public static NewsWidget GetInstance()
  {
	return news;
  }
  public static void ResetSingleton()
  {
	news = new NewsWidget(new NewsState());
  }
}
