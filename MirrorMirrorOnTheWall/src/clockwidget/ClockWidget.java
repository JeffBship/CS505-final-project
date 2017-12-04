package clockwidget;

import WeatherWidget.Widget;
import cs505.group1.state.ButtonState;
/**
 *
 * @author James Luczynski
 */
public class ClockWidget extends Widget{
    
    private static ClockWidget clockWidget;    

    private ClockWidget(ButtonState buttonState){
        super(buttonState);
    }
    
    public static ClockWidget getInstance(){
        if (clockWidget == null)
            clockWidget = new ClockWidget(new ClockState());
        return clockWidget;
    }
    
    public void showInactiveState(){}
    
    public void showNoNetworkState(){}
    
    public void singlePress(){
        buttonState.singlePress();
    }
    
    public void doublePress(){
        buttonState.doublePress();
    }
    
    public void longPress(){
        buttonState.longPress();
    }
    
    public String toString(){
        return "CLOCK WIDGET";
    }    
}
