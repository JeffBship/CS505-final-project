package WeatherStates;


import cs505.group1.state.ButtonState;

/*
 * This state is utilized by the Weather Widget for when it is not actively selected.
 */

/**
 *
 * @since 11/12/2017
 * @version 2017.11.12.0
 * @author melmulcahy
 */
public class WeatherInactiveState implements ButtonState{

    @Override
    public ButtonState singlePress() {
        System.out.println("Weather inactive state: SINGLE PRESS");
        return this;
    }

    @Override
    public ButtonState doublePress() {
        System.out.println("Weather inactive state: DOUBLE PRESS");
        return this;
    }

    @Override
    public ButtonState longPress() {
        System.out.println("Weather inactive state: LONG PRESS");
        return this;
    }
    
}
