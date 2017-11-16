/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Observable;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
     * Test of GetInstance method, of class WeatherWidget.
     */
    @Test
    public void testGetInstance() {
        System.out.println("GetInstance");
        WeatherWidget result = WeatherWidget.getInstance();
        
        assertEquals(result.getClass().getName(),"WeatherWidget");
    }

    /**
     * Test of showInactiveState method, of class WeatherWidget.
     */
    @Test
    public void testShowInactiveState() {
        System.out.println("showInactiveState");
        WeatherWidget instance = WeatherWidget.getInstance();
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outContent));
        
        instance.showInactiveState();
        
        assertEquals(outContent.toString(),"Show Inactive State\n");
    }

    /**
     * Test of showNoNetworkState method, of class WeatherWidget.
     */
    @Test
    public void testShowNoNetworkState() {
        System.out.println("showNoNetworkState");
        WeatherWidget instance = WeatherWidget.getInstance();
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outContent));
        
        instance.showNoNetworkState();
        
        assertEquals(outContent.toString(),"Show No Network State\n");
    }

    /**
     * Test of update method, of class WeatherWidget.
     */
    @Test
    public void testUpdate_boolean_False() {
        System.out.println("update");
        boolean isConnected = false;
        WeatherWidget instance = WeatherWidget.getInstance();
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outContent));
        
        instance.update(isConnected);
        
        assertEquals("Show No Network State\n",outContent.toString());
    }
    
      /**
     * Test of update method, of class WeatherWidget.
     */
    @Test
    public void testUpdate_boolean_True() {
        System.out.println("update");
        boolean isConnected = true;
        WeatherWidget instance = WeatherWidget.getInstance();
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outContent));
        
        instance.update(isConnected);
        
        assertEquals("",outContent.toString());
    }

    /**
     * Test of update method, of class WeatherWidget.
     */
    @Test
    public void testUpdate_Observable_Object() {
        System.out.println("update");
        Observable o = NetConnector.getInstance();
        Object arg = null;
        WeatherWidget instance = WeatherWidget.getInstance();
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outContent));
        
        instance.update(o, arg);
        
        assertEquals("Update\n",outContent.toString());
    }


    /**
     * Test of resetSingleton method, of class WeatherWidget.
     */
    @Test
    public void testResetSingleton() {
         System.out.println("resetSingleton");
        WeatherWidget old = WeatherWidget.getInstance();
        WeatherWidget.resetSingleton();
        
        WeatherWidget newIns = WeatherWidget.getInstance();
        
        assertTrue(old.equals(newIns));
    }
    
}
