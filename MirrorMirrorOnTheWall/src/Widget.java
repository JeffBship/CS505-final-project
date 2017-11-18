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
public abstract class Widget extends ButtonContext implements NetObserver {
    private NetConnector netConnector;
    
    public abstract void showInactiveState();
    
    public abstract void showNoNetworkState();
    
    public Widget(ButtonState buttonState){
        super(buttonState);  //calls the parent class constructor
        this.buttonState = buttonState; 
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

    @Override
    public abstract void singlePress();

    @Override
    public abstract void doublePress();

    @Override
    public abstract void longPress();

    @Override
    public abstract String toString();
    
    
}
