package traveller.mediator;

import java.util.ArrayList;

import traveller.model.*;

public interface TravellerModel
{
   public void addHotel(Hotel hotel);
   public ArrayList<Hotel> searchHotelByCity(String city);
   public ArrayList<Hotel> searchHotelByAddress(String address);
   public double reserve(User user, Hotel hotel, MyDate checkIn, MyDate checkOut, int sRn, int dRn, int tRn, int apN);
   public String getHotels();
   
}
