package traveller.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class GooglePlaces
{
   private URL url;
   private HttpURLConnection conn;
   private String line, outputString = "";
   private BufferedReader reader;
   private JSONObject obj;
   private JSONArray results;
   
   public GooglePlaces (double lat, double lng, int radius, String type) throws IOException
   {
      url = new URL("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + lat 
            + "," + lng + "&radius=" + radius + "&types=" 
            + type + "&key=AIzaSyDKrbFhLvNecSS1uAN9iYmhOe7aKayvGB0");
      conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      while ((line = reader.readLine()) != null)
      {
         outputString += line + "\n";
      }
      //System.out.println(outputString);
      obj = new JSONObject(outputString);
      results = obj.getJSONArray("results");
   }
   
   public int numberOfPlaces()
   {
      return results.length();
   }
   public double getRating(int index)
   {
      JSONObject ratings = results.getJSONObject(index);
      double rating = 0;
      try
      {
         rating = ratings.getDouble("rating");
      }
      catch (Exception e)
      {
         
      }
      return rating;
   }
   
   public int getNumberSteps()
   {
      return results.length();
   }
   
   public String getPlaceName(int index)
   {
      JSONObject place = results.getJSONObject(index);
      return place.getString("name");
   }
   
   public double getPlaceLat(int index)
   {
      JSONObject place = results.getJSONObject(index);
      JSONObject geometry = place.getJSONObject("geometry");
      JSONObject location = geometry.getJSONObject("location");
      return location.getDouble("lat");
   }
   
   public double getPlaceLng(int index)
   {
      JSONObject place = results.getJSONObject(index);
      JSONObject geometry = place.getJSONObject("geometry");
      JSONObject location = geometry.getJSONObject("location");
      return location.getDouble("lng");
   }
   
   public String getAddress(int index)
   {
      JSONObject place = results.getJSONObject(index);
      return place.getString("vicinity");
   }
   
   public String getAddressForMaps(int index)
   {
      JSONObject place = results.getJSONObject(index);
      String vicinity = place.getString("vicinity");
      vicinity = vicinity.replaceAll(", ", "|");
      vicinity = vicinity.replaceAll(" ", "+");
      return vicinity;
   }
   
   public void printAllPlaces()
   {
      for(int i = 0; i < results.length(); i++)
      {
         System.out.println("Place " + (i+1) + ": " + getPlaceName(i));
         System.out.println(("Rating: " + getRating(i)));
         System.out.println("Address: " + getAddress(i) + "\n");
         
      }
   }
   
   public String[][] getInformation()
   {
      String[][] res = new String[results.length()][4];
      for(int i = 0; i < results.length(); i++)
      {
         res[i][0] = "" + (i+1);
         res[i][1] = getPlaceName(i);
         res[i][2] = getAddress(i);
         res[i][3] = "" + getRating(i);
      }
      return res;
   }
}
