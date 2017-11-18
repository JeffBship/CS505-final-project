package NewsWidget;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
 
/**
 * 
 * @web http://helloraspberrypi.blogspot.com/
 */
public class hello extends JFrame 
    implements ActionListener{
 
    JTextArea textArea;
    JButton buttonHello;
     
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
 
    private static void createAndShowGUI() {
        hello myFrame = new hello();
 
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        myFrame.prepareUI();
 
        myFrame.pack();
        myFrame.setVisible(true);
    }
     
    private void prepareUI(){
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane panel = new JScrollPane(textArea);
        panel.setPreferredSize(new Dimension(720, 450));
         
        buttonHello = new JButton("Hello");
        buttonHello.addActionListener(this);
         
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(buttonHello, BorderLayout.PAGE_END);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        textArea.setText("Hello from Raspberry Pi");
    }

}