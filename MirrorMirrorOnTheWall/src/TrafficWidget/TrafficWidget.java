package TrafficWidget;
 
import WeatherWidget.Widget;
import cs505.group1.state.ButtonState;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Observable;
import java.util.Scanner;
import static javafx.application.Application.launch;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
 
// merge with WidgetController at some point and extend the WidgetState
public class TrafficWidget extends Widget {
   
    static Robot Hez;
    Scanner scan = new Scanner(System.in);
    char input;
    public static int x =2;
    public static ArrayList<String> url = new ArrayList<>();
     public static String current ;
       private Scene webWidget;

    public TrafficWidget(ButtonState buttonState) {
        super(buttonState);
    }
     
    public void start(Stage stage) { 
       
      //Open the webpage
        stage.setTitle("Web View");
        webWidget = new Scene(new Traffic(),720,450, Color.web("#666970"));
        stage.setScene(webWidget);      
        stage.show();
         
      System.out.println("Webpage should be open");
       
    
    String school="https://www.google.com/maps/dir/205+Main+Street,+Wallingford,+CT/1615+Stanley+St,+New+Britain,+CT+06053/@41.5778858,-72.9034373,11z/data=!3m1!4b1!4m13!4m12!1m5!1m1!1s0x89e7cec9f049a787:0xd4504476e463e401!2m2!1d-72.828807!2d41.480756!1m5!1m1!1s0x89e7b25caebfa5eb:0x86fd24736c8c3d0!2m2!1d-72.7678883!2d41.6855721";
    String Daycare="https://www.google.com/maps/dir/205+Main+Street,+Wallingford,+CT/12+Washington+St,+New+Britain,+CT+06051/@41.5652176,-72.9034384,11z/data=!3m1!4b1!4m14!4m13!1m5!1m1!1s0x89e7cec9f049a787:0xd4504476e463e401!2m2!1d-72.828807!2d41.480756!1m5!1m1!1s0x89e7b3c97926845d:0x6812415c8f4dae27!2m2!1d-72.7838029!2d41.6680229!3e0";
    String Work="https://www.google.com/maps/dir/205+Main+Street,+Wallingford,+CT/Walmart+Supercenter/@41.4745203,-72.8233171,14.75z/data=!4m13!4m12!1m5!1m1!1s0x89e7cec9f049a787:0xd4504476e463e401!2m2!1d-72.828807!2d41.480756!1m5!1m1!1s0x89e7ceaec9484c7b:0x6eb17db81dbfc32f!2m2!1d-72.8105628!2d41.4775094";
    String Church="https://www.google.com/maps/dir/205+Main+Street,+Wallingford,+CT/41.3950657,-72.9113984/@41.4297494,-72.8038531,12.5z/data=!4m8!4m7!1m5!1m1!1s0x89e7cec9f049a787:0xd4504476e463e401!2m2!1d-72.828807!2d41.480756!1m0";
    String Address5="https://www.google.com/maps/dir/205+Main+Street,+Wallingford,+CT/41.1749843,-73.2623141/@41.6246304,-72.6978915,10z/data=!4m8!4m7!1m5!1m1!1s0x89e7cec9f049a787:0xd4504476e463e401!2m2!1d-72.828807!2d41.480756!1m0";

    //package String Current url;
     //  Create an ArrayList that holds references to String   
    
    
    // Add four String references
     url.add(school);
     url.add(Work);
     url.add(Church);
     url.add(Daycare);
    }
    /**
     * Display the previous address.
     */
    public void singlePress(){
        x++;
  if(x>url.size())x=0;
   current = url.get(x);

    };
     
    /**
     * Display the next address.
     */
    public void doublePress(){
         x--;
       if(x < 0)x = url.size();
       current = url.get(x);
   
    };
     
    /**
     * Refresh current page
     */
    public  void longPress(){ 
      // Hez.F5
       
    };
     
 
    public static void main(String[] args){
      //Should never reach this
      launch(args);
    }

    @Override
    public void showInactiveState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showNoNetworkState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
