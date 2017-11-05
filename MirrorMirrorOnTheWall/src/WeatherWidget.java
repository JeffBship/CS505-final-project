
import java.util.Observable;

/*
 * This class handles the weather widget for the MirrorMirrorOnTheWall project.
 */

/**
 *  @since 11/4/2016
 * @author melmulcahy
 */
public class WeatherWidget extends Widget {

    private String currentWeather = "";
    private int currentTemperature = 0;
    private String location;
    private static WeatherWidget weatherWidget = new WeatherWidget();
    
    private WeatherWidget()
    {
        this.location = "New Britain, CT";
    }
    
    /**
     *
     * @return the current weather (rain, snow, etc...)
     */
    public String getCurrentWeather()
    {
        return this.currentWeather;
    } 
    
    /**
     *
     * @return the current temperature (in degrees)
     */
    public int getCurrentTemperature()
    {
        return this.currentTemperature;
    }
    
    /**
     *
     * @return the current location
     */
    public String getLocation()
    {
        return this.location;
    }
    
    /**
     * Sets the current weather pattern
     * @param weather
     */
    public void setCurrentWeather(String weather)
    {
        this.currentWeather = weather;
    } 
    
    /**
     *
     * Sets the current temperature (in degrees)
     * @param temperature
     */
    public void setCurrentTemperature(int temperature)
    {
        this.currentTemperature = temperature;
    }
    
    /**
     *
     * Sets the current location
     * @param location
     */
    public void setLocation(String location)
    {
        this.location = location;
    }
    
    /**
     * Gets the weather widget and will create an instance if it hasn't been initialized.
     * @return
     */
    public static WeatherWidget getInstance()
    {
        return weatherWidget;
    }
    
    /**
     * Display the inactive state
     */
    @Override
    public void showInactiveState() {
        //TODO: Implement States
        System.out.println("Show Inactive State");
    }

    /**
     * show the no network state
     */
    @Override
    public void showNoNetworkState() {
        
        //TODO: Implement States
        System.out.println("Show No Network State");
    }

   /**
    * If there is no network connection, display the no network state
    * @param isConnected status of the network connection
    */
    
    @Override
    public void update(boolean isConnected) {
        
        //TODO: Implement States
        if(!isConnected)
        {
            showNoNetworkState();
        }
        
    }

    /**
     * No sure what to do with this yet.
     * @param o
     * @param arg 
     */
    @Override
    public void update(Observable o, Object arg) {
        //TODO: implement this.
        System.out.println("Update");
    }
    
    /**
     * Resets the instance of the singleton to a new object. 
     */
    public static void resetSingleton()
    {
        weatherWidget = new WeatherWidget();
    }
    
    /**
     * Determines if two WeatherWidgets are equal
     * @param w - a widget
     * @return true if equal, false otherwise
     */
    public boolean equals(WeatherWidget w)
    {
        return ( (this.getCurrentTemperature()== w.getCurrentTemperature()) &&
                 (this.getCurrentWeather().equals(w.getCurrentWeather())) &&
                 (this.getLocation().equals(w.getLocation())));
    }
    
}
