package States;



import WeatherWidget.Weather_Service;
import cs505.group1.state.ButtonState;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author melmulcahy
 */
public class HourlyDayForcastState implements ButtonState {

    @Override
    public ButtonState singlePress() {
            
        System.out.println("Hourly Day Forcast state: SINLGE PRESS");
        return this;
    }

    @Override
    public ButtonState doublePress() {
        System.out.println("Hourly Day Forcast state: DOUBLE PRESS");
        return this;
    }

    @Override
    public ButtonState longPress() {
        System.out.println("Hourly Day Forcast state: LONG PRESS");
        return this;
    }
    
    private ArrayList<HashMap> getData()
    {
        return Weather_Service.getInstance().GetHourlyForecast();
    }
    
}
