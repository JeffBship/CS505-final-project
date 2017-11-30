/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clockwidget;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 *
 * @author James Luczynski
 */
public class ClockPanel {
    private JPanel panel;
    private final int PANEL_WIDTH = 600;
    private final int PANEL_HEIGHT = 600;
    private int labelX = 0;  //x-coordinate of label position
    private int labelY = 0;  //y-coordinate of label position
    private int dx = 2;
    private int dy = 2;
    private ClockLabel label;
    
    public ClockPanel(){
        panel = new JPanel();
        panel.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        panel.setBounds(10, 30, PANEL_WIDTH, PANEL_HEIGHT);
    }
    
    public void addClockLabel(ClockLabel clockLabel){
        JLabel label = clockLabel.getLabel();
        this.label = clockLabel;
        labelX = (PANEL_WIDTH - clockLabel.LABEL_WIDTH)/2;
        labelY = (PANEL_HEIGHT - clockLabel.LABEL_HEIGHT)/2;
        panel.add(label);
        label.setBounds(labelX, labelY, clockLabel.LABEL_WIDTH, clockLabel.LABEL_HEIGHT);        
    }    
    
    public JPanel getPanel(){
        return panel;
    }
    
    public ClockLabel getLabel(){
        return label;
    }
}
