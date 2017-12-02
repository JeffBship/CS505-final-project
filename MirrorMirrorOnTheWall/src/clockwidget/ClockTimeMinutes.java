package clockwidget;

import java.util.Calendar;

/**
 *
 * @author James Luczynski
 */
public class ClockTimeMinutes implements ClockTime{
    
    public String get(){
        String time, hours, minutes;
        Calendar calendar = Calendar.getInstance();
        
        hours =  calendar.get(Calendar.HOUR) + "";
        hours = (hours.equals("0")) ? "12" : hours;
        
        minutes =  calendar.get(Calendar.MINUTE) + "";
        minutes = (minutes.length() == 1) ? "0" + minutes : minutes;
        
        time = hours + " : " + minutes + " ";
        time += calendar.get(Calendar.AM_PM) == 0 ? "AM" : "PM";
        return time;
    }
}
