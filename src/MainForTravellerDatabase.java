import java.io.IOException;
import traveller.mediator.*;
import traveller.model.*;

public class MainForTravellerDatabase
{

   private TravellerPersistence database;
   private HotelList hotellist;
   private UserList userlist;
   private ReservationList reservationlist;
   private ReviewList reviewlist;
   

   public MainForTravellerDatabase() throws ClassNotFoundException, IOException
   {
      database = new TravellerDatabaseAdapter();
      hotellist = database.loadHotels();
      userlist = database.loadUsers();
      reservationlist = database.loadReservations();
      reviewlist = database.loadReviews();
     
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
      System.out.println(reservationlist);
      System.out.println(reviewlist);
      
//      Hotel hotel = new Hotel(1, "KamjatkaSucks", "Horsens", "Kamjatka", 0, 0, 0, 0, 0, 0, 0, 0);
//      User user = new User(1, "John", "John@gmail.com", "5615656", "Balbieriskis", true, "dfgdfgdfdf");
//      Review review = new Review(1, user, hotel, 4, "Kamjatka sucks rlly bad");
//      
//      database.addReview(review);
//      database.deleteReview(1);
      
   }

}
