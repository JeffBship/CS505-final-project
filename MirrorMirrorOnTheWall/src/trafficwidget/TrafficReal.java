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
  
  private static final String[] urlArray = {
    "https://www.google.com/maps/dir/205+Main+St,+Wallingford,+CT+06492/CCSU,+Stanley+Street,+New+Britain,+CT/@41.5803555,-72.9037839,11z/data=!3m1!4b1!4m13!4m12!1m5!1m1!1s0x89e7cec9f049a787:0xd4504476e463e401!2m2!1d-72.828807!2d41.480756!1m5!1m1!1s0x89e7b266eb15e0a5:0xa92a64e8673c71fb!2m2!1d-72.764167!2d41.693255",
    "https://www.google.com/maps/dir/205+Main+St,+Wallingford,+CT+06492/12+Washington+Street,+New+Britain,+CT/@41.5652172,-72.9037839,11z/data=!3m1!4b1!4m13!4m12!1m5!1m1!1s0x89e7cec9f049a787:0xd4504476e463e401!2m2!1d-72.828807!2d41.480756!1m5!1m1!1s0x89e7b3c97926845d:0x6812415c8f4dae27!2m2!1d-72.7838029!2d41.6680229",
    "https://www.google.com/maps/dir/205+Main+St,+Wallingford,+CT+06492/241+W+Main+St,+Meriden,+CT+06451/@41.5099412,-72.8546865,13z/data=!3m1!4b1!4m13!4m12!1m5!1m1!1s0x89e7cec9f049a787:0xd4504476e463e401!2m2!1d-72.828807!2d41.480756!1m5!1m1!1s0x89e7c98c62f0f903:0xb7707f8cdbfa5a1a!2m2!1d-72.8110023!2d41.5394042",
    "https://www.google.com/maps/dir/205+Main+St,+Wallingford,+CT+06492/38+Town+Line+Road,+Rocky+Hill,+CT/@41.5723746,-72.8833905,11z/data=!3m1!4b1!4m13!4m12!1m5!1m1!1s0x89e7cec9f049a787:0xd4504476e463e401!2m2!1d-72.828807!2d41.480756!1m5!1m1!1s0x89e64d9b4d8b9dc1:0xa7258352fb9003d!2m2!1d-72.655705!2d41.682278",
    "https://www.google.com/maps/dir/205+Main+St,+Wallingford,+CT+06492/50+Stonegate+Rd,+New+Britain,+CT+06053/@41.5736641,-72.9426702,11z/data=!3m1!4b1!4m13!4m12!1m5!1m1!1s0x89e7cec9f049a787:0xd4504476e463e401!2m2!1d-72.828807!2d41.480756!1m5!1m1!1s0x89e7b18373b22d01:0xb62a0197f63c7ca6!2m2!1d-72.8135117!2d41.6819179"
    };
  
  private static final String[] nameArray = {
    "school", 
    "daycare", 
    "work", 
    "church", 
    "mall"
    };
  
  private static int destination=3;
  
  public static void nextDestination(){
    destination++;
    if (destination > urlArray.length-1 ){
      destination = 0;
    }
    System.out.println("The destination index is:  " +destination );
  }
  public static void previousDestination(){
    destination--;
    if (destination < 0 ){
      destination = urlArray.length-1;
    }
  }
  
  
  
    
  public static String[] loadInfo() throws MalformedURLException, IOException{
    String time="";
    String[] result = new String[2];
    result[0] = nameArray[destination];
    
    URL url = new URL(urlArray[destination]);
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