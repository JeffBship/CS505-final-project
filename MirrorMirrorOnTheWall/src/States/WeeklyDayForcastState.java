package States;


import cs505.group1.state.ButtonState;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author melmulcahy
 */
public class WeeklyDayForcastState implements ButtonState {

    @Override
    public ButtonState singlePress() {
        System.out.println("Weekly Day Forcast state: SINGLE PRESS");
        return this;
    }

    @Override
    public ButtonState doublePress() {
        System.out.println("Weekly Day Forcast state: DOUBLE PRESS");
        return this;
    }

    @Override
    public ButtonState longPress() {
        System.out.println("Weekly Day Forcast state: LONG PRESS");
        return this;
    }
    
}
