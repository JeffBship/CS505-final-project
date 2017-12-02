package MirrorMirrorOnTheWall;


import WeatherWidget.WeatherWidget;
import WeatherWidget.Widget;
import com.pi4j.io.i2c.I2CFactory;
import grovepisensors.GrovePiSensors;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


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
        if (null == quadrant)
            return GetWidget(3);
        else switch (quadrant) {
            case ONE:
                return GetWidget(0);
            case TWO:
                return GetWidget(1);
            case THREE:
                return GetWidget(2);
            default:
                return GetWidget(3);
        }
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
            case TWO:
                activeWidget = GetWidget(1);
            case THREE:
                activeWidget = GetWidget(2);
            default:
                activeWidget = GetWidget(3);
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
    
    public static void main(String args[]) throws IOException, I2CFactory.UnsupportedBusNumberException, InterruptedException
    {
        //does stuff
        Mirror lmirror = Mirror.GetInstance();
        WeatherWidget weather = WeatherWidget.getInstance();
        
        Mirror.GetInstance().SetActive(Quadrant.ONE);
        //for testing 
        weather.singlePress();
        
        lmirror.AddWidget(weather);
        lmirror.AddWidget(weather);
        lmirror.AddWidget(weather);
        lmirror.AddWidget(weather);
        
        mirrorFrame = new JFrame();
        JPanel mirrorPanel = new JPanel();
        mirrorPanel.setLayout(new GridLayout(2,2,50,50));
        mirrorPanel.setBackground(Color.BLACK);
        Dimension screen =Toolkit.getDefaultToolkit().getScreenSize();
        mirrorPanel.setPreferredSize(screen);
        
        widgetPanels[0] = mirror.GetWidget(0).getState().GetStatePanel();
        widgetPanels[0].setBackground(Color.BLACK);
        mirrorPanel.add(widgetPanels[0]);
        
        widgetPanels[1] = new JPanel();
        widgetPanels[1] .setBackground(Color.RED);
        
        widgetPanels[2]  = new JPanel();
        widgetPanels[2] .setBackground(Color.BLUE);
        
        widgetPanels[3]  = new JPanel();
        widgetPanels[3] .setBackground(Color.GREEN);
        
        mirrorPanel.add(widgetPanels[1] );
        mirrorPanel.add(widgetPanels[2] );
        mirrorPanel.add(widgetPanels[3] );
        
        //TO BE UESD LATER WHEN ALL WIDGERS COMPLY
        
//        for(Widget w : mirror.Widgets)
//        {
//            ButtonState state = w.getState();
//            JPanel sPanel = state.GetStatePanel();
//            sPanel.setPreferredSize(new Dimension((screen.width/4),(screen.height/4)));
//            sPanel.setMaximumSize(sPanel.getPreferredSize());
//            sPanel.setMinimumSize(sPanel.getPreferredSize());
//            mirrorPanel.add(sPanel);
//        }
        mirrorFrame.add(mirrorPanel);
        mirrorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mirrorFrame.setPreferredSize(screen);
        mirrorFrame.setUndecorated(true);
        mirrorFrame.getContentPane().setBackground(Color.BLACK);
        //Display the window.
        mirrorFrame.pack();
        mirrorFrame.setVisible(true);
        
       //GrovePiSensors.StartSensors();
       Thread.sleep(10000);
       Mirror.GetInstance().InvokeDoublePress();
    }
    
    public void InvokeSinglePress()
    {
        Mirror.GetInstance().GetActive().singlePress();
        UpdateUI();
    }
    
    private void UpdateUI()
    {
        if(GetActive() == Mirror.GetInstance().GetWidget(0))
        {
            
            widgetPanels[0] = WeatherWidget.getInstance().getState().GetStatePanel();
            mirrorFrame.revalidate();
            mirrorFrame.repaint();
        }
        else if(GetActive() == Mirror.GetInstance().GetWidget(0))
        {
            mirrorFrame.remove(widgetPanels[2]);
            //mirrorFrame.add(WeatherWidget.getInstance().getState().GetStatePanel());
            mirrorFrame.revalidate();
        }
        else if(GetActive() == Mirror.GetInstance().GetWidget(0))
        {
            mirrorFrame.remove(widgetPanels[2]);
            //mirrorFrame.add(WeatherWidget.getInstance().getState().GetStatePanel());
            mirrorFrame.revalidate();
        }
        else
        {
            mirrorFrame.remove(widgetPanels[3]);
            //mirrorFrame.add(WeatherWidget.getInstance().getState().GetStatePanel());
            mirrorFrame.revalidate();
        }
    } 
    
    public void InvokeDoublePress()
    {
        Mirror.GetInstance().GetActive().doublePress();
        UpdateUI();
    }
    
    public void InvokeLongPress()
    {
        Mirror.GetInstance().GetActive().longPress();
        UpdateUI();
    }

}
