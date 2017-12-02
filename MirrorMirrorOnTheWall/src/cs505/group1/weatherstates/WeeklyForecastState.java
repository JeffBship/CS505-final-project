package cs505.group1.weatherstates;


import WeatherWidget.Weather_Service;
import cs505.group1.state.ButtonState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author melmulcahy
 */
public class WeeklyForecastState extends WeatherState implements ButtonState {

    @Override
    public ButtonState singlePress() {
        ResetStatePanel();
        List data = getData();
            
        if(data == null || data.isEmpty()){
        ((ArrayList<HashMap>)data).forEach((hm) -> 
        {
            int icon = Integer.parseInt(hm.get("Icon").toString());
            double tempMin = Double.parseDouble(hm.get("TempMax").toString());
            double tempMax = Double.parseDouble(hm.get("TempMin").toString());
        
            String iconImageName = getIconImage(icon);
            Double avgTemp = getAvgTemp(tempMin, tempMax);
            
            ImageIcon iconIMG = AddImage(iconImageName);
            JLabel imgLabel = new JLabel(iconIMG);
            JLabel lblTemp = new JLabel(avgTemp.toString());
            statePanel.add(imgLabel);
            statePanel.add(lblTemp);
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
        ResetStatePanel();
        List data = getData();
            
        if(data == null || data.isEmpty())
            return new WeatherInactiveState();
        
        ((ArrayList<HashMap>)data).forEach((hm) -> 
        {
            int icon = Integer.parseInt(hm.get("Icon").toString());
            String phrase = hm.get("IconPhrase").toString();
            
            String iconImageName = getIconImage(icon);
            
            ImageIcon iconIMG = AddImage(iconImageName);
            JLabel imgLabel = new JLabel(iconIMG);
            JLabel lblphrase = new JLabel(phrase);
            statePanel.add(imgLabel);
            statePanel.add(lblphrase);
        });
        return this;
    }

    @Override
    public ButtonState longPress() {
        return new SingleDayForecastState();
    }
    
    private double getAvgTemp(double tempA, double tempB)
    {
        return Weather_Service.getInstance().GetTemperatureAverage(tempA, tempB);
    }
}
