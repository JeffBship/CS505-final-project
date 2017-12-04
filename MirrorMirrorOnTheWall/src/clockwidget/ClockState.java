package clockwidget;

import cs505.group1.state.ButtonState;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author James Luczynski
 */
public class ClockState extends ButtonState implements Runnable{
    private ClockLabel clockLabel = new ClockLabel();
    private ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
    
    public ClockState(){
        this.GetStatePanel();
        statePanel.add(clockLabel.getLabel());
    }
         
    public void run(){
        clockLabel.refreshTime();
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
        if (clockLabel.isMinutes()){
            exec.shutdown();
            exec = Executors.newSingleThreadScheduledExecutor();
            exec.scheduleAtFixedRate(this, 0, 60000, TimeUnit.MILLISECONDS);
        }
        else{
            exec.shutdown();
            exec = Executors.newSingleThreadScheduledExecutor();
            exec.scheduleAtFixedRate(this, 0, 1000, TimeUnit.MILLISECONDS);
        }
        return this;
    }
    
    public String toString(){
        return "CLOCK STATE";
    }
}
