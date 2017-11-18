/**
 * @author Jeff Blankenship
 */
package NewsWidget;

// merge with WidgetController at some point and extend the WidgetState

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/* Adapted from example provided at
 * @web http://helloraspberrypi.blogspot.com/
 * @author Andr.oid Eric  https://plus.google.com/+AndroidEric
 */
public class NewsWidget extends JFrame 
    implements ActionListener{
 
    JTextArea textArea;
    JButton jbutton;
     
    public static void main(String[] args) {
      CnnRSS cnnRSS = new CnnRSS();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createNewsFrame();
            }
        });
    }
 
    private static void createNewsFrame() {
        NewsWidget newsFrame = new NewsWidget();
        newsFrame.setUndecorated(true);
        newsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newsFrame.prepareUI();
        newsFrame.pack();
        newsFrame.setVisible(true);
    }
     
    
    private void prepareUI(){
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(Color.BLACK);
        JScrollPane panel = new JScrollPane(textArea);
        textArea.setPreferredSize(new Dimension(720, 450));
         
        jbutton = new JButton("Push Me");
        jbutton.addActionListener(this);
         
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(jbutton, BorderLayout.PAGE_END);
    }

 
    @Override
    public void actionPerformed(ActionEvent e) {
        textArea.setText("Stop pushing me!");
    }

}