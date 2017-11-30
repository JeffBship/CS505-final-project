/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clockwidget;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
/**
 *
 * @author James Luczynski
 */
public class ClockLabel {
    private JLabel label;
    private int fontSize = 35;
    private int fontStyle = 0;
    
    public final int LABEL_HEIGHT = 25;
    public final int LABEL_WIDTH = 250;
    
    private Font wingdings  = new Font("Wingdings", fontStyle, fontSize);
    private Font comicSans  = new Font("Comic Sans", fontStyle, fontSize);
    private Font courierNew = new Font("Courier New", fontStyle, fontSize);
    private Font[] font = {wingdings, comicSans, courierNew};
    private int fontIndex = 2;
    
    public ClockLabel(String text){
        label = new JLabel(text);
        label.setForeground(Color.red);
        label.setBounds(50, 200, LABEL_WIDTH, LABEL_HEIGHT);
        cycleFont();
    }
    
    public ClockLabel(){
        this(ClockTime.get());
        label = new JLabel();
    }
    
    public JLabel getLabel(){
        return label;
    }    
    
    public void cycleFont(){
        label.setFont(font[fontIndex]);
        fontIndex = fontIndex + 1 % font.length;
    }
    
    public void setText(){
        label.setText(ClockTime.get());
    }
    
    public String toString(){
        return label.getText();
    }
}
