package clockwidget;

import MirrorMirrorOnTheWall.Mirror;
import cs505.group1.state.ButtonState;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;


/**
 *
 * @author James Luczynski
 */
public class ClockState extends ButtonState implements Runnable{
    private ClockLabel clockLabel = new ClockLabel();
    private ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
    public static int WIDTH = Mirror.widgetDim.width; //panel width
    public static int HEIGHT = Mirror.widgetDim.height; //panel height
    private int labelX = 0;  //x-coordinate of label position
    private int labelY = 0;  //y-coordinate of label position
    private int dx = 4;
    private int dy = 4;
    private boolean clockMoving = false;
    
    
    public ClockState(){
        this.GetStatePanel();
        statePanel.add(clockLabel.getLabel());
        centerLabel();
    }
         
    public void run(){
        clockLabel.refreshTime();

        int gap = Math.abs(dx);
        JLabel l = clockLabel.getLabel();
        if (labelX <= gap || (WIDTH - (labelX + clockLabel.getWidth())) <= gap)
            dx = -dx;
        if (labelY <= gap || (HEIGHT - (labelY + clockLabel.getHeight())) <= gap)
            dy = -dy;
        labelX += dx;
        labelY += dy;

        l.setBounds(labelX, labelY, clockLabel.getWidth(), clockLabel.getHeight());
    }  
    
    private void centerLabel(){
        JLabel l = clockLabel.getLabel();
        labelX = (WIDTH - clockLabel.getWidth())/2;
        labelY = (HEIGHT - clockLabel.getHeight())/2;
        l.setBounds(labelX, labelY, clockLabel.getWidth(), clockLabel.getHeight());
    }
    
    public ButtonState singlePress(){
        clockLabel.cycleFont();
        return this;
    }
    
    public ButtonState doublePress(){
        clockLabel.cycleColor();
        return this;
    }
    
    public ButtonState longPress(){
        clockLabel.toggleClock();
        clockMoving = !clockMoving;
        JLabel l = clockLabel.getLabel();       
        if (clockMoving){
            exec.shutdown();
            exec = Executors.newSingleThreadScheduledExecutor();
            exec.scheduleAtFixedRate(this, 0, 1000, TimeUnit.MILLISECONDS);
        }
        else{
            exec.shutdown();
            exec = Executors.newSingleThreadScheduledExecutor();
            exec.scheduleAtFixedRate(this, 0, 60000, TimeUnit.MILLISECONDS);
            centerLabel();
        }
        return this;
    }
    
    public String toString(){
        return "CLOCK STATE";
    }
}
