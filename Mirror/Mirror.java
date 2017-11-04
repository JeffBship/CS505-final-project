
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
    public static final Mirror mirror = new Mirror();

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
            while (Widgets[i] && i < 4)
            {
                i++;
            }
            Widgets[i] = widget;
            System.out.println("Widget added");
    }
    /**
     * Removes Widget from mirror
     * @param[in] widget: widget to remove
     * 
     * @return void
     */
    public void RemoveWidget(Widget widget)
    {
        int i = 0;
        boolean removed = false;
        while (i < 4 && removed = false)
        {
            if (Widgets[i] == widget)
            {
                Widgets[i] = NULL;
                System.out.println("Widget removed");
                removed = true;
            }
            else
            {
                i++;
            }
        }
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
    public Widget SetActive(int degree)
    {
        degree = degree % 360;
        if (degree >= 0 && degree < 90)
            return GetWidget(0);
        else if (degree >= 90 && degree < 180)
            return GetWidget(1);
        else if (degree >= 180 && degree < 270)
            return GetWidget(2);
        else
            return GetWidget(3);
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
}
