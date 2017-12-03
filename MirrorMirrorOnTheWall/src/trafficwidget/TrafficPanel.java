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
public class TrafficPanel {
 
  
  

  public static void main(String[] info) {

      SwingUtilities.invokeLater(new Runnable() {
          @Override
          public void run() {
            try {
              createTrafficPanel(info);
            } catch (BadLocationException | IOException ex) {
            }
          }
      });
  }

  public static JPanel createTrafficPanel(String[] info) 
    throws BadLocationException, MalformedURLException, IOException 
  {
      
      JTextPane textPane = new JTextPane();
      textPane.setBackground(Color.black);
      StyledDocument doc = textPane.getStyledDocument();
      
      SimpleAttributeSet trafficFont = FontFactory.createSmall("traffic");
      
      System.out.println("info is..... " + info[0] + " " + info[1]);
      
      String traffic = "\n\n\n    Current drive time to " + info[0] + " is " + info[1] + ".";
      
      doc.insertString(0,traffic, trafficFont);
      
      JScrollPane scrollPane = new JScrollPane( textPane );
      JPanel trafficPanel = new JPanel();
      trafficPanel.add(scrollPane);
      
      JPanel result = new JPanel();
      result.add(scrollPane);
      return result;
      } 
  }
