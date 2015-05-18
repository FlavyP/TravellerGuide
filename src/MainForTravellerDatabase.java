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
   }

}
