package traveller.mediator;

import java.util.ArrayList;
import java.util.Observable;

import traveller.model.*;

public class TravellerModelManager extends Observable implements TravellerModel
{

   private ReservationList resList;
   private HotelList hList;
   
   public TravellerModelManager()
   {
      resList = new ReservationList();
      hList = new HotelList();
   }
   @Override
   public void addHotel(Hotel hotel)
   {
      hList.addHotel(hotel);
      super.setChanged();
      super.notifyObservers(hotel);
   }

   @Override
   public ArrayList<Hotel> searchHotelByCity(String city)
   {
      return hList.getHotelsInCity(city);
   }

   @Override
   public ArrayList<Hotel> searchHotelByAddress(String address)
   {
      return hList.getHotelsInAddress(address);
   }

   @Override
   public double reserve(User user, Hotel hotel, MyDate checkIn,
         MyDate checkOut, int sRn, int dRn, int tRn, int apN)
   {
      super.setChanged();
      super.notifyObservers(new Reservation(user, hotel, checkIn, checkOut, sRn, dRn, tRn, apN));
      return resList.reserve(user, hotel, checkIn, checkOut, sRn, dRn, tRn, apN);
   }

}
