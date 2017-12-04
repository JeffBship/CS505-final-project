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
    private ClockTime clockTime;
            
    private int height = 45;
    private int width = 330; 
    private int delta = 100;
    
    public ClockLabel(){
        clockTime = new ClockTimeMinutes();
        label = new JLabel(clockTime.get());
        label.setForeground(ClockFont.nextColor());
        label.setBounds(0, 0, width, height);
        label.setFont(ClockFont.currentFont);
    }
    
    public JLabel getLabel(){
        return label;
    }    
    
    public void cycleFontSize(){
        label.setFont(ClockFont.nextFontSize());
    }
    
    public void cycleColor(){
        label.setForeground(ClockFont.nextColor());
    }
    
    public void toggleClock(){
        if (clockTime instanceof ClockTimeMinutes){
            clockTime = new ClockTimeSeconds();
            width += delta;
        }
        else{
            clockTime = new ClockTimeMinutes();
            width -= delta;
        }
        refreshTime();
    }
    
    public boolean isMinutes(){
        return (clockTime instanceof ClockTimeMinutes);
    }
    
    public void refreshTime(){
        label.setText(clockTime.get());
    }
    
    public String toString(){
        return label.getText();
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    private static class ClockFont{
        
        static final int FONT_STYLE = 0;
        static int fontSize = 50;
        
        static final String FONT_NAME = "Times New Roman";
        static Font currentFont = new Font(FONT_NAME, FONT_STYLE, fontSize);
        
        static Color currentColor;
        static final Color[] COLOR = {Color.RED, Color.LIGHT_GRAY, Color.ORANGE, Color.BLUE, 
            Color.YELLOW, Color.PINK, Color.DARK_GRAY, Color.CYAN, Color.ORANGE};        
        static int colorInd = -1;
        
        static Color nextColor(){
            colorInd = (colorInd + 1) % COLOR.length;
            currentColor = COLOR[colorInd];
            return currentColor;
        }
        
        static Font nextFontSize(){
            fontSize += 4;
            if (fontSize > 66)
                fontSize = 38;
            currentFont = new Font(FONT_NAME, FONT_STYLE, fontSize);
            return currentFont;
        }
    }
}
