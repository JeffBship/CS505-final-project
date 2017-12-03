package WeatherWidget;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cs505.group1.state.*;
/**
 *
 * @author melmulcahy
 * @since 11/4/2016
 */
public abstract class Widget extends ButtonContext {
    
    public abstract void showInactiveState();
    
    public abstract void showNoNetworkState();
    
    public Widget(ButtonState buttonState){
        super(buttonState);  //calls the parent class constructor
        this.buttonState = buttonState; 
    }


    @Override
    public abstract void singlePress();

    @Override
    public abstract void doublePress();

    @Override
    public abstract void longPress();

    @Override
    public abstract String toString();
    
    
}
