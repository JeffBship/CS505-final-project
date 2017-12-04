package trafficwidget;

import MirrorMirrorOnTheWall.Mirror;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.text.BadLocationException;

class TrafficRunnable implements Runnable {

    public void run() {
      try {
        System.out.println("Hello from a thread!");
        
        String[] info = TrafficReal.loadInfo();
        
        
        try {
          //System.out.println("Done loading real info");
          //System.out.println("TrafficRealInfo is: "+info[0] +" " +info[1]);
          //TrafficState.getInstance().GetStatePanel() =
          JPanel trafficPanel = TrafficPanel.createTrafficPanel(info);
        } catch (BadLocationException ex) {
          //Logger.getLogger(TrafficRunnable.class.getName()).log(Level.SEVERE, null, ex);
          ex.printStackTrace();
        } catch (MalformedURLException ex) {
          //Logger.getLogger(TrafficRunnable.class.getName()).log(Level.SEVERE, null, ex);
          ex.printStackTrace();
        }

        Mirror.GetInstance().UpdateUI();
        
      } catch (IOException ex) {
      }
    }

    public static void main() {
        (new Thread(new TrafficRunnable())).start();
    }

}