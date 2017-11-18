
import WeatherStates.HourlyDayForcastState;
import WeatherStates.WeatherInactiveState;
import cs505.group1.state.ButtonState;
import java.util.Observable;

/*
 * This class handles the weather widget for the MirrorMirrorOnTheWall project.
 */

/**
 *  @since 11/4/2016
 * @version 2017.11.12
 * @author melmulcahy
 */
public class WeatherWidget extends Widget {

    private String currentWeather = "";
    private int currentTemperature = 0;
    private String location;
    private static WeatherWidget weatherWidget = new WeatherWidget(new HourlyDayForcastState());
    
    /**
     * Default constructor. Sets location to New Britain, CT.
     */
    protected WeatherWidget(ButtonState buttonState)
    {
      super(buttonState);  //calls the parent class constructor
      this.buttonState = buttonState;
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
     * show the no network state
     */
    @Override
    public void showNoNetworkState() {
        
        //TODO: Implement States
        setState(new NoNetworkConnectionState());
    }

    /**
     * Resets the instance of the singleton to a new object. 
     */
    public static void resetSingleton()
    {
        weatherWidget = new WeatherWidget(new HourlyDayForcastState());
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

    @Override
    public void singlePress() {
        ButtonState currentState = getState();
        currentState.singlePress();
    }

    @Override
    public void doublePress() {
        ButtonState currentState = getState();
        currentState.doublePress();
    }

    @Override
    public void longPress() {
        ButtonState currentState = getState();
        currentState.longPress();
    }

    @Override
    public String toString() {
        
        ButtonState currentState = getState();
        return currentState.toString();
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showInactiveState() {
        
        setState(new WeatherInactiveState());
    }

    
}
