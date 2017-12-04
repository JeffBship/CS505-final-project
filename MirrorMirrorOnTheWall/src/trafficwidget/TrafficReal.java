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

/**
 *
 * @author ao0729
 */
class TrafficReal extends TrafficProxyAbstract {
  
     
  public static String[] loadInfo(String name, String destination) throws MalformedURLException, IOException{
    String time="";
    String[] result = new String[2];
    result[0] = name;
    
    URL url = new URL(destination);
    String source = ""; 
    InputStreamReader streamReader = new InputStreamReader(url.openStream());
    BufferedReader reader = new BufferedReader(streamReader);
    String line; 
    while( (line=reader.readLine()) != null ){
      source += line;
      }
    reader.close();
    
    //find index of first "min"
    if ( source.contains("min") ){
      //remove leading characters
      int index = source.indexOf("min");
      int endIndex = index + 3;
      int beginIndex = index;
      //find the " before min
      while (source.charAt(beginIndex-1) != '"'){
        beginIndex--;
      }
      result[1] = source.substring( beginIndex, endIndex);
    }else{
      result[1] = "Time not found.";
    }
    return result;
  }

}