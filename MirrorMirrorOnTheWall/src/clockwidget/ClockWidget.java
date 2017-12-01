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
    
    static JFrame frame;// only for main
    
    public static void main(String[] args) throws InterruptedException{
        frame = new JFrame();                   //create frame
        frame.setSize(800, 800);              //size 1000 x 1000
        frame.setUndecorated(true);             //no top menu bar
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //GridLayout g = new GridLayout(2,2);
        frame.setLayout(null);
        
        ClockPanel p = new ClockPanel(0, 0, 200, 200);
        //ClockPanel q = new ClockPanel(350, 0, 300, 300);
        
        //ClockLabel r = new ClockLabel();
        ClockLabel l = new ClockLabel();
        p.addClockLabel(l);
        //q.addClockLabel(r);
        
        frame.add(p.getPanel());
       // frame.add(q.getPanel());
        
        frame.setLocation(100, 100);
        frame.setVisible(true);      
        p.longPress();    
        Thread.sleep(2000);
       // p.singlePress();
        Thread.sleep(2000);
        p.doublePress();
        Thread.sleep(10000);
        p.longPress();
        p.singlePress();
        Thread.sleep(100);
        p.singlePress();
    }       
    
    
    
    
    
    public ClockWidget(ButtonState buttonState){
        super(buttonState);
        panel = new ClockPanel(0,0,200,200);
        panel.addClockLabel(new ClockLabel());
    }
    
    public void showInactiveState(){
        
    }
    
    public void showNoNetworkState(){
        
    }
    
    public void singlePress(){}
    
    public void doublePress(){}
    
    public void longPress(){}
    
    public String toString(){
        return "";
    }    
    public void update(Observable observer, Object object){}
}
