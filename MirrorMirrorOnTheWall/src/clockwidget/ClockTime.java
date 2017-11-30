/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clockwidget;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author James Luczynski
 */
public class ClockTime {
    
    public static String get(){
        String time, hours, minutes;
        Calendar calendar = Calendar.getInstance();
        hours =  calendar.get(Calendar.HOUR) + "";
        hours = (hours.equals("0")) ? "12" : hours;
        hours = (hours.length() == 1) ? "0" + hours : hours;
        minutes =  calendar.get(Calendar.MINUTE) + "";
        minutes = (minutes.length() == 1) ? "0" + minutes : minutes;
        time = hours + " : " + minutes + " ";
        time += calendar.get(Calendar.AM_PM) == 0 ? "AM" : "PM";
        return time;
    }
}
