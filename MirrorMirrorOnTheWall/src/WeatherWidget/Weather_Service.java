package WeatherWidget;


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

    private static Weather_Service weatherService = new Weather_Service();
    
    
    protected Weather_Service()
    {
    }
    
    /**
     * Get the current instance of the Weather_Service
     * @return the instance of the Weather Service
     */
    public static Weather_Service getInstance()
    {
        return weatherService;
    }
    
    /**
     * API Key used to access the API.
     */
    protected final String API_KEY = "uRepHxpqZg8bPIXxVfuFlrT4omTjGNO4";//"uRepHxpqZg8bPIXxVfuFlrT4omTjGNO4";//

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
    
    public void UpdateCurrentWeather() throws IOException
    {
        String locationKey = GetLocationKey(WeatherWidget.getInstance().getLocation());
            
            HttpURLConnection httpcon = (HttpURLConnection) ((new URL(URL+"/currentconditions/v1/" + locationKey+"?apikey="+API_KEY).openConnection()));
         httpcon.setRequestMethod("GET");
         httpcon.setDoOutput(true);
         httpcon.connect();

         //Read the input string from the API, which contains JSON. Read all of the info
         
         String jsonString = ReadAllJSON(httpcon.getInputStream());
         
         JSONObject jsonCurrent = new JSONObject(jsonString);
         JSONObject jsonTemperature = jsonCurrent.getJSONObject("Temperature");
         JSONObject jsonMetric = jsonCurrent.getJSONObject("Metric");
         
        WeatherWidget.getInstance().setCurrentTemperature(jsonMetric.getInt("Value"));
        WeatherWidget.getInstance().setCurrentWeather(jsonCurrent.getString("WeatherText"));
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
    public ArrayList<HashMap> GetDailyForecast(){
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
         JSONObject jsonDailyForecast = jsonDaily.getJSONArray("DailyForecasts").getJSONObject(0); //since this is the daily forecast, there's only one object
         
         JSONObject jsonTemperature = jsonDailyForecast.getJSONObject("Temperature");
         JSONObject jsonMaximum = jsonTemperature.getJSONObject("Maximum");
         JSONObject jsonMinimum = jsonTemperature.getJSONObject("Minimum");
         
         HashMap<String,String> dailyForcast = new HashMap();
         
         dailyForcast.put("Text", jsonHeadline.getString("Text"));
         
         JSONObject jsonDay = jsonDailyForecast.getJSONObject("Day");
         
         dailyForcast.put("Icon", jsonDay.get("Icon").toString());
         dailyForcast.put("IconPhrase", jsonDay.getString("IconPhrase"));
         
         dailyForcast.put("TempMax", jsonMaximum.get("Value").toString());
         dailyForcast.put("TempMin", jsonMinimum.get("Value").toString());
         
         
         dailyForcast.put("TemperatureUnit",jsonMinimum.getString("Unit"));
         
         ArrayList<HashMap> hm = new ArrayList<HashMap>();
         hm.add(dailyForcast);
         
         return hm;
        
        }
        catch(IOException | JSONException ex)
        {
            System.out.println("EXCEPTION: "+ ex);
            return new ArrayList<HashMap>();
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
             JSONObject jsonDaily = jsonWeeklyForecast.getJSONObject(i);
             
            JSONObject jsonTemperature = jsonDaily.getJSONObject("Temperature");
            JSONObject jsonMaximum = jsonTemperature.getJSONObject("Maximum");
            JSONObject jsonMinimum = jsonTemperature.getJSONObject("Minimum");

            HashMap<String,String> dailyForcast = new HashMap();

            dailyForcast.put("Text", jsonHeadline.getString("Text"));

            JSONObject jsonDay = jsonDaily.getJSONObject("Day");
            
            dailyForcast.put("Icon", jsonDay.get("Icon").toString());
            dailyForcast.put("IconPhrase", jsonDay.getString("IconPhrase"));
            dailyForcast.put("TempMax", jsonMaximum.get("Value").toString());
            dailyForcast.put("TempMin", jsonMinimum.get("Value").toString());
            
            dailyForcast.put("TemperatureUnit",jsonMinimum.getString("Unit"));
            
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
            hourlyForecast.put("Icon", jsonHour.get("WeatherIcon").toString());
            hourlyForecast.put("Temperature", jsonTemperature.get("Value").toString());
            hourlyForecast.put("TemperatureUnit",jsonTemperature.getString("Unit"));
            
            listHM.add((hourlyForecast));
            
         }
         
         return listHM;
        
        }
        catch(IOException | JSONException ex){
            
            System.out.println("EXCEPTION: "+ ex);
            return new ArrayList<HashMap>();
        }
    }
    
    /**
     * Returns the average temperature given a temperature range
     * @param tempA
     * @param tempB
     * @return average temperature
     */
    public double GetTemperatureAverage(double tempA, double tempB)
    {
        return ((tempA + tempB) / 2.0);
    }
    
    /**
     * Gets the associated image related the the icon number.
     * @param icon number related the the current weather pattern
     * @return the image name (and extension) that corresponds to the icon number.
     */
    public String GetIconImage(int icon)
    {
        
        if(icon == WeatherPattern.SUNNY.getPatternID())
        {
            return "1.png";
        }
        else if(icon == WeatherPattern.PARTLY_SUNNY.getPatternID() 
                || icon == WeatherPattern.MOSTLY_CLEAR.getPatternID()
                || icon == WeatherPattern.MOSTLY_SUNNY.getPatternID()
                || icon == WeatherPattern.INTERMITTENT_CLOUDS.getPatternID()
                || icon == WeatherPattern.HAZY_SUNSHINE.getPatternID())
        {
            
            return "3.png";
        }
        else if(icon == WeatherPattern.CLOUDY.getPatternID() 
                || icon == WeatherPattern.DREARY.getPatternID()
                || icon == WeatherPattern.FOG.getPatternID())
        {
            
            return "7.png";
        }
        else if(icon == WeatherPattern.SHOWERS.getPatternID() 
                || icon == WeatherPattern.PARTLY_SUNNY_SHOWERS.getPatternID()
                || icon == WeatherPattern.MOSTLY_CLOUDY_SHOWERS.getPatternID())
        {
            
            return "14.png";
        }
        else if(icon == WeatherPattern.T_STORMS.getPatternID())
        {
            
            return "15.png";
        }
        else if(icon == WeatherPattern.MOSTLY_CLOUDY_T_STORMS.getPatternID() 
                || icon == WeatherPattern.PARTLY_CLOUDY_T_STORMS.getPatternID())
        {
            
            return "17.png";
        }
        else if(icon == WeatherPattern.RAIN.getPatternID() )
        {
            
            return "18.png";
        }
        else if(icon == WeatherPattern.FLURRIES.getPatternID() )
        {
            
            return "22.png";
        }
        else if(icon == WeatherPattern.MOSTLY_CLOUDY_FLURRIES.getPatternID() 
                || icon == WeatherPattern.PARTLY_SUNNY_FLURRIES.getPatternID())
        {
            
            return "21.png";
        }
        else if(icon == WeatherPattern.SNOW.getPatternID()
                || icon == WeatherPattern.MOSTLY_CLOUDY_SNOW.getPatternID()
                || icon == WeatherPattern.SLEET.getPatternID()
                || icon == WeatherPattern.ICE.getPatternID())
        {
            
            return "20.png";
        }
        else if(icon == WeatherPattern.FREEZING_RAIN.getPatternID() 
                || icon == WeatherPattern.RAIN_AND_SNOW.getPatternID())
        {
            
            return "29.png";
        }
        else if(icon == WeatherPattern.HOT.getPatternID() )
        {
            
            return "30.png";
        }
        else if(icon == WeatherPattern.COLD.getPatternID() )
        {
            
            return "31.png";
        }
        else if(icon == WeatherPattern.WINDY.getPatternID() )
        {
            
            return "32.png";
        }
        else if(icon == WeatherPattern.CLEAR.getPatternID() )
        {
            
            return "33.png";
        }
        else if(icon == WeatherPattern.MOSTLY_CLEAR.getPatternID() 
                || icon == WeatherPattern.PARTLY_CLEAR.getPatternID()
                || icon == WeatherPattern.INTERMITTMENT_CLOUDS_NIGHT.getPatternID()
                || icon == WeatherPattern.HAZY_MOONLIGHT.getPatternID()
                || icon == WeatherPattern.MOSTLY_CLOUDY_NIGHT.getPatternID())
        {
            
            return "38.png";
        }
        else if(icon == WeatherPattern.PARTLY_CLOUDY_SHOWERS_NIGHT.getPatternID() 
                || icon == WeatherPattern.MOSTLY_CLOUDY_SHOWERS_NIGHT.getPatternID())
        {
            
            return "40.png";
        }
        else if(icon == WeatherPattern.PARTLY_CLOUDY_T_STORMS_NIGHT.getPatternID() 
                || icon == WeatherPattern.MOSTLY_CLOUDY_T_STORMS_NIGHT.getPatternID())
        {
            
            return "44.png";
        }
        else if(icon == WeatherPattern.MOSTLY_CLOUDY_FLURRIES_NIGHT.getPatternID() 
                || icon == WeatherPattern.MOSTLY_CLOUDY_SNOW_NIGHT.getPatternID())
        {
            
            return "45.png";
        }
        else
        {
            return "error.png";
        }
    }
    
}
