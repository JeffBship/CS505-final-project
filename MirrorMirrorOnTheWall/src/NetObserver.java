
import java.util.Observer;

/**
 *
 * @since 11/4/2016
 * @see java.util.Observer
 * @author melmulcahy
 * To be implemented by classes who want to observe the NetConnector class.
 */
public interface NetObserver extends Observer{
    
    /**
     * This will update the the netObserver based on the whether there is or is not a network connection. The status of the network connection is passed in through the parameter.
     * 
     * @param isConnected
     * @see boolean
     */
    public void update(boolean isConnected);
}
