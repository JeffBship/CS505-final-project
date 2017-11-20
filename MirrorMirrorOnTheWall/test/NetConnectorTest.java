/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import MirrorMirrorOnTheWall.NetObserver;
import MirrorMirrorOnTheWall.NetConnector;
import WeatherWidget.WeatherWidget;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author melmulcahy
 */
public class NetConnectorTest {
    
    public NetConnectorTest() {
    }

    @Before
    public void resetSingleton() 
    {
        NetConnector.resetSingleton();
    }
    
    /**
     * Test of addNetObserver method, of class NetConnector good.
     */
    @Test
    public void testAddNetObserver() {
        NetObserver obs = WeatherWidget.getInstance();
        NetConnector instance = NetConnector.getInstance();
        boolean wasAdded = instance.addNetObserver(obs);
        
        assertTrue(wasAdded);
    }
    
    /**
     * Test of addNetObserver method, of class NetConnector when attempting to add null.
     */
    @Test
    public void testAddNetObserverNull() {
        NetObserver obs = null;
        NetConnector instance = NetConnector.getInstance();
        boolean wasAdded = instance.addNetObserver(obs);
        assertFalse(wasAdded);
    }
    

    /**
     * Test of removeNetObserver method, of class NetConnector when an observer does not exist.
     */
    @Test
    public void testRemoveNetObserver() {
        NetObserver obs = WeatherWidget.getInstance();
        NetConnector instance = NetConnector.getInstance();
        boolean wasRemoved = instance.removeNetObserver(obs);
        // TODO review the generated test code and remove the default call to fail.
        assertFalse(wasRemoved);
    }
    
    /**
     * Test RemoveNetObserver when an existing observer exists.
     */
    @Test
    public void testRemoveNetObserverGood() {
        
        NetObserver obs = WeatherWidget.getInstance();
        NetConnector instance = NetConnector.getInstance();
        boolean wasAdded = instance.addNetObserver(obs);
        boolean wasRemoved = instance.removeNetObserver(obs);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(wasRemoved);
    }
    
    /**
     * Test RemoveNetObserver when passed null.
     */
    @Test
    public void testRemoveNetObserverNull() {
        
        NetObserver obs = null;
        NetConnector instance = NetConnector.getInstance();
        boolean wasRemoved = instance.removeNetObserver(obs);
        // TODO review the generated test code and remove the default call to fail.
        assertFalse(wasRemoved);
    }

    /**
     * Test of GetState method, of class NetConnector.
     */
    @Test
    public void testGetState() {
        System.out.println("GetState");
        NetConnector instance = NetConnector.getInstance();
        boolean expResult = false;
        boolean result = instance.getState();
        assertEquals(expResult, result);
    }

    /**
     * Test of SetState method, of class NetConnector.
     */
    @Test
    public void testSetState() {
        System.out.println("SetState");
        boolean isConnected = true;
        NetConnector instance = NetConnector.getInstance();
        instance.setState(isConnected);
        
        
        assertEquals(instance.getState(), isConnected);
    }

    /**
     * Test of getInstance method, of class NetConnector.
     */
    @Test
    public void testGetInstance() {
        System.out.println("GetInstance");
        NetConnector result = NetConnector.getInstance();
        
        assertEquals(result.getClass().getName(),"NetConnector");
    }

    /**
     * Test of resetSingleton method, of class NetConnector.
     */
    @Test
    public void testResetSingleton() {
        System.out.println("resetSingleton");
        NetConnector old = NetConnector.getInstance();
        NetConnector.resetSingleton();
        
        NetConnector newIns = NetConnector.getInstance();
        
        assertTrue(old.equals(newIns));
    }

    /**
     * Test of monitorNetwork method, of class NetConnector.
     */
    @Test
    public void testCheckNetwork() {
        System.out.println("checkNetwork");
        NetConnector instance = NetConnector.getInstance();
        
        boolean enabled = instance.checkNetwork();
        System.out.println(enabled);
        // TODO implement this
        assertTrue(enabled);
    }

    /**
     * Test of equals method, of class NetConnector.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        NetConnector n2 = NetConnector.getInstance();
        n2.setState(true);
        NetConnector.resetSingleton();
        NetConnector instance = NetConnector.getInstance();
        boolean expResult = false;
        boolean result = instance.equals(n2);
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class NetConnector.
     */
    @Test
    public void testEqualsTrue() {
        System.out.println("equals");
        NetConnector n2 = NetConnector.getInstance();
        NetConnector.resetSingleton();
        NetConnector instance = NetConnector.getInstance();
        boolean expResult = true;
        boolean result = instance.equals(n2);
        
        assertEquals(expResult, result);
    }
    
}
