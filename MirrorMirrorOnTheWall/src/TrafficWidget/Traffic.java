package TrafficWidget;
 
 
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
 
public class Traffic extends Region {
  
    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();
      
    public Traffic() {
        //apply the styles
        getStyleClass().add("browser");
        // load the web page
        String url ="https://www.google.com/maps/dir/205+Main+Street,+Wallingford,+CT/1615+Stanley+St,+New+Britain,+CT+06053/@41.5778858,-72.9034373,11z/data=!3m1!4b1!4m13!4m12!1m5!1m1!1s0x89e7cec9f049a787:0xd4504476e463e401!2m2!1d-72.828807!2d41.480756!1m5!1m1!1s0x89e7b25caebfa5eb:0x86fd24736c8c3d0!2m2!1d-72.7678883!2d41.6855721";
        webEngine.load(url);
        //add the web view to the scene
        getChildren().add(browser);
  
    }
    private Node createSpacer() {
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        return spacer;
    }
  
    @Override protected void layoutChildren() {
        double w = getWidth();
        double h = getHeight();
        layoutInArea(browser,0,0,w,h,0, HPos.CENTER, VPos.CENTER);
    }
  
    @Override protected double computePrefWidth(double height) {
        return 750;
    }
  
    @Override protected double computePrefHeight(double width) {
        return 500;
    }
}
