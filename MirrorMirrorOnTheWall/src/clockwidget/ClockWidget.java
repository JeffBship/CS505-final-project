package clockwidget;

import javax.swing.JFrame;
import WeatherWidget.Widget;
import cs505.group1.state.ButtonState;
import java.util.Observable;

/**
 *
 * @author James Luczynski
 */
public class ClockWidget extends Widget{
    
    private ClockPanel panel;
    
    static JFrame frame;
    public static void main(String[] args){
        frame = new JFrame();
        frame.setUndecorated(false);
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        
        ClockPanel p = new ClockPanel();
        ClockLabel l = new ClockLabel();
        System.out.println(l);
        p.addClockLabel(l);
        
        frame.add(p.getPanel());
        frame.setLocation(10, 10);
        frame.setVisible(true);        
    }       
    
    public ClockWidget(ButtonState buttonState){
        super(buttonState);
        panel = new ClockPanel();
        panel.addClockLabel(new ClockLabel());
    }
    
    public void showInactiveState(){
        
    }
    
    public void showNoNetworkState(){
        throw new UnsupportedOperationException("Clock Widget does not require network connection");
    }
    
    public void singlePress(){}
    
    public void doublePress(){}
    
    public void longPress(){}
    
    public String toString(){
        return "";
    }
    
    public void update(Observable observer, Object object){}
}
