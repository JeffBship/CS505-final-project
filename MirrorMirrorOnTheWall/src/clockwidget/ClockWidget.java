package clockwidget;

import javax.swing.JFrame;
import WeatherWidget.Widget;
import cs505.group1.state.ButtonState;
import java.awt.Color;
import java.util.Observable;
import javax.swing.JPanel;
/**
 *
 * @author James Luczynski
 */
public class ClockWidget extends Widget{
    
    private static ClockWidget clockWidget = new ClockWidget(new ClockState());
    private boolean clockMoving = false;

    static JFrame frame;// only for main
    

    private ClockWidget(ButtonState buttonState){
        super(buttonState);
    }
    
    public static ClockWidget getInstance(){
        return clockWidget;
    }
    
    public void showInactiveState(){
        if (clockMoving)
            longPress();
    }
    
    public void showNoNetworkState(){
        
    }
    
    public void singlePress(){
        buttonState.singlePress();
    }
    
    public void doublePress(){
        buttonState.doublePress();
    }
    
    public void longPress(){
        clockMoving = !clockMoving;
        buttonState.longPress();
    }
    
    public String toString(){
        return "CLOCK WIDGET";
    }    
    
    public void update(Observable observer, Object object){}
}
