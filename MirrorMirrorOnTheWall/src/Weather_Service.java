
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
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
     * URL for the API.
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
        //Get the current location from the widget and send the query to the API
         String currentLocation = WeatherWidget.getInstance().getLocation();
         String url = URL+"/locations/v1/cities/search?apikey=" + API_KEY + "&q="+URLEncoder.encode(currentLocation, "UTF-8");
         
         
        HttpURLConnection httpcon = (HttpURLConnection)(new URL(url).openConnection());
         httpcon.setRequestMethod("GET");
         httpcon.setDoOutput(true);
         httpcon.connect();
         
         //Read the input string from the API, which contains JSON. Read all of the info
         
         String jsonString = ReadAllJSON(httpcon.getInputStream());
        //JSON is returned in [{DATA}], which means an array.
        
         JSONArray jsonLocationSearch = new JSONArray(jsonString);
          
         //Only one object is returned so it's okay to hardcode 0 here.
         JSONObject jsonLocation = jsonLocationSearch.getJSONObject(0);
          
         //return the value from the "Key" key
         return jsonLocation.getString("Key");
        
    }
    
    private String ReadAllJSON(InputStream is) throws IOException
    {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        StringBuilder jsonString = new StringBuilder();
        int read;
        char[] chars = new char[1024];
        while ((read = buffReader.read(chars)) != -1)
            jsonString.append(chars, 0, read); 
        
        return jsonString.toString();
    }
    
    /**
     * Gets the JSON response from Accuweather for the today's forecast for the Weather Widget's current location
     * @return the string representation of the current forecast. 
     */
    public HashMap GetDailyForecast(){
        try
        {
            String locationKey = GetLocationKey(WeatherWidget.getInstance().getLocation());
            
            HttpURLConnection httpcon = (HttpURLConnection) ((new URL(URL+"/forecasts/v1/daily/1day/" + locationKey+"?apikey="+API_KEY).openConnection()));
         httpcon.setRequestMethod("GET");
         httpcon.setDoOutput(true);
         httpcon.connect();

         //Read the input string from the API, which contains JSON. Read all of the info
         
         String jsonString = ReadAllJSON(httpcon.getInputStream());
        //JSON is returned in [{DATA}], which means an array.
        
          
         //Only one object is returned so it's okay to hardcode 0 here.
         JSONObject jsonDaily = new JSONObject(jsonString);
         
         JSONObject jsonHeadline = jsonDaily.getJSONObject("Headline");
         JSONArray jsonDailyForecast = jsonDaily.getJSONArray("DailyForecasts");
         
         JSONObject jsonTemperature = jsonDailyForecast.getJSONObject(0).getJSONObject("Temperature");
         JSONObject jsonMaximum = jsonTemperature.getJSONObject("Maximum");
         JSONObject jsonMinimum = jsonTemperature.getJSONObject("Minimum");
         
         HashMap<String,String> dailyForcast = new HashMap();
         
         dailyForcast.put("Text", jsonHeadline.getString("Text"));
         
         dailyForcast.put("Category", jsonHeadline.getString("Category"));
         dailyForcast.put("TempMax", jsonMaximum.getString("Value") + jsonMaximum.getString("Unit"));
         dailyForcast.put("TempMin", jsonMinimum.getString("Value") + jsonMinimum.getString("Unit"));
         
         return dailyForcast;
        
        }
        catch(IOException | JSONException ex)
        {
            System.out.println("EXCEPTION: "+ ex);
            return new HashMap();
        }
    }
    
    /**
     * Gets the JSON response from Accuweather for the forecast of the next 5 days for the Weather Widget's current location
     * @return the string representation of the week's forecast. 
     */
    public ArrayList<HashMap> GetWeeklyForecast(){
        try
        {
            String locationKey = GetLocationKey(WeatherWidget.getInstance().getLocation());
            
            HttpURLConnection httpcon = (HttpURLConnection) ((new URL(URL+"/forecasts/v1/daily/5day/" + locationKey+"?apikey="+API_KEY).openConnection()));
         httpcon.setRequestMethod("GET");
         httpcon.setDoOutput(true);
         httpcon.connect();
         
          //Read the input string from the API, which contains JSON. Read all of the info
         
         String jsonString = ReadAllJSON(httpcon.getInputStream());
        //JSON is returned in [{DATA}], which means an array.
        
          
         //Only one object is returned so it's okay to hardcode 0 here.
         JSONObject jsonWeekly = new JSONObject(jsonString);
         
         JSONObject jsonHeadline = jsonWeekly.getJSONObject("Headline");
         JSONArray jsonWeeklyForecast = jsonWeekly.getJSONArray("DailyForecasts");
         
         ArrayList<HashMap> listHM = new ArrayList<HashMap>();
         
         for(int i = 0; i < jsonWeeklyForecast.length(); i++)
         {
            JSONObject jsonTemperature = jsonWeeklyForecast.getJSONObject(i).getJSONObject("Temperature");
            JSONObject jsonMaximum = jsonTemperature.getJSONObject("Maximum");
            JSONObject jsonMinimum = jsonTemperature.getJSONObject("Minimum");

            HashMap<String,String> dailyForcast = new HashMap();

            dailyForcast.put("Text", jsonHeadline.getString("Text"));

            dailyForcast.put("Category", jsonHeadline.getString("Category"));
            dailyForcast.put("TempMax", jsonMaximum.getString("Value") + jsonMaximum.getString("Unit"));
            dailyForcast.put("TempMin", jsonMinimum.getString("Value") + jsonMinimum.getString("Unit"));
            
            listHM.add((dailyForcast));
            
         }
         
         
         return listHM;
        
        }
        catch(IOException | JSONException ex){
            
            System.out.println("EXCEPTION: "+ ex);
            return new ArrayList<HashMap>();
        }
    }
    
    /**
     * Gets the JSON response from Accuweather for the hourly forecast for the Weather Widget's current location
     * @return the string representation of the hourly forecast. 
     */
    public ArrayList<HashMap> GetHourlyForecast(){
        try
        {
            String locationKey = GetLocationKey(WeatherWidget.getInstance().getLocation());
            
            HttpURLConnection httpcon = (HttpURLConnection) ((new URL(URL+"/forecasts/v1/hourly/12hour/" + locationKey +"?apikey="+API_KEY).openConnection()));
         httpcon.setRequestMethod("GET");
         httpcon.setDoOutput(true);
         httpcon.connect();
         
         
          //Read the input string from the API, which contains JSON. Read all of the info
         
         String jsonString = ReadAllJSON(httpcon.getInputStream());
        //JSON is returned in [{DATA}], which means an array.
        
          
         //Only one object is returned so it's okay to hardcode 0 here.
         JSONArray jsonHourly = new JSONArray(jsonString);
         
         
         ArrayList<HashMap> listHM = new ArrayList<HashMap>();
         
         for(int i = 0; i < jsonHourly.length(); i++)
         {
             
            JSONObject jsonHour = jsonHourly.getJSONObject(i);
            
            JSONObject jsonTemperature = jsonHourly.getJSONObject(i).getJSONObject("Temperature");

            HashMap<String,String> hourlyForecast = new HashMap();

            hourlyForecast.put("IconPhrase", jsonHour.getString("IconPhrase"));
            hourlyForecast.put("Temperature", jsonTemperature.getString("Value") +  jsonTemperature.getString("Unite"));
            
            listHM.add((hourlyForecast));
            
         }
         
         return listHM;
        
        }
        catch(IOException | JSONException ex){
            
            System.out.println("EXCEPTION: "+ ex);
            return new ArrayList<HashMap>();
        }
    }
}
