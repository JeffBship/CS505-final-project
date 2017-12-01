/**
 * @author Jeff Blankenship
 */
package trafficwidget;

// merge with WidgetController at some point and extend the WidgetState

import cs505.group1.font.FontFactory;
import java.awt.Color;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.*;
import javax.swing.text.*;

/* Adapted from example provided at
 * @web http://helloraspberrypi.blogspot.com/
 * @author Andr.oid Eric  https://plus.google.com/+AndroidEric
 */
public class TrafficFrame {
 
  
  

  public static void main(String[] info) {

      SwingUtilities.invokeLater(new Runnable() {
          @Override
          public void run() {
            try {
              createTrafficFrame(info);
            } catch (BadLocationException | IOException ex) {
            }
          }
      });
  }

  static void createTrafficFrame(String[] info) throws BadLocationException, MalformedURLException, IOException {
      JFrame trafficFrame = new JFrame();
      trafficFrame.setUndecorated(true);
      trafficFrame.setSize(200,200);
      trafficFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
      JTextPane textPane = new JTextPane();
      textPane.setBackground(Color.black);
      StyledDocument doc = textPane.getStyledDocument();
      
      SimpleAttributeSet trafficFont = FontFactory.createSmall("traffic");
      
      String traffic = "\n\n\n    Current drive time to " + info[0] + " is " + info[1] + ".";
      
      doc.insertString(0,traffic, trafficFont);
      
      JScrollPane scrollPane = new JScrollPane( textPane );
      trafficFrame.add(scrollPane);
      
      //pack, place, size, show
      trafficFrame.pack();
      trafficFrame.setSize(200,200);
      trafficFrame.setLocation(200,10);
      trafficFrame.setVisible(true);

      javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run(){ 
          scrollPane.getVerticalScrollBar().setValue(0);
        }
      });   
  }
}