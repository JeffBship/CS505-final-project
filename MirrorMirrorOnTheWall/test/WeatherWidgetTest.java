/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import WeatherWidget.WeatherWidget;
import cs505.group1.state.ButtonState;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import javax.swing.JPanel;
import org.junit.Before;

/**
 *
 * @author melmulcahy
 */
public class WeatherWidgetTest {
    
    public WeatherWidgetTest() {
    }
    
    @Before
    public void resetSingleton() 
    {
        WeatherWidget.resetSingleton();
    }

    /**
     * Test of GetCurrentWeather method, of class WeatherWidget.
     */
    @Test
    public void testGetCurrentWeather() {
        System.out.println("GetCurrentWeather");
        WeatherWidget instance = WeatherWidget.getInstance();
        String expResult = "";
        String result = instance.getCurrentWeather();
        assertEquals(expResult, result);
    }

    /**
     * Test of GetCurrentTemperature method, of class WeatherWidget.
     */
    @Test
    public void testGetCurrentTemperature() {
        System.out.println("GetCurrentTemperature");
        WeatherWidget instance = WeatherWidget.getInstance();
        int expResult = 0;
        int result = instance.getCurrentTemperature();
        assertEquals(expResult, result);
    }

    /**
     * Test of GetLocation method, of class WeatherWidget.
     */
    @Test
    public void testGetLocation() {
        System.out.println("GetLocation");
        WeatherWidget instance = WeatherWidget.getInstance();
        String expResult = "New Britain, CT";
        String result = instance.getLocation();
        assertEquals(expResult, result);
    }

    /**
     * Test of SetCurrentWeather method, of class WeatherWidget.
     */
    @Test
    public void testSetCurrentWeather() 
    {
        System.out.println("SetCurrentWeather");
        String weather = "Rain";
        WeatherWidget instance = WeatherWidget.getInstance();
        instance.setCurrentWeather(weather);
        assertEquals(instance.getCurrentWeather(), weather);
    }

    /**
     * Test of SetCurrentTemperature method, of class WeatherWidget.
     */
    @Test
    public void testSetCurrentTemperature() {
        System.out.println("SetCurrentTemperature");
        int temperature = 45;
        WeatherWidget instance = WeatherWidget.getInstance();
        instance.setCurrentTemperature(temperature);
        assertEquals(instance.getCurrentTemperature(), temperature);
    }

    /**
     * Test of SetLocation method, of class WeatherWidget.
     */
    @Test
    public void testSetLocation() {
        System.out.println("SetLocation");
        String location = "Hartford, CT";
        WeatherWidget instance = WeatherWidget.getInstance();
        instance.setLocation(location);
        assertEquals(instance.getLocation(), location);
    }


    /**
     * Test of showInactiveState method, of class WeatherWidget.
     */
    @Test
    public void testShowInactiveState() {
        System.out.println("showInactiveState");
        WeatherWidget instance = WeatherWidget.getInstance();
        
        instance.showInactiveState();
        
        ButtonState newState = instance.getState();
        
        assertTrue(newState.getClass().getName().equals("cs505.group1.weatherstates.WeatherInactiveState"));
    }

    /**
     * Test of showNoNetworkState method, of class WeatherWidget.
     */
    @Test
    public void testShowNoNetworkState() {
        System.out.println("showNoNetworkState");
        WeatherWidget instance = WeatherWidget.getInstance();
        
        instance.showNoNetworkState();
        
        ButtonState newState = instance.getState();
        
        assertTrue(newState.getClass().getName().equals("cs505.group1.weatherstates.NoNetworkConnectionState"));
    }

  

    
    @Test
    public void testSinglePress()
    {
        System.out.println("SinglePress");
        WeatherWidget instance = WeatherWidget.getInstance();
        instance.singlePress();
        JPanel panel = instance.getState().GetStatePanel();
        
        int count = panel.getComponentCount();
        
        assertTrue(count > 0); 
        
    }
    
    @Test
    public void testDoublePress()
    {
        System.out.println("DoublePress");
        WeatherWidget instance = WeatherWidget.getInstance();
        instance.doublePress();
        JPanel panel = instance.getState().GetStatePanel();
        
        assertTrue(panel.getComponentCount() > 0); 
    }
    
    @Test
    public void testLongPress()
    {
        System.out.println("LongPress");
        WeatherWidget instance = WeatherWidget.getInstance();
        
        ButtonState currState = instance.getState();
        
        instance.longPress();
        
        ButtonState newState = instance.getState();
        
        assertTrue(newState != currState); 
    }
    
}
