package traveller.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * A class representing the Google Directions API.
 * 
 * @author Flavian Popa
 * @author Gytis Kuosaitis
 * @author Julius Jurgauskas
 * @author Mihaela Diaconescu
 * @version 1.0
 */

public class GooglePlaces
{
   private URL url;
   private HttpURLConnection conn;
   private String line, outputString = "";
   private BufferedReader reader;
   private JSONObject obj;
   private JSONArray results;
   
   /**
    * Four-argument constructor.
    * @param lat origin's latitude.
    * @param lng origin's longitude.
    * @param radius the given radius.
    * @param type the type of place.
    * @throws IOException exception
    */
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
   
   /**
    * Gets the number of places.
    * @return number of places.
    */
   public int numberOfPlaces()
   {
      return results.length();
   }
   
   /**
    * Gets a place rating.
    * @param index places' index.
    * @return the rating of the place.
    */
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
   
   /**
    * Gets the number places.
    * @return number of places.
    */
   public int getNumberPlaces()
   {
      return results.length();
   }
   
   /**
    * Gets a place name.
    * @param index place's index.
    * @return the place name.
    */
   public String getPlaceName(int index)
   {
      JSONObject place = results.getJSONObject(index);
      return place.getString("name");
   }
   
   /**
    * Gets a place latitude.
    * @param index place's index.
    * @return the place latitude.
    */
   public double getPlaceLat(int index)
   {
      JSONObject place = results.getJSONObject(index);
      JSONObject geometry = place.getJSONObject("geometry");
      JSONObject location = geometry.getJSONObject("location");
      return location.getDouble("lat");
   }
   
   /**
    * Gets a place longitude.
    * @param index place's index.
    * @return the place longitude.
    */
   public double getPlaceLng(int index)
   {
      JSONObject place = results.getJSONObject(index);
      JSONObject geometry = place.getJSONObject("geometry");
      JSONObject location = geometry.getJSONObject("location");
      return location.getDouble("lng");
   }
   
   /**
    * Gets a place address.
    * @param index place's index.
    * @return the place address.
    */
   public String getAddress(int index)
   {
      JSONObject place = results.getJSONObject(index);
      return place.getString("vicinity");
   }
   
   /**
    * Gets a place address ready for Google Directions API.
    * @param index place's index.
    * @return the place address ready for Google Directions API.
    */
   public String getAddressForMaps(int index)
   {
      JSONObject place = results.getJSONObject(index);
      String vicinity = place.getString("vicinity");
      vicinity = vicinity.replaceAll(", ", "|");
      vicinity = vicinity.replaceAll(" ", "+");
      return vicinity;
   }
   
   /**
    * Prints a list of all places including ID, name, rating and address.
    */
   public void printAllPlaces()
   {
      for(int i = 0; i < results.length(); i++)
      {
         System.out.println("Place " + (i+1) + ": " + getPlaceName(i));
         System.out.println(("Rating: " + getRating(i)));
         System.out.println("Address: " + getAddress(i) + "\n");
         
      }
   }
   
   /**
    * Gets all the places information.
    * @return two-dimensional array with all the places information: ID, name, address and rating.
    */
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
