package traveller.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;

public class GoogleDirections
{
   private URL url;
   private HttpURLConnection conn;
   private String line, outputString = "";
   private BufferedReader reader;
   private JSONObject obj, route, legs, totalDistance, totalDuration;
   private JSONArray steps;
   private double[] placeLatLng = new double[2];
   
   public GoogleDirections(double lat, double lng, String dest) throws IOException
   {
      dest = dest.replaceAll(", ", "|");
      dest = dest.replaceAll(" ", "+");
      url = new URL("https://maps.googleapis.com/maps/api/directions/json?origin=" + lat + "," 
      + lng + "&destination=" + dest + "&mode=walking");
      conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      while ((line = reader.readLine()) != null)
      {
         outputString += line + "\n";
      }
      obj = new JSONObject(outputString);
      route = obj.getJSONArray("routes").getJSONObject(0);
      legs = route.getJSONArray("legs").getJSONObject(0);
      steps = legs.getJSONArray("steps");
      totalDistance = legs.getJSONObject("distance");
   }
   
   public GoogleDirections(double orgLat, double orgLng, double dstLat, double dstLng) throws IOException
   {
      url = new URL("https://maps.googleapis.com/maps/api/directions/json?origin=" + orgLat + "," 
   + orgLng + "&destination=" + dstLat + "," + dstLng + "&mode=walking");
      conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      while ((line = reader.readLine()) != null)
      {
         outputString += line + "\n";
      }
      obj = new JSONObject(outputString);
      route = obj.getJSONArray("routes").getJSONObject(0);
      legs = route.getJSONArray("legs").getJSONObject(0);
      steps = legs.getJSONArray("steps");
      totalDistance = legs.getJSONObject("distance");
   }
   
   public GoogleDirections(String origAddess, String origCity, double dstLat, double dstLng) throws IOException
   {
      origAddess = origAddess.replaceAll(", ", "|");
      origAddess = origAddess.replaceAll(" ", "+");
      URL url2 = new URL(
            "http://maps.googleapis.com/maps/api/geocode/json?address=" + origAddess +"," +origCity + "&sensor=true");
      HttpURLConnection conn = (HttpURLConnection) url2.openConnection();
      conn.setRequestMethod("GET");
      BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
      String output = "", full = "";
      while ((output = br.readLine()) != null) {
          System.out.println(output);
          full += output;
      }
      JSONObject obj2 = new JSONObject(full);
      JSONArray results2 = obj2.getJSONArray("results");
      JSONObject place = results2.getJSONObject(0);
      JSONObject geometry = place.getJSONObject("geometry");
      JSONObject location = geometry.getJSONObject("location");
      double placeLat =location.getDouble("lat");
      double placeLng = location.getDouble("lng");
      System.out.println(placeLat + " " + placeLng);
      
      
      
      url = new URL("https://maps.googleapis.com/maps/api/directions/json?origin=" + placeLat +"," +placeLng + "&destination=" + dstLat + dstLng + "&mode=walking");
      conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      while ((line = reader.readLine()) != null)
      {
         outputString += line + "\n";
      }
      obj = new JSONObject(outputString);
      route = obj.getJSONArray("routes").getJSONObject(0);
      legs = route.getJSONArray("legs").getJSONObject(0);
      steps = legs.getJSONArray("steps");
      totalDistance = legs.getJSONObject("distance");
   }
   
   public GoogleDirections(String origAddess, String origCity) throws IOException
   {
      origAddess = origAddess.replaceAll(", ", "|");
      origAddess = origAddess.replaceAll(" ", "+");
      URL url2 = new URL(
            "http://maps.googleapis.com/maps/api/geocode/json?address=" + origAddess +"," +origCity + "&sensor=true");
      HttpURLConnection conn = (HttpURLConnection) url2.openConnection();
      conn.setRequestMethod("GET");
      BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
      String output = "", full = "";
      while ((output = br.readLine()) != null) {
          System.out.println(output);
          full += output;
      }
      JSONObject obj2 = new JSONObject(full);
      JSONArray results2 = obj2.getJSONArray("results");
      JSONObject place = results2.getJSONObject(0);
      JSONObject geometry = place.getJSONObject("geometry");
      JSONObject location = geometry.getJSONObject("location");
      double placeLat =location.getDouble("lat");
      double placeLng = location.getDouble("lng");
      System.out.println(placeLat + " " + placeLng);
      placeLatLng[1] = placeLat;
      placeLatLng[2] = placeLng;
   }
   
   public double[] getPlaceLatAndLng()
   {
      return placeLatLng;
   }
   
   public String getTotalDistance()
   {
      String totalValueDistance = totalDistance.getString("text");
      return totalValueDistance;
   }
   
   public String getTotalDuration()
   {
      totalDuration = legs.getJSONObject("duration");
      return totalDuration.getString("text");
   }
   
   public int getNumberSteps()
   {
      return steps.length();
   }
   
   public String getStepDistance(int index)
   {
      JSONObject step = steps.getJSONObject(index);
      JSONObject stepDistanceObj = step.getJSONObject("distance");
      return stepDistanceObj.getString("text");
      
   }
   
   public String getStepDuration(int index)
   {
      JSONObject step = steps.getJSONObject(index);
      JSONObject stepDurationObj = step.getJSONObject("duration");
      return stepDurationObj.getString("text");
   }
   
   public String getStepInstruction(int index)
   {
      JSONObject step = steps.getJSONObject(index);
      String stepInstructionsObj = step.getString("html_instructions");
      return Jsoup.parse(stepInstructionsObj).text();
   }
   
   public void printSteps()
   {
      String stepDistance = "";
      String stepDuration = "";
      System.out.println();
      System.out.println("Instructions: ");
      for (int i = 0; i < getNumberSteps(); i++)
      {
         JSONObject step = steps.getJSONObject(i);
         System.out.println("Step: " + (i+1));
         
         JSONObject stepDistanceObj = step.getJSONObject("distance");
         stepDistance = stepDistanceObj.getString("text");
         System.out.println("Step distance: " + stepDistance);
         
         JSONObject stepDurationObj = step.getJSONObject("duration");
         stepDuration = stepDurationObj.getString("text");
         System.out.println("Step duration: " + stepDuration);
         
         String stepInstructionsObj = step.getString("html_instructions");
         System.out.println("Normal Instructions: " + Jsoup.parse(stepInstructionsObj).text() + "\n");         
      }
   }
   
   public String getInformation()
   {
      String res = "";
      for(int i = 0; i < steps.length(); i++)
      {
         res = res + "Step " + (i+1) + ": " + getStepDistance(i) + "; " + getStepDuration(i) + "; " + getStepInstruction(i) + "\n";
      }
      res = res + "Total distance: " + getTotalDistance() + "; Total duration: " + getTotalDuration();
      return res;
   }
}
