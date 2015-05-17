import java.io.IOException;
import traveller.mediator.*;
import traveller.model.*;

public class DatabaseTest
{

   private TravellerPersistence database;
   //private HotelList hotellist;
   private UserList userlist;

   public DatabaseTest() throws ClassNotFoundException, IOException
   {
      database = new TravellerDatabaseAdapter();
      //hotellist = database.loadHotels();
      userlist = database.loadUsers();
   }

   public static void main(String[] args) throws IOException,
         ClassNotFoundException

   {
      DatabaseTest adaptertest = new DatabaseTest();
      adaptertest.test();


   }
   
   public void test() throws IOException
   {
      System.out.println(userlist);
   }

}
