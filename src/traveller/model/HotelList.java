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
   
   public Hotel editHotel(int id, Hotel newHotel)
   {
      for(int i = 0; i < hotelList.size(); i++)
      {
         if( hotelList.get(i).getHotelId() == id)
         {
            hotelList.set(i, newHotel);
            break;
         }
      }
      return newHotel;
   }
   
   public void deleteHotel(int id)
   {
      for(int i = 0; i < hotelList.size(); i++)
      {
         if( hotelList.get(i).getHotelId() == id)
         {
            hotelList.remove(i);
            break;
         }
      }
   }
   
   public int size()
   {
      return hotelList.size();
   }
   
   public ArrayList<Hotel> getHotelsInCity(String city)
   {
      ArrayList<Hotel> hotels = new ArrayList<Hotel>();
      
      for(int i = 0; i < hotelList.size(); i++)
      {
         if(hotelList.get(i).getCity().equalsIgnoreCase(city.toLowerCase()))
         {
            hotels.add(hotelList.get(i));
         }
      }
      
      return hotels;
         
   }
   
   public ArrayList<Hotel> getHotelsByName(String name)
   {
      ArrayList<Hotel> hotels = new ArrayList<Hotel>();
      for (int i = 0; i < hotelList.size(); i++)
      {
         if (hotelList.get(i).getName().contains(name))
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
         if(hotelList.get(i).getAddress().equalsIgnoreCase(address))
         {
            hotels.add(hotelList.get(i));
         }
      }
      
      return hotels;
   }
   
   public Hotel getHotel(int index)
   {
      return hotelList.get(index);
   }
   
   public String toString()
   {
      String res = "";
      for( int i = 0; i < hotelList.size(); i++)
      {
         res = res + hotelList.get(i).toString() + "\n";
      }
      return res;
   }
}
