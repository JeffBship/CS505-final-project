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
  

  public static String[] loadInfo() {
    
    try {
      TrafficPanel.main(TrafficProxy.loadInfo());
      TrafficPanel.main(TrafficReal.loadInfo());
    } catch (IOException ex) {
      System.out.println("IOException in loadInfo");
    }
    
  return null;
  };
  
}