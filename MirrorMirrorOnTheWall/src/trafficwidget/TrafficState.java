
package trafficwidget;

import MirrorMirrorOnTheWall.Mirror;
import static MirrorMirrorOnTheWall.Mirror.widgetDim;
import cs505.group1.state.ButtonState;
import java.awt.Color;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.text.BadLocationException;

public class TrafficState extends ButtonState implements Runnable{
  
  private static final String[] urlArray = {
    "https://www.google.com/maps/dir/205+Main+St,+Wallingford,+CT+06492/CCSU,+Stanley+Street,+New+Britain,+CT/@41.5803555,-72.9037839,11z/data=!3m1!4b1!4m13!4m12!1m5!1m1!1s0x89e7cec9f049a787:0xd4504476e463e401!2m2!1d-72.828807!2d41.480756!1m5!1m1!1s0x89e7b266eb15e0a5:0xa92a64e8673c71fb!2m2!1d-72.764167!2d41.693255",
    "https://www.google.com/maps/dir/205+Main+St,+Wallingford,+CT+06492/12+Washington+Street,+New+Britain,+CT/@41.5652172,-72.9037839,11z/data=!3m1!4b1!4m13!4m12!1m5!1m1!1s0x89e7cec9f049a787:0xd4504476e463e401!2m2!1d-72.828807!2d41.480756!1m5!1m1!1s0x89e7b3c97926845d:0x6812415c8f4dae27!2m2!1d-72.7838029!2d41.6680229",
    "https://www.google.com/maps/dir/205+Main+St,+Wallingford,+CT+06492/241+W+Main+St,+Meriden,+CT+06451/@41.5099412,-72.8546865,13z/data=!3m1!4b1!4m13!4m12!1m5!1m1!1s0x89e7cec9f049a787:0xd4504476e463e401!2m2!1d-72.828807!2d41.480756!1m5!1m1!1s0x89e7c98c62f0f903:0xb7707f8cdbfa5a1a!2m2!1d-72.8110023!2d41.5394042",
    "https://www.google.com/maps/dir/205+Main+St,+Wallingford,+CT+06492/38+Town+Line+Road,+Rocky+Hill,+CT/@41.5723746,-72.8833905,11z/data=!3m1!4b1!4m13!4m12!1m5!1m1!1s0x89e7cec9f049a787:0xd4504476e463e401!2m2!1d-72.828807!2d41.480756!1m5!1m1!1s0x89e64d9b4d8b9dc1:0xa7258352fb9003d!2m2!1d-72.655705!2d41.682278",
    "https://www.google.com/maps/dir/205+Main+St,+Wallingford,+CT+06492/50+Stonegate+Rd,+New+Britain,+CT+06053/@41.5736641,-72.9426702,11z/data=!3m1!4b1!4m13!4m12!1m5!1m1!1s0x89e7cec9f049a787:0xd4504476e463e401!2m2!1d-72.828807!2d41.480756!1m5!1m1!1s0x89e7b18373b22d01:0xb62a0197f63c7ca6!2m2!1d-72.8135117!2d41.6819179"
    };
  
  private static final String[] nameArray = {
    "school", 
    "daycare", 
    "work", 
    "church", 
    "mall"
    };
  
  public String getName(){
    return nameArray[destination];
  }
    
  private static int destination=3;
  
  public static void nextDestination(){
    destination++;
    if (destination > urlArray.length-1){
      destination = 0;
    }
    System.out.println("The destination index is:  " + destination );
  }
  public static void previousDestination(){
    destination--;
    if (destination < 0 ){
      destination = urlArray.length-1;
    }
  }
  
    @Override
    public ButtonState singlePress() {
    try {
      //increment destination and reload the frame
      nextDestination();
      String[] info = TrafficProxy.loadInfo();
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
      previousDestination();
      String[] info = TrafficProxy.loadInfo();
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
          info = TrafficProxy.loadInfo(nameArray[destination]);
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
    
  @Override
    public void run() {
      try {
        String[] info = TrafficReal.loadInfo(nameArray[destination],urlArray[destination]);
        statePanel = TrafficPanel.createTrafficPanel(info);
        Mirror.GetInstance().UpdateTrafficUI(statePanel);
      } catch (IOException ex) {
      } catch (BadLocationException ex) {
      }
    }
      
}

