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
    
       
    public static void main(String[] args) throws InterruptedException{
        frame = new JFrame();
        ClockState cs = new ClockState();       //create clock state, constructor adds clockLabel 
        ClockWidget cw = new ClockWidget(cs);
        JPanel panel = cs.GetStatePanel();
        frame.setBounds(0, 0, 1000, 1000);
        frame.add(cs.GetStatePanel());
        frame.setBackground(Color.BLUE);
        cs.GetStatePanel().setBounds(0, 0, ClockState.WIDTH, ClockState.HEIGHT);
        frame.setVisible(true);
        Thread.sleep(10000);
        cw.longPress();
        
        Thread.sleep(10000);
        cw.showInactiveState();
    }    
}
