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
        label.setBounds(200, 200, width, height);
        label.setFont(ClockFont.nextFont());
    }
    
    public JLabel getLabel(){
        return label;
    }    
    
    public void cycleFont(){
        label.setFont(ClockFont.nextFont());
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
    
    public void refreshTime(){
        label.setText(clockTime.get());
    }
    
    public String toString(){
        return label.getText();
    }
    
    public int getWidth(){
        return label.getWidth();
    }
    
    public int getHeight(){
        return label.getHeight();
    }
    
    private static class ClockFont{
        static Font currentFont;
        
        static int fontStyle = 0;
        static int fontSize = 50;
        
        static String[] fontName = {"Wingdings", "Comic Sans", "Times New Roman", "Algerian"};
        static int fontInd = 2;
        
        static Color currentColor;
        static Color[] color = {Color.RED, Color.LIGHT_GRAY, Color.ORANGE, Color.BLUE, Color.YELLOW};
        static int colorInd = -1;
        
        static Font nextFont(){
            fontInd = (fontInd + 1) % fontName.length;
            currentFont = new Font(fontName[fontInd], fontStyle, fontSize);
            return currentFont;
        }
        
        static Color nextColor(){
            colorInd = (colorInd + 1) % color.length;
            currentColor = color[colorInd];
            return currentColor;
        }
    }
}
