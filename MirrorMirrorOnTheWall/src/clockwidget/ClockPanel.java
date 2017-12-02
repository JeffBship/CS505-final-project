package clockwidget;

import java.awt.Color;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 *
 * @author James Luczynski
 */

//Make panel constructor set bounds through constructor
public class ClockPanel implements Runnable{
    private final JPanel panel;
    private ClockLabel label;
    private ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
    private final int PANEL_X;
    private final int PANEL_Y;
    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;
    private int labelX = 0;  //x-coordinate of label position
    private int labelY = 0;  //y-coordinate of label position
    private int dx = 4;
    private int dy = 4;
    private boolean clockMoving = false;

    
    
    public ClockPanel(int xCoord, int yCoord, int width, int height){
        PANEL_X = xCoord;
        PANEL_Y = yCoord;
        PANEL_WIDTH = width;
        PANEL_HEIGHT = height;
        panel = new JPanel();                                        //create panel
        panel.setSize(PANEL_WIDTH, PANEL_HEIGHT);                    //set size
        panel.setLayout(null);                                       //NO LAYOUT!
        panel.setBackground(Color.BLACK);                            //set background
        panel.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);   //set bounds
    }
    
    public void addClockLabel(ClockLabel clockLabel){         
        label = clockLabel;
        JLabel l = label.getLabel();
        labelX = (PANEL_WIDTH - clockLabel.getWidth())/2;
        labelY = (PANEL_HEIGHT - clockLabel.getHeight())/2;
        panel.add(l);
        l.setBounds(labelX, labelY, clockLabel.getWidth(), clockLabel.getHeight());        
    }    
    
    public void run(){
        label.refreshTime();
        if (clockMoving){
            int gap = Math.abs(dx);
            JLabel l = label.getLabel();
            if (labelX <= gap || (PANEL_WIDTH - (labelX + l.getWidth())) <= gap)
                dx = -dx;
            if (labelY <= gap || (PANEL_HEIGHT - (labelY + l.getHeight())) <= gap)
                dy = -dy;
            labelX += dx;
            labelY += dy;
            label.refreshTime();
            l.setBounds(labelX, labelY, l.getWidth(), l.getHeight());
        }
    }    
    
    private void centerLabel(){
        JLabel l = label.getLabel();
        labelX = (PANEL_WIDTH - label.getWidth())/2;
        labelY = (PANEL_HEIGHT - label.getHeight())/2;
        l.setBounds(labelX, labelY, l.getWidth(), l.getHeight());
    }
    
    public JPanel getPanel(){
        return panel;
    }
    
    public ClockLabel getLabel(){
        return label;
    }
    
    public void singlePress(){
        label.cycleFont();
    }
    
    public void doublePress(){
        label.cycleColor();
    }
    
    public void longPress(){
        label.toggleClock();
        clockMoving = !clockMoving;
        JLabel l = label.getLabel();        
        if (clockMoving){
            exec.shutdown();
            exec = Executors.newSingleThreadScheduledExecutor();
            exec.scheduleAtFixedRate(this, 0, 100, TimeUnit.MILLISECONDS);
        }
        else{
            exec.shutdown();
            exec = Executors.newSingleThreadScheduledExecutor();
            exec.scheduleAtFixedRate(this, 0, 60000, TimeUnit.MILLISECONDS);
            centerLabel();
        }
    }
}
