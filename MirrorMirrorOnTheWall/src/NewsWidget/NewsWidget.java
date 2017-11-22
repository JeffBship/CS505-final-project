/**
 * @author Jeff Blankenship
 */
package NewsWidget;

// merge with WidgetController at some point and extend the WidgetState

import java.awt.Color;
import javax.swing.*;
import javax.swing.text.*;
import NewsChainOfResponsibility.RSS;

/* Adapted from example provided at
 * @web http://helloraspberrypi.blogspot.com/
 * @author Andr.oid Eric  https://plus.google.com/+AndroidEric
 */
public class NewsWidget {
 
  JTextArea textArea;
  JButton jbutton;

  public static void main(String[] args) {

      SwingUtilities.invokeLater(new Runnable() {
          @Override
          public void run() {
              createNewsFrame();
          }
      });
  }

  private static void createNewsFrame() {
      RSS rss = new RSS();
      JFrame newsFrame = new JFrame();
      newsFrame.setUndecorated(true);
      newsFrame.setSize(720,450);
      newsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //The news text will go in a pane using a styled document
      JTextPane textPane = new JTextPane();
      textPane.setBackground(Color.black);
      StyledDocument doc = textPane.getStyledDocument();
      
      //add the titles and descriptions, in appropriate fonts
      try {
        for(Story story:rss.getStoryList()) { 
          doc.insertString(doc.getLength(), "\n"+story.title+"\n",rss.getBigFont() );
          if (!story.description.equals("")) {
            doc.insertString(doc.getLength(), "    "+story.description+"\n",rss.getSmallFont() );
          }
        }
      } catch (BadLocationException ex) {
        System.out.println("BadLocationException");
      }

      //the pane needs to be scrollable 
      JScrollPane scrollPane = new JScrollPane( textPane );
      newsFrame.add(scrollPane);
      
      //pack, place, size, show
      newsFrame.pack();
      newsFrame.setSize(700,430);
      newsFrame.setLocation(10,10);
      newsFrame.setVisible(true);
      
      scrollPane.getVerticalScrollBar().setValue(0);    // scroll bar to top
      scrollPane.repaint();
      scrollPane.getVisibleRect().y = 0;
      
      //scroll to the top
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run(){ 
          scrollPane.getVerticalScrollBar().setValue(0);
        }
      });   
  }
}