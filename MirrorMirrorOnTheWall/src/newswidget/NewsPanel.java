/**
 * @author Jeff Blankenship
 */
package newswidget;

// merge with WidgetController at some point and extend the WidgetState

import static MirrorMirrorOnTheWall.Mirror.widgetDim;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import javax.swing.text.*;
import newschainofresponsibility.RSS;

class NewsPanel {

  public static void main(String[] args) {

      SwingUtilities.invokeLater(new Runnable() {
          @Override
          public void run() {
              createNewsPanel();
          }
      });
  }

  public static JPanel createNewsPanel() {
      for(int i=0;i<10;i++){
    //System.out.println("\t ********************** createNewsPanel ********************");
    }
      RSS rss = new RSS();
       
      //The news text will go in a pane using a styled document
      JTextPane textPane = new JTextPane();      
      textPane.setBackground(Color.black);
      textPane.setSize(widgetDim);
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
      
      JPanel newsPanel = new JPanel(new BorderLayout());
      newsPanel.setSize(widgetDim);
      newsPanel.add(textPane);
      
      JScrollPane scrollPane = new JScrollPane(newsPanel);
      scrollPane.setViewportView(textPane);
      scrollPane.setBackground(Color.black);
      scrollPane.setBorder(BorderFactory.createLineBorder(Color.black));
      
      newsPanel.add(scrollPane);
      scrollPane.getVerticalScrollBar().setValue(0);    // scroll bar to top
      scrollPane.getHorizontalScrollBar().setValue(0);

      
      
      
      return newsPanel;
  }
}