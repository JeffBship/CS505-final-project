
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;


/*
 * This class communicates with the accuweather API to gather weather information. Functions include getting weekly, daily, and hourly information
 */

/**
 *
 * @author melmulcahy
 */
public class Weather_Service 
{

    /**
     * API Key used to access the API.
     */
    protected final String API_KEY = "uRepHxpqZg8bPIXxVfuFlrT4omTjGNO4";

    /**
     * URL for the api.
     */
    protected final String URL = "http://dataservice.accuweather.com";
    
    /**
     * Get the location key associated with location from the weather widget.
     * @param location
     * @return
     * @throws MalformedURLException
     * @throws IOException 
     */
    private String GetLocationKey(String location) throws MalformedURLException, IOException
    {
        
        HttpURLConnection httpcon = (HttpURLConnection) ((new URL(URL+"locations/v1/cities/search").openConnection()));
         httpcon.setRequestMethod("GET");
         httpcon.connect();
         /*
          * Output user credentials over HTTP Output Stream
          */
         
         String currentLocation = WeatherWidget.getInstance().getLocation();
         
         byte[] outputBytes = ("{'apikey': '" + API_KEY +"', 'q':'"+currentLocation+"', 'language':'en-us', 'details':false, 'offset':0, 'alias':'NoOfficalMatchFound',}").getBytes("UTF-8");
         
         OutputStream os = httpcon.getOutputStream();
         os.write(outputBytes);
         os.close();
         /*
          * Call Function setCookie and pass the HttpUrlConnection. Set Function
          * will return a Cookie String used to authenticate user.
          */
         
         String response = httpcon.getResponseMessage();
         JSONObject jsonLocationSearch = new JSONObject(response);
         
         jsonLocationSearch.get("Key");
         
         return jsonLocationSearch.get("Key").toString();
        
    }
}
