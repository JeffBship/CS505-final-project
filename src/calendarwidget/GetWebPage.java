package calendarwidget;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class GetWebPage {
    public static void main(String args[]) throws Exception {
        JEditorPane website = new JEditorPane("http://smo-gram.tumblr.com/");
        website.setEditable(false);
        JFrame frame = new JFrame("Google");
        frame.add(new JScrollPane(website));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}