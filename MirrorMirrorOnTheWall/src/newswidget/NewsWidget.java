
package newswidget;

import WeatherWidget.Widget;
import cs505.group1.state.ButtonState;
import java.util.Observable;

/**
 *
 * @author Jeff Blankenship
 */
public class NewsWidget extends Widget {

  private static NewsWidget news = null; 
  
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
  if (news==null) news = new NewsWidget(new NewsState());
	return news;
  }
  public static void ResetSingleton()
  {
	news = new NewsWidget(new NewsState());
  }
}
