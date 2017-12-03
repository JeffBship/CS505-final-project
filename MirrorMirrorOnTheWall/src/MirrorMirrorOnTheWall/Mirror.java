package MirrorMirrorOnTheWall;


import WeatherWidget.WeatherWidget;
import WeatherWidget.Widget;
import clockwidget.ClockState;
import clockwidget.ClockWidget;
import com.pi4j.io.i2c.I2CFactory;
import cs505.group1.state.ButtonState;
import grovepisensors.GrovePiSensors;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import newswidget.NewsWidget;
import trafficwidget.TrafficWidget;


/**
 * Control center connecter between widgets and hardware.
 * 
 * @Emily Park 
 * @version 1.0
 */
public class Mirror
{
    private final Widget[] Widgets = new Widget[4];
    private Widget activeWidget;
    public static Mirror mirror = new Mirror();
    private Quadrant quadrant;
    private static JFrame mirrorFrame = new JFrame();
    private static JPanel[] widgetPanels = new JPanel[4];
    
    public static final Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
    public static final Dimension widgetDim = new Dimension(screenDim.width/2-25, screenDim.height/2-25);

    //public static final Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
    //public static final Dimension widgetDim = new Dimension(screenDim.width/2, screenDim.height/2);
    /**
     * Constructor for objects of class Mirror
     */
    private Mirror(){}

    /**
     * Adds Widget to mirror
     * @param widget: widget to add
     */
    public void AddWidget(Widget widget)
    {
        int i = 0;
            while (Widgets[i]!=null)
            {
                i++;
            }
            Widgets[i] = widget;
            
    }
    /**
     * Removes Widget from mirror
     * @param widget widget to remove
     * 
     * @return void
     */
    public boolean RemoveWidget(Widget widget)
    {
        int i = 0;
        boolean removed = false;
        while (i < 4 && removed == false)
        {
            if (Widgets[i] == widget)
            {
                Widgets[i] = null;
                System.out.println("Widget removed");
                removed = true;
            }
            else
            {
                i++;
            }
        }
        return removed;
    }
    /**
     * Gets Widget at specified index
     * @param index index of widget
     * 
     * @return widget
     */
    public Widget GetWidget(int index)
    {
	
        return Widgets[index];
    }
    /**
     * gets the active Widget
     * 
     * @return widget
     */
    public Widget GetActive()
    {
        return activeWidget;
    }
    
    /**
     * Sets the active widget to the given quadrant (from rotary)
     * @param quad : current quadrant (aka. Widget) selected
     */
    public void SetActive(Quadrant quad)
    {
        if (null == quad)
            activeWidget = GetWidget(3);
        else switch (quad) {
            case ONE:
                activeWidget = GetWidget(0);
                break;
            case TWO:
                activeWidget = GetWidget(1);
                break;
            case THREE:
                activeWidget = GetWidget(2);
                break;
            default:
                activeWidget = GetWidget(3);
                break;
        }
    }
    
    /**
     * Gets instance of Mirror object
     * 
     * @return mirror
     */
    public static Mirror GetInstance()
    {
        return mirror;
    }
    public static void ResetSingleton()
    {
        mirror = new Mirror();
    }
    
    /**
     * Main method for the mirror
     * @param args
     * @throws IOException
     * @throws com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException
     * @throws InterruptedException 
     */
    public static void main(String args[]) throws IOException, I2CFactory.UnsupportedBusNumberException, InterruptedException
    {
        //does stuff
        Mirror lmirror = Mirror.GetInstance();
        WeatherWidget weather = WeatherWidget.getInstance();
        NewsWidget news = NewsWidget.GetInstance();
        TrafficWidget traffic = TrafficWidget.getInstance();
        ClockWidget clock = ClockWidget.getInstance();
        
        //for testing 
        weather.singlePress();
        //news.singlePress();
        
        lmirror.AddWidget(weather);
        lmirror.AddWidget(traffic);
        lmirror.AddWidget(news);
        lmirror.AddWidget(clock);
        
        //Make sure that we set the active widget after the widgets are added to the array
        Mirror.GetInstance().SetActive(Quadrant.ONE);
        
        //For testing, feel free to update this from Q1 to any of the quads.

        mirrorFrame = new JFrame();
        
        JPanel mirrorPanel = new JPanel();
        mirrorPanel.setLayout(new GridLayout(2,2,50,50));
        mirrorPanel.setBackground(Color.BLACK);
        //Dimension screen =Toolkit.getDefaultToolkit().getScreenSize();
        mirrorPanel.setPreferredSize(screenDim);
        
        for(int i = 0; i < mirror.Widgets.length; i++){
            widgetPanels[i] = new JPanel();
            widgetPanels[i].add(mirror.GetWidget(i).getState().GetStatePanel());
            widgetPanels[i].setBackground(Color.BLACK);
            mirrorPanel.add(widgetPanels[i]);
        }

        mirrorFrame.add(mirrorPanel);
        mirrorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mirrorFrame.setPreferredSize(screenDim);
        
        //leave it decorated during development.
        //mirrorFrame.setUndecorated(true);
        
        mirrorFrame.getContentPane().setBackground(Color.BLACK);
        //Display the window.
        mirrorFrame.pack();
        mirrorFrame.setVisible(true);
        
       //GrovePiSensors.StartSensors();
       
       //USE THIS TO TEST INVOKING YOUR BUTTON PRESSES TO UPDATE THE UI
       Thread.sleep(10000);
       Mirror.GetInstance().InvokeDoublePress();
       Thread.sleep(10000);
       Mirror.GetInstance().InvokeSinglePress();
    }
    
    /**
     * Invokes the single press method on the active widget
     */
    public void InvokeSinglePress()
    {
        Mirror.GetInstance().GetActive().singlePress();
        UpdateUI();
    }
    
    /**
     * Updates the widget's panel with the new display
     * @param index
     * @param updatedPanel 
     */
    
    private void UpdateWidgetPanel(int index, JPanel updatedPanel)
    {
        widgetPanels[index].removeAll();
        widgetPanels[index].add(updatedPanel);
    }
    
    /**
     * Repaints the mirror frame
     */
    private void RepaintMirrorFrame()
    {
        mirrorFrame.revalidate();
        mirrorFrame.repaint();
    }
    
    //needs to be public for trafficProxy to work
    public  void UpdateUI()
    {
        ButtonState bs = Mirror.GetInstance().GetActive().getState();
        if(Mirror.GetInstance().GetActive() == Mirror.GetInstance().GetWidget(0))
        {
            UpdateWidgetPanel(0, bs.GetStatePanel());
            
        }
        else if(Mirror.GetInstance().GetActive() == Mirror.GetInstance().GetWidget(1))
        {
            
            UpdateWidgetPanel(1, bs.GetStatePanel());
        }
        else if(Mirror.GetInstance().GetActive() == Mirror.GetInstance().GetWidget(2))
        {
            
            UpdateWidgetPanel(2, bs.GetStatePanel());
        }
        else
        {
            UpdateWidgetPanel(3, bs.GetStatePanel());
        }
        RepaintMirrorFrame();
    } 
    
    /**
     * Invokes double press method on active widget
     */
    public void InvokeDoublePress()
    {
        Mirror.GetInstance().GetActive().doublePress();
        UpdateUI();
    }
    
    /**
     * Invokes long press on active widget
     */
    public void InvokeLongPress()
    {
        Mirror.GetInstance().GetActive().longPress();
        UpdateUI();
    }

}
