
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

  public static NewsWidget news = new NewsWidget();
  private NewsWidget() {}

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
	news = new NewsWidget();
  }
}
