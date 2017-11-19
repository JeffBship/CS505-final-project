package MirrorMirrorOnTheWall;


import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Observable;




/**
 *
 * A singleton class used to monitor network connectivity on the raspberryPi.
 * @since 11/4/2016
 * @author melmulcahy
 */
public class NetConnector extends Observable{

    /**
     * An instance of itself to pass to classes/methods checking on the network status.
     */
    private static NetConnector netConnector = new NetConnector();
    
     /**
     * A collection of netObservers who rely on the connection to the network
     */
    private List<NetObserver> netObservers;
    
     /**
     * The current status of whether there is network connection
     */
    private boolean isConnected;
    
    
    /**
    * Constructor class to create an object of the NetConnector class
    */
    private NetConnector()
    {
        netObservers = new ArrayList<>();
        isConnected = false;
    }
    
    /**
     * Add a new NetObserver to the netObservers set.
     * @param obs
     * @return T/F if the operation was successful
     */
    public boolean addNetObserver(NetObserver obs) {
        try{
            if(obs != null)
            {
                return netObservers.add(obs);
            }
            else
            {
                return false;
            }
        }
        catch(Exception ex){
            return false;
        }
    }

    /**
     *
     * @return T/F if the operation was successful
     * @purpose Remove a NetObserver from the set.
     * @throws ClassCastException
     * @throws NullPointerException
     * @throws UnsupportedOperationException
     * @param obs
     */
    public boolean removeNetObserver(NetObserver obs) {
        try
        {
            if(obs == null)
            {
                return false;
            }
            else
            {
                return netObservers.remove(obs);
            }
        }
        catch(Exception ex)
        {
            return false;
        }
    }

    /**
     * Notifies the given netObserver of the network connection status
     * @param obs
     */
    private void notifyNetObserver(NetObserver obs) {
        obs.update(this.isConnected);
    }
    
    /**
     * Invokes the update method of each observer in the netObservers list
     */
    public void SendNotifications()
    {
            netObservers.forEach((obs) -> {
                notifyNetObserver(obs);
            });
            
    }
    
    /**
     * Checks to see if "www.google.com" is reachable and notifies the widgets if not.
     * @return True if network is enabled, false otherwise.
     */
    public boolean checkNetwork()
    {
        try
        {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) 
            {
                NetworkInterface nic = interfaces.nextElement();
                isConnected = nic.isUp();
            }

            return isConnected;
        }
        catch(IOException ex)
        {
            System.out.println("An error occured monitoring network: " + ex);
            return false;
        }
            
    }
    
    /**
     * Get the current network connection state
     * @return T/F
     */
    public boolean getState()
    {
        return this.isConnected;
    }
    
    /**
     * Set the current network connection state
     * @param isConnected
     */
    public void setState(boolean isConnected)
    {
        this.isConnected = isConnected;
    }
    
    /**
     * Get the current instance of the NetConnector
     * @return the instance of the Network Connector
     */
    public static NetConnector getInstance()
    {
        return netConnector;
    }
    
    /**
     * Resets the singleton to a new instance
     */
    public static void resetSingleton()
    {
        netConnector = new NetConnector();
    }
    
    
    /**
     * Determines if two NetConnectors are the same.
     * @param n2 - a NetConnector
     * @return True if they are the same, false otherwise
     */
    public boolean equals(NetConnector n2)
    {
        return (this.getState() == n2.getState());
    }

}
