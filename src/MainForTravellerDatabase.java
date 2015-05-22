import java.io.IOException;
import traveller.mediator.*;
import traveller.model.*;

public class MainForTravellerDatabase
{

   private TravellerPersistence database;
   private HotelList hotellist;
   private UserList userlist;

   public MainForTravellerDatabase() throws ClassNotFoundException, IOException
   {
      database = new TravellerDatabaseAdapter();
      hotellist = database.loadHotels();
      userlist = database.loadUsers();
   }

   public static void main(String[] args) throws IOException,
         ClassNotFoundException

   {
      MainForTravellerDatabase adaptertest = new MainForTravellerDatabase();
      adaptertest.test();

   }

   public void test() throws IOException
   {
      System.out.println(hotellist);
      System.out.println(userlist);
      
      User user = new User(1, "John", "John@gmail.com", "5615151145", "Fakta", false, "sdfsdsdfui");
      Hotel hotel = new Hotel(1, "aaaa", "aaaa", "aaaa", 0, 0, 0, 0, 0, 0, 0, 0);
      MyDate checkIn = new MyDate(2014, 8, 20);
      MyDate checkOut = new MyDate(2015, 8, 20);
      
      int userId = user.getUserId();
      int hotelId = hotel.getHotelId();
      
      
      Reservation rsrv = new Reservation(1, user, hotel, checkIn, checkOut, 0, 0, 0, 0);
      
      database.addReservation(rsrv, userId, hotelId);
      
   }

}
