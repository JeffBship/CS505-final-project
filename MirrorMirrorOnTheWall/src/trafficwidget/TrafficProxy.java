/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficwidget;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 *
 * @author ao0729
 */
class TrafficProxy extends TrafficProxyAbstract {
  
  
    
  public static String[] loadInfo() throws MalformedURLException, IOException{
    String time="";
    String[] result = new String[2];
    result[0] = "<please wait>";
    result[1] = "<please wait>";
    return result;
  }

}