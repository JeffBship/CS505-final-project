/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author melmulcahy
 * @since 11/4/2016
 */
public abstract class Widget implements NetObserver {
    private NetConnector netConnector;
    /**
     * Display the inactive state
     */
    public void showInactiveState(){
	//TODO: Implement States
        System.out.println("Show Inactive State");
    }
    public abstract void showNoNetworkState();
    
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
    
    
}
