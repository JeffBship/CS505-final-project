package States;



import WeatherWidget.Weather_Service;
import cs505.group1.state.ButtonState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author melmulcahy
 */
public class HourlyForecastState implements ButtonState {

    @Override
    public ButtonState singlePress() 
    {
        List data = getData();
            
        ((ArrayList<HashMap>)data).forEach((hm) -> 
        {
            int icon = Integer.parseInt(hm.get("Icon").toString());
            int temp = Integer.parseInt(hm.get("Temperature").toString());
            
            String iconImageName = getIconImage(icon);
            
            System.out.println(iconImageName + " " + temp);
        });
        
        return this;
    }

    @Override
    public ButtonState doublePress() {
        List data = getData();
            
        ((ArrayList<HashMap>)data).forEach((hm) -> 
        {
            int icon = Integer.parseInt(hm.get("Icon").toString());
            String phrase = hm.get("IconPhrase").toString();
            
            String iconImageName = getIconImage(icon);
            
            System.out.println(iconImageName + " " + phrase);
        });
        return this;
    }

    @Override
    public ButtonState longPress() 
    {
        return new WeeklyForecastState();
    }
    
    private List getData()
    {
        return Weather_Service.getInstance().GetHourlyForecast();
    }
    
    private String getIconImage(int icon)
    {
        return Weather_Service.getInstance().GetIconImage(icon);
    }
    
}
