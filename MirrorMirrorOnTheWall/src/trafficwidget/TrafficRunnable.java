package trafficwidget;

import MirrorMirrorOnTheWall.Mirror;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;

class TrafficRunnable implements Runnable {

    public void run() {
      try {
        System.out.println("Hello from a thread!");
        
        String[] info = TrafficReal.loadInfo();
        //TrafficState.setStatePanel(TrafficPanel.createTrafficPanel(info));
        System.out.println("Done loading real info");
        Mirror.GetInstance().UpdateUI();
        
      } catch (IOException ex) {
      }
    }

    public static void main() {
        (new Thread(new TrafficRunnable())).start();
    }

}