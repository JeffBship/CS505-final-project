
package NewsWidget;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

// merge with WidgetController at some point and extend the WidgetState
public class NewsWidget extends Application {
  
    static Robot marvin;
    Scanner scan = new Scanner(System.in);
    char input;
  
    private Scene webWidget;
    @Override public void start(Stage stage) {      
      //Turn on the marvin robot
      try {
        marvin = new Robot();
      } catch (AWTException e) {
        System.out.println("This will all end in tears.");
        //that's a Marvin quote, should never see it but if it shows up
        //it masks the real issue from the user.
      }
      
      //Open the webpage
        stage.setTitle("Web View");
        webWidget = new Scene(new Browser(),720,450, Color.web("#666970"));
        stage.setScene(webWidget);      
        stage.show();
        
      System.out.println("Webpage should be open");
      
      /*
      // ERROR:  THIS KEEPS THE WEBSITE FROM LOADING
      do {
        System.out.print("Enter next input: ");
        //input = scan.nextLine().charAt(0);
        switch (input) {
            case '1' : singlePress();     break;
            case '2' : doublePress();     break;
            case '3' : longPress();       break;
            case 'e' : break;  //do nothing for 'e',  loop condition checks for 'e'
            default  : System.out.println("Error, switch default reached.");
        }
      } while (input != 'e');
      */
    }
    
    //Some default scene for no web connection.
    
    
    /**
     * Scrolls the webpage down one increment.
     */
    public static void singlePress(){
        //scrolling down here
        // Simulate a series of down arrow key presses
        for(int i=0;i<1000;i++){
          marvin.keyPress(KeyEvent.	VK_DOWN);
          marvin.keyRelease(KeyEvent.	VK_DOWN);
        }
        
        //return (ButtonState) new StateB();  
    };
    
    /**
     * Scrolls the webpage down one increment.
     */
    public static void doublePress(){
        //scrolling up here
        //insert an up arrow keypress
        for(int i=0;i<10;i++){
        marvin.keyPress(KeyEvent.VK_UP);
        marvin.keyRelease(KeyEvent.VK_UP);
        }
        //return (ButtonState) new StateA();  
    };
    
    /**
     * Refresh and return to home
     */
    public static void longPress(){
        // insert a refresh and return to home (HOME key)
        marvin.keyPress(KeyEvent.VK_F5 );
        marvin.keyRelease(KeyEvent.VK_F5 );
        marvin.keyPress(KeyEvent.VK_HOME );
        marvin.keyRelease(KeyEvent.VK_HOME );
        //return (ButtonState) new StateA();  
    };
    

    public static void main(String[] args){
      //Should never reach this
      launch(args);
    }
}
