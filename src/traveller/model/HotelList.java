package traveller.model;

import java.util.ArrayList;

public class HotelList
{
   
   private ArrayList<Hotel> hotelList;

   public HotelList()
   {
      hotelList = new ArrayList<Hotel>();
   }
   
   public void addHotel(Hotel hotel)
   {
      hotelList.add(hotel);
   }
   
   public int getHowManyHotels()
   {
      return hotelList.size();
   }
   
   public ArrayList<Hotel> getHotelsInCity(String city)
   {
      ArrayList<Hotel> hotels = new ArrayList<Hotel>();
      
      for(int i = 0; i < hotelList.size(); i++)
      {
         if(hotelList.get(i).getCity().equals(city))
         {
            hotels.add(hotelList.get(i));
         }
      }
      
      return hotels;
         
   }
   
   public ArrayList<Hotel> getHotelsInAddress(String address)
   {
      ArrayList<Hotel> hotels = new ArrayList<Hotel>();
      
      for(int i = 0; i < hotelList.size(); i++)
      {
         if(hotelList.get(i).getAddress().equals(address))
         {
            hotels.add(hotelList.get(i));
         }
      }
      
      return hotels;
   }
   
   public String toString()
   {
      String res = "";
      for( int i = 0; i < hotelList.size(); i++)
      {
         res = res + "ID: " + i + ": " + hotelList.get(i).toString() + "\n";
      }
      return res;
   }
}
