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
public class WeeklyForecastState implements ButtonState {

    @Override
    public ButtonState singlePress() {
        List data = getData();
            
        if(data != null){
        ((ArrayList<HashMap>)data).forEach((hm) -> 
        {
            int icon = Integer.parseInt(hm.get("Icon").toString());
            double tempMin = Double.parseDouble(hm.get("TempMax").toString());
            double tempMax = Double.parseDouble(hm.get("TempMin").toString());
        
            String iconImageName = getIconImage(icon);
            double avgTemp = getAvgTemp(tempMin, tempMax);
            
            System.out.println(iconImageName + " " + avgTemp);
        });
        }
        else
        {
            System.out.println("");
        }
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
    public ButtonState longPress() {
        return new SingleDayForecastState();
    }
    
    private String getIconImage(int icon)
    {
        return Weather_Service.getInstance().GetIconImage(icon);
    }
    
    private List getData()
    {
        return Weather_Service.getInstance().GetWeeklyForecast();
    }
    
    private double getAvgTemp(double tempA, double tempB)
    {
        return Weather_Service.getInstance().GetTemperatureAverage(tempA, tempB);
    }
    
}
