/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import WeatherWidget.Weather_Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author melmulcahy
 */
public class Weather_ServiceTest {
    
    public Weather_ServiceTest() {
    }

    /**
     * Test of GetDailyForecast method, of class Weather_Service.
     */
    @Test
    public void testGetDailyForecast() {
        System.out.println("GetDailyForecast");
        Weather_Service instance = Weather_Service.getInstance();
        ArrayList<HashMap> result = instance.GetDailyForecast();
        assertThat(result, not(new ArrayList<HashMap>()));
    }

    /**
     * Test of GetWeeklyForecast method, of class Weather_Service.
     */
    @Test
    public void testGetWeeklyForecast() {
        System.out.println("GetWeeklyForecast");
        Weather_Service instance = Weather_Service.getInstance();
        ArrayList<HashMap> result = instance.GetWeeklyForecast();
        assertThat(result, not(new ArrayList<HashMap>()));
    }

    /**
     * Test of GetHourlyForecast method, of class Weather_Service.
     */
    @Test
    public void testGetHourlyForecast() {
        System.out.println("GetHourlyForecast");
       Weather_Service instance = Weather_Service.getInstance();
        ArrayList<HashMap> result = instance.GetHourlyForecast();
        assertThat(result, not(new ArrayList<HashMap>()));
    }
    
}
