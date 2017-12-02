package MirrorMirrorOnTheWall;


import WeatherWidget.WeatherWidget;
import WeatherWidget.Widget;
import cs505.group1.state.ButtonState;
import javax.swing.*;
import java.awt.*;


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
        if (null == quadrant)
            activeWidget = GetWidget(3);
        else switch (quadrant) {
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
    
    public static void main(String args[])
    {
        //does stuff
        Mirror mirror = Mirror.GetInstance();
        WeatherWidget weather = WeatherWidget.getInstance();
        //for testing 
        weather.singlePress();
        
        mirror.AddWidget(weather);
        mirror.AddWidget(weather);
        mirror.AddWidget(weather);
        mirror.AddWidget(weather);
        
        mirrorFrame = new JFrame();
        JPanel mirrorPanel = new JPanel();
        mirrorPanel.setLayout(new GridLayout(2,2,50,50));
        mirrorPanel.setBackground(Color.BLACK);
        Dimension screen =Toolkit.getDefaultToolkit().getScreenSize();
        mirrorPanel.setPreferredSize(screen);
        
        JPanel spanel = mirror.GetWidget(0).getState().GetStatePanel();
        spanel.setBackground(Color.BLACK);
        mirrorPanel.add(spanel);
        
        JPanel test1 = new JPanel();
        test1.setBackground(Color.RED);
        
        JPanel test2 = new JPanel();
        test2.setBackground(Color.BLUE);
        JPanel test3 = new JPanel();
        test3.setBackground(Color.GREEN);
        
        mirrorPanel.add(test1);
        mirrorPanel.add(test2);
        mirrorPanel.add(test3);
        
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
    }
    

}
