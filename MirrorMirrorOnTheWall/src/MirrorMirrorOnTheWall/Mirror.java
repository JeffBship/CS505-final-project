package MirrorMirrorOnTheWall;


import WeatherWidget.Widget;


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
    public static Mirror mirror = new Mirror();
    public Quadrant quadrant;

    /**
     * Constructor for objects of class Mirror
     */
    private Mirror(){}

    /**
     * Adds Widget to mirror
     * @param[in] widget: widget to add
     * 
     * @return void
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
     * @param[in] degree: angle of knob
     * 
     * @return widget
     */
    public Widget SetActive(double degree)
    {
        degree = degree % 360;
        if (degree >= 0.00 && degree < 90.00)
	    setQuadrant(Quadrant.ONE);
            return GetWidget(0);
        else if (degree >= 90.00 && degree < 180.00)
	    setQuadrant(Quadrant.TWO);
            return GetWidget(1);
        else if (degree >= 180.00 && degree < 270.00)
	    setQuadrant(Quadrant.THREE);
            return GetWidget(2);
        else
	    setQuadrant(Quadrant.FOUR);
            return GetWidget(3);
    }
    /**
    * Sets quadrant
    * @param[in] num: quadrant state
    */
    public void setQuadrant(Quadrant num)
    {
	name = num;
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
}
