package cs505.group1.weatherstates;


import WeatherWidget.Weather_Service;
import cs505.group1.state.ButtonState;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.*;

/*
 * This handles what information is displayed when the Single Day state is activate. On a single press, the current weather pattern icon and the average temperature will be displayed. On a double press, the description of the forecast will be display. On a long press, the hourly forecast state will be displayed.
 */

/**
 *
 * @author melmulcahy
 */
public class SingleDayForecastState extends WeatherState {

    @Override
    public ButtonState singlePress() {
        ResetStatePanel();
        
        List data = getData();
           
        if(data == null || data.isEmpty())
            return new WeatherInactiveState();
        
       // System.out.println(data);
        
        ((ArrayList<HashMap>)data).forEach((hm) -> 
        { 
            int icon = Integer.parseInt(hm.get("Icon").toString());
            String temp = hm.get("Temperature").toString();
            String tempUnit = hm.get("TemperatureUnit").toString();

            String iconImageName = getIconImage(icon);
           
            ImageIcon iconIMG = AddImage(iconImageName);
            JLabel imgLabel = new JLabel(iconIMG);
            JLabel lblTemp = new JLabel(temp+tempUnit);
            
            lblTemp.setForeground((Color.white));
            statePanel.add(imgLabel);
            statePanel.add(lblTemp);

        });
        
        return this;
    }

    @Override
    public ButtonState doublePress() 
    {
        ResetStatePanel();
        List data = getData();
        
        if(data == null || data.isEmpty())
            return new WeatherInactiveState();
        ((ArrayList<HashMap>)data).forEach((hm) -> 
        {
            
            String desc = hm.get("Text").toString();
            
            JLabel lblDesc = new JLabel(desc);
            
            lblDesc.setForeground((Color.white));
            statePanel.add(lblDesc);
        });
        
        return this;
    }

    @Override
    public ButtonState longPress() {
        return new HourlyForecastState();
    }
    

    
    private double getAvgTemp(double tempA, double tempB)
    {
        return Weather_Service.getInstance().GetTemperatureAverage(tempA, tempB);
    }

    @Override
    public String toString() {
        return "SINGLEDAY";
    }
    
}
