package newswidget;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class GetWebPage {
    public static void main(String args[]) throws Exception {
        JEditorPane website = new JEditorPane("https://www.mapquest.com/directions/from/us/connecticut/central-connecticut-state-university-304819240/to/us/ct/middletown/06457-7930/491-ridgewood-rd-41.576882,-72.691514");
        website.setEditable(false);
        JFrame frame = new JFrame("Google");
        frame.add(new JScrollPane(website));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}