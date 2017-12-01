package States;


import WeatherWidget.Weather_Service;
import cs505.group1.state.ButtonState;
import java.util.HashMap;
import java.util.Map;

/*
 * This handles what information is displayed when the Single Day state is activate. On a single press, the current weather pattern icon and the average temperature will be displayed. On a double press, the description of the forecast will be display. On a long press, the hourly forecast state will be displayed.
 */

/**
 *
 * @author melmulcahy
 */
public class SingleDayForecastState implements ButtonState {

    @Override
    public ButtonState singlePress() {
        Map data = getData();
        
        System.out.println(data);
        if(!data.isEmpty())
        {
            int icon = Integer.parseInt(data.get("Icon").toString());
            double tempMin = Double.parseDouble(data.get("TempMax").toString());
            double tempMax = Double.parseDouble(data.get("TempMin").toString());

            String iconImageName = getIconImage(icon);
            double avgTemp = getAvgTemp(tempMin, tempMax);

            System.out.println(iconImageName + " " + avgTemp);
            return this;
        }
        System.out.println("ERROR");
        return new WeatherInactiveState();
    }

    @Override
    public ButtonState doublePress() 
    {
        Map data = getData();
        
        String desc = data.get("Text").toString();
        
        System.out.println(desc);
        return this;
    }

    @Override
    public ButtonState longPress() {
        return new HourlyForecastState();
    }
    
    private String getIconImage(int icon)
    {
        return Weather_Service.getInstance().GetIconImage(icon);
    }
    
    private Map getData()
    {
        return Weather_Service.getInstance().GetDailyForecast();
    }
    
    private double getAvgTemp(double tempA, double tempB)
    {
        return Weather_Service.getInstance().GetTemperatureAverage(tempA, tempB);
    }
    
}
