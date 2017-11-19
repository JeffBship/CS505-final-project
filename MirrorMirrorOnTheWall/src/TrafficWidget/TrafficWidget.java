package TrafficWidget;
 
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
 
// merge with WidgetController at some point and extend the WidgetState
public class TrafficWidget extends Application {
   
    static Robot marvin;
    Scanner scan = new Scanner(System.in);
    char input;
   
    private Scene webWidget;
     
    @Override public void start(Stage stage) { 
       
      //Open the webpage
        stage.setTitle("Web View");
        webWidget = new Scene(new Traffic(),720,450, Color.web("#666970"));
        stage.setScene(webWidget);      
        stage.show();
         
      System.out.println("Webpage should be open");
       
    }
    /**
     * Scrolls the webpage down one increment.
     */
    public static void singlePress(){
    };
     
    /**
     * Scrolls the webpage down one increment.
     */
    public static void doublePress(){
    };
     
    /**
     * Refresh and return to home
     */
    public static void longPress(){  
    };
     
 
    public static void main(String[] args){
      //Should never reach this
      launch(args);
    }
}
