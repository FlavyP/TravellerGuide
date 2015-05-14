package traveller.model;

import java.util.ArrayList;

public class HotelList
{
   
   private ArrayList<Hotel> hotellist;

   public HotelList()
   {
      hotellist = new ArrayList<Hotel>();
   }
   
   public void addHotel(Hotel hotel)
   {
      hotellist.add(hotel);
   }
   
   public int getHowManyHotels()
   {
      return hotellist.size();
   }
   
   public ArrayList<Hotel> getHotelsInCity(String city)
   {
      ArrayList<Hotel> hotels = new ArrayList<Hotel>();
      
      for(int i = 0; i < hotellist.size(); i++)
      {
         if(hotellist.get(i).getCity().equals(city))
         {
            hotels.add(hotellist.get(i));
         }
      }
      
      return hotels;
         
   }
   
   public ArrayList<Hotel> getHotelsInAddress(String address)
   {
      ArrayList<Hotel> hotels = new ArrayList<Hotel>();
      
      for(int i = 0; i < hotellist.size(); i++)
      {
         if(hotellist.get(i).getAddress().equals(address))
         {
            hotels.add(hotellist.get(i));
         }
      }
      
      return hotels;
   }
}
