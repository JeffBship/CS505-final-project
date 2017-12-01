/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficwidget;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author ao0729
 */
class TrafficProxy  {
  
  
    
  public static String[] loadInfo() throws MalformedURLException, IOException{
    String time="";
    String[] result = new String[2];
    result[0] = "<please wait>";
    result[1] = "<please wait>";
    return result;
  }

}