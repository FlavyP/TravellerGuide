package traveller.mediator;

import java.util.ArrayList;
import java.util.Observable;

import traveller.model.Hotel;
import traveller.model.HotelList;
import traveller.model.MyDate;
import traveller.model.ReservationList;
import traveller.model.User;

public class TravellerClientModelManager extends Observable implements TravellerModel
{

   private ReservationList resList;
   private HotelList hList;
   
   public TravellerClientModelManager()
   {
      resList = new ReservationList();
      hList = new HotelList();
   }
   @Override
   public void addHotel(Hotel hotel)
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public ArrayList<Hotel> searchHotelByCity(String city)
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public ArrayList<Hotel> searchHotelByAddress(String address)
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public double reserve(User user, Hotel hotel, MyDate checkIn,
         MyDate checkOut, int sRn, int dRn, int tRn, int apN)
   {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public String getHotels()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Hotel getHotel(int index)
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void showAnswer(String answer)
   {
      setChanged();
      notifyObservers(answer);
   }

}
