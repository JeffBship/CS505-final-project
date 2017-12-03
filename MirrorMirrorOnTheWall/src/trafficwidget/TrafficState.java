
package trafficwidget;

import MirrorMirrorOnTheWall.Mirror;
import static MirrorMirrorOnTheWall.Mirror.widgetDim;
import cs505.group1.state.ButtonState;
import java.awt.Color;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.text.BadLocationException;

public class TrafficState extends ButtonState implements Runnable{
    
  public static void main(String[] args){
    }
  
    @Override
    public ButtonState singlePress() {
    try {
      //increment destination and reload the frame
      TrafficProxyAbstract.nextDestination();
      String[] info = TrafficProxyAbstract.loadInfo();
      TrafficPanel.main(info);
      
    } catch (IOException ex) {
    }
    new Thread(this).start();
    return this;
    }

    @Override
    public ButtonState doublePress() {
    try {
      //increment destination and reload the frame
      TrafficProxyAbstract.previousDestination();
      String[] info = TrafficProxyAbstract.loadInfo();
      TrafficPanel.main(info);
    } catch (IOException ex) {
    }
    new Thread(this).start();
    return this;
    }

    @Override
    public ButtonState longPress() {
      //Not used in this widget
      return this;
    }
    
    @Override
    public String toString() {
        return "TRAFFICSTATE";
    }
    
    
    /**
     * removes all objects from the JPanel
     */
  @Override
    protected void ResetStatePanel(){
        statePanel.removeAll();
    }
    
  @Override
    public JPanel GetStatePanel(){
        statePanel.setBackground(Color.BLACK);
        statePanel.setPreferredSize(widgetDim);
        
        String[] info; 
        try {
          info = TrafficProxy.loadInfo();
          statePanel = TrafficPanel.createTrafficPanel(info);
        } catch (IOException | BadLocationException ex) {
        }
        //get real data in a separate thread, it should update mirror
        new Thread(this).start();
        return statePanel;
    }
    
    public TrafficState getInstance(){
      return this;
    }
    
    public void setStatePanel(JPanel trafficPanel){        
      this.statePanel = trafficPanel;
    }    
    
    public void run() {
      try {
        String[] info = TrafficReal.loadInfo();
        statePanel = TrafficPanel.createTrafficPanel(info);
        Mirror.GetInstance().UpdateTrafficUI(statePanel);
      } catch (IOException ex) {
      } catch (BadLocationException ex) {
      }
    }
      
}

