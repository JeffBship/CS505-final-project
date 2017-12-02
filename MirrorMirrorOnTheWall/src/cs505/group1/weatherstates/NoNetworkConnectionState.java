package cs505.group1.weatherstates;


import cs505.group1.state.ButtonState;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * This state represents what is displayed when there is no network connection.
All widgets, that utilize network connectivity, will be ulitizing this state.
 */

/**
 *
 * @since 11/12/2017
 * @version 2017.11.12.0
 * @author melmulcahy
 */
public class NoNetworkConnectionState extends WeatherState {

    @Override
    public ButtonState singlePress() {
        showMessage();
        return this;
    }

    @Override
    public ButtonState doublePress() {
        showMessage();
        return this;
    }

    @Override
    public ButtonState longPress() {
        showMessage();
        return this;
    }
    
    private void showMessage()
    {
        ResetStatePanel();
        ImageIcon iconIMG = AddImage("error.png");
            JLabel imgLabel = new JLabel(iconIMG);
            JLabel lblTemp = new JLabel("No Network Connection");
            lblTemp.setForeground((Color.white));
            statePanel.add(imgLabel);
            statePanel.add(lblTemp);
    }
    
    @Override
    public String toString() {
        return "NONETWORK";
    }
    
}
