package traveller.mediator;

import java.io.IOException;

import traveller.model.Hotel;
import traveller.model.HotelList;
import traveller.model.User;
import traveller.model.UserList;

public interface TravellerPersistence
{
   
   public HotelList loadHotels() throws IOException;
   public UserList loadUsers() throws IOException;
   public int addHotel(Hotel hotel) throws IOException;
   public int addUser(User user) throws IOException;
   

}
