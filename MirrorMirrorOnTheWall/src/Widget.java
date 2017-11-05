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
    
    public abstract void showInactiveState();
    public abstract void showNoNetworkState();
    
}
