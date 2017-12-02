package cs505.group1.weatherstates;



import cs505.group1.state.ButtonState;
import java.awt.Color;
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
public class HourlyForecastState extends WeatherState {

    @Override
    public ButtonState singlePress() 
    {
        ResetStatePanel();
        List data = getData();
        
         if(data == null || data.isEmpty())
            return new WeatherInactiveState();
           
         
         
        ((ArrayList<HashMap>)data).forEach((hm) -> 
        {
            int icon = Integer.parseInt(hm.get("Icon").toString());
            String temp = hm.get("Temperature").toString();
            
            String iconImageName = getIconImage(icon);
            
            ImageIcon iconIMG = AddImage(iconImageName);
            JLabel imgLabel = new JLabel(iconIMG);
            JLabel lblTemp = new JLabel(temp);
            lblTemp.setForeground((Color.white));
            statePanel.add(imgLabel);
            statePanel.add(lblTemp);
        });
        
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
            
            lblphrase.setForeground((Color.white));
            statePanel.add(imgLabel);
            statePanel.add(lblphrase);
        });
        return this;
    }

    @Override
    public ButtonState longPress() 
    {
        return new WeeklyForecastState();
    }

    @Override
    public String toString() {
        return "HOURLYFORECAST";
    }
    
}
