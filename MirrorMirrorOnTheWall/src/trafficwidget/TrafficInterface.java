/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficwidget;

import java.io.IOException;


/**
 *
 * @author ao0729
 */
abstract class TrafficInterface  {
  

  public static void nextDestination(){
    TrafficReal.nextDestination();
  }
  public static void previousDestination(){
    TrafficReal.previousDestination();
  }
    
  public static String[] loadInfo() {
    
    try {
      TrafficFrame.main(TrafficProxy.loadInfo());
      TrafficFrame.main(TrafficReal.loadInfo());
    } catch (IOException ex) {
      System.out.println("IOException in loadInfo");
    }
    
  return null;
  };
  
}