package MirrorMirrorOnTheWall;


import WeatherWidget.Widget;
import cs505.group1.state.ButtonState;
import java.util.Observable;


/**
 * Control center connecter between widgets and hardware.
 * 
 * @Emily Park 
 * @version 1.0
 */
public class Mirror
{
    private Widget[] Widgets = new Widget[4];
    private Widget activeWidget;
    private static Mirror mirror;
    private Quadrant quadrant;

  

    /**
     * Adds Widget to mirror
     * @param[in] widget: widget to add
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
     * @param[in] widget: widget to remove
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
     * @param[in] index: index of widget
     * 
     * @return widget
     */
    public Widget GetWidget(int index)
    {	
        return Widgets[index];
    }
    
    /**
     * Sets active Widget
     * @return the active widget
     */
    public Widget SetActive()
    {
        if (quadrant == Quadrant.ONE)
            return GetWidget(0);
        else if (quadrant == Quadrant.TWO)
            return GetWidget(1);
        else if (quadrant == Quadrant.THREE)
            return GetWidget(2);
        else
            return GetWidget(3);
    }
    
    /**
     * Sets active widget based on quadrant parameter
     * @param quadrant the new quadrant identified by RotaryStateDeterminer class
     */
    public void setActiveWidget(Quadrant quadrant){
        this.quadrant = quadrant;
        switch (quadrant){
            case ONE:
                activeWidget = Widgets[0];
            case TWO:
                activeWidget = Widgets[1];
            case THREE:
                activeWidget = Widgets[2];
            case FOUR:
                activeWidget = Widgets[3];
        }
    }
    
    /**
     * Gets instance of Mirror object
     * 
     * @return mirror
     */
    public static Mirror GetInstance()
    {
        if (mirror != null)
            mirror = new Mirror();
        return mirror;
    }
    
    public static void ResetSingleton()
    {
        mirror = new Mirror();
    }
    
    /**
     * Invokes singlePress method on active widget
     */
    public void singlePress(){
        activeWidget.singlePress();
    }
    /**
     * Invokes doublePress method on active widget
     */
    public void doublePress(){
        activeWidget.doublePress();
    }
    /**
     * Invokes longPress method on active widget
     */
    public void longPress(){
        activeWidget.longPress();
    }

    
}
