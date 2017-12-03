
package trafficwidget;

import static MirrorMirrorOnTheWall.Mirror.widgetDim;
import cs505.group1.state.ButtonState;
import java.awt.Color;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.text.BadLocationException;

public class TrafficState extends ButtonState {
    
  public static void main(String[] args){
    //try {
      //String[] info = TrafficProxyAbstract.loadInfo();
      //TrafficPanel.main(info);
    //} catch (IOException ex) {
    //}
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
    return this;
    }

    @Override
    public ButtonState doublePress() {
    try {
      //increment destination and reload the frame
      TrafficProxyAbstract.previousDestination();
      String[] info = TrafficProxyAbstract.loadInfo();
      TrafficPanel.main(info);
      
      //mirror.widgetPanels[i].add(mirror.GetWidget(0).getState().GetStatePanel());
      
    } catch (IOException ex) {
    }
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
    protected void ResetStatePanel(){
        statePanel.removeAll();
    }
    
    public JPanel GetStatePanel(){
        statePanel.setBackground(Color.BLACK);
        statePanel.setPreferredSize(widgetDim);
        
        String[] info = {"",""};
        try {
          info = TrafficReal.loadInfo();
          statePanel = TrafficPanel.createTrafficPanel(info);
        } catch (IOException | BadLocationException ex) {
        }
        
        return statePanel;
    }
}
