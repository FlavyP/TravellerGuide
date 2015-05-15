package traveller.mediator;

import java.util.ArrayList;
import java.util.Observable;

import traveller.model.Hotel;
import traveller.model.HotelList;
import traveller.model.MyDate;
import traveller.model.Reservation;
import traveller.model.ReservationList;
import traveller.model.User;
import traveller.model.UserList;

public class TravellerClientModelManager extends Observable implements TravellerModel
{

   private ReservationList resList;
   private HotelList hList;
   private UserList userList;
   private TravellerModelProxy proxy;
   
   public TravellerClientModelManager()
   {
      resList = new ReservationList();
      hList = new HotelList();
      userList = new UserList();
      proxy = new TravellerModelProxy(this);

   }
   @Override
   public void addHotel(Hotel hotel)
   {
      // TODO Auto-generated method stub
      
   }

   public ArrayList<Hotel> searchHotelByName(String name)
   {
      return null;
   }
   
   @Override
   public ArrayList<Hotel> searchHotelByCity(String city)
   {
      proxy.searchHotelByCity();
      return null;
   }

   @Override
   public ArrayList<Hotel> searchHotelByAddress(String address)
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public double reserve(Reservation res)
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
   
   public void writeToServer(String message){
	   proxy.writeToServer(message);
   }
   
   public void addUser(User user)
   {
      userList.addUser(user);
   }

}
