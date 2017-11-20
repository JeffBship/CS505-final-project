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
public class SingleDayForcastState implements ButtonState {

    @Override
    public ButtonState singlePress() {
        System.out.println("Single Day Forcast state: SINLGE PRESS");
        return this;
    }

    @Override
    public ButtonState doublePress() {
        System.out.println("Single Day Forcast state: DOUBLE PRESS");
        return this;
    }

    @Override
    public ButtonState longPress() {
        System.out.println("Single Day Forcast state: LONG PRESS");
        return this;
    }
    
}
