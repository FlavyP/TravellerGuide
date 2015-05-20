package traveller.mediator;

import java.util.ArrayList;

import traveller.model.*;

public interface TravellerModel
{
   public void addHotel(Hotel hotel);
   public void addHotel(String[] hotel);
   public ArrayList<Hotel> searchHotelByName(String name);
   public ArrayList<Hotel> searchHotelByCity(String city);
   public ArrayList<Hotel> searchHotelByAddress(String address);
   public double reserve(Reservation res);
   public String getHotels();
   public Hotel getHotel(int index);
   public void showAnswer(String answer);
   public void addUser(User user);
   
}
