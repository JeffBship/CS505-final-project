package cs505.group1.weatherstates;


import WeatherWidget.Weather_Service;
import cs505.group1.state.ButtonState;
import java.awt.Color;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * This state is utilized by the Weather Widget for when it is not actively selected.
 */

/**
 *
 * @since 11/12/2017
 * @version 2017.11.12.0
 * @author melmulcahy
 */
public class WeatherInactiveState extends WeatherState{

    @Override
    public ButtonState singlePress() {
        showMessage();
        System.out.println("Weather inactive state: SINGLE PRESS");
        return this;
    }

    @Override
    public ButtonState doublePress() {
        showMessage();
        System.out.println("Weather inactive state: DOUBLE PRESS");
        return this;
    }

    @Override
    public ButtonState longPress() {
        showMessage();
        System.out.println("Weather inactive state: LONG PRESS");
        return this;
    }
    
    private void showMessage()
    {
        ResetStatePanel();
        ImageIcon iconIMG = AddImage("error.png");
            JLabel imgLabel = new JLabel(iconIMG);
            JLabel lblTemp = new JLabel("Inactive");
            lblTemp.setForeground((Color.white));
            statePanel.add(imgLabel);
            statePanel.add(lblTemp);
    }
    
    @Override
    public String toString() {
        return "INACTIVE";
    }
    
    /**
     * Gets data from the weather API
     * @return List of information
     */
    @Override
    protected List getData()
    {
        return null;
    }
}
