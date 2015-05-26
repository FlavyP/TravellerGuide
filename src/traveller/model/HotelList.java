package traveller.model;

import java.util.ArrayList;

	/**
	 * A class representing a hotel.
	 * @author Flavian Popa
	 * @author Gytis Kuosaitis
	 * @author Julius Jurgauskas
	 * @author Mihaela Diaconescu
	 * @version 1.0
	 */

public class HotelList
{
   
   private ArrayList<Hotel> hotelList;
   
   /**
    * No-argument constructor
    */
   public HotelList()
   {
      hotelList = new ArrayList<Hotel>();
   }
   
   /**
    * Adds hotel to the hotel list
    * @param hotel what hotel will be added
    */
public void addHotel(Hotel hotel)
   {
      hotelList.add(hotel);
   }
   
   /**
    * Edits hotel at Id
    * @param id what hotel edit
    * @param newHotel with what replace old hotel
    * @return new hotel
    */
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
   
   /**
    * Removes hotel from the hotel list at Id
    * @param id with what Id remove hotel
    */
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
   
	/**
	 * Gets the hotel list size
	 * @return the hotel list size
	 */
public int size()
   {
      return hotelList.size();
   }
   
   /**
    * Gets hotel list by city
    * @param city what hotels will be selected by
    * @return hotel list by city
    */
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

	/**
	* Gets hotel list by name
	* @param name what hotels will be selected by
	* @return hotel list by name
	*/
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
   
   /**
    * Gets hotel list by address
    * @param address what hotels will be selected by
    * @return hotel list by address
    */
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
   
   /**
    * Gets hotel at index
	* @param index what hotel will be selected by
	* @return hotel at index
	*/
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
