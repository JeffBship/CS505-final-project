/**
 * @author Jeff Blankenship
 */
package trafficwidget;

// merge with WidgetController at some point and extend the WidgetState

import static MirrorMirrorOnTheWall.Mirror.widgetDim;
import cs505.group1.font.FontFactory;
import java.awt.BorderLayout;
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
      textPane.setSize(widgetDim);
      
      StyledDocument doc = textPane.getStyledDocument();
      
      SimpleAttributeSet trafficFont = FontFactory.createSmall("traffic");
      
      //System.out.println("iN CREATE traffic pannel  info is..... " + info[0] + " " + info[1]);
      
      String traffic = "\n  Current drive\n"
        + "  to " + info[0] + "\n  is " + info[1] + ".";
      
      doc.insertString(0,traffic, trafficFont);
      
      JPanel trafficPanel = new JPanel(new BorderLayout());
      trafficPanel.setSize(widgetDim);
      trafficPanel.add(textPane);
      
      JScrollPane scrollPane = new JScrollPane( trafficPanel );
      scrollPane.setViewportView(textPane);
      scrollPane.setBackground(Color.black);
      scrollPane.setBorder(BorderFactory.createLineBorder(Color.black));
      
      trafficPanel.add(scrollPane);
      scrollPane.getVerticalScrollBar().setValue(0);    // scroll bar to top
      scrollPane.getHorizontalScrollBar().setValue(0);

      return trafficPanel;
      } 
  }
