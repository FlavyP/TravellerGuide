package traveller.mediator;

import java.util.ArrayList;
import java.util.Observable;

import traveller.model.*;

public class TravellerModelManager extends Observable implements TravellerModel
{

   private ReservationList resList;
   private HotelList hList;
   private UserList userList;
   private ServerConnectionThread server;
   
   public TravellerModelManager()
   {
      resList = new ReservationList();
      hList = new HotelList();
      userList = new UserList();
      server = new ServerConnectionThread(this);
      server.start();
   }
   @Override
   public void addHotel(Hotel hotel)
   {
      hList.addHotel(hotel);
   }

   @Override
   public ArrayList<Hotel> searchHotelByCity(String city)
   {
      return hList.getHotelsInCity(city);
   }
   
   
   public ArrayList<Hotel> searchHotelByName(String name)
   {
      return hList.getHotelsByName(name);
   }

   @Override
   public ArrayList<Hotel> searchHotelByAddress(String address)
   {
      return hList.getHotelsInAddress(address);
   }

   @Override
   public double reserve(Reservation res)
   {
      super.setChanged();
      super.notifyObservers("Reservation added");
      return resList.reserve(res);
   }
   
   public Hotel getHotel(int index)
   {
      return hList.getHotel(index);
   }
   public String getHotels()
   {
      return hList.toString();
   }
   
   public void addUser(User user)
   {
      userList.addUser(user);
   }
   
   public void showAnswer(String answer)
   {
      setChanged();
      notifyObservers(answer);
   }

}
