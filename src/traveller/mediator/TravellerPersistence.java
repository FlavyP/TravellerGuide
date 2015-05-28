package traveller.mediator;

import java.io.IOException;

import traveller.model.Hotel;
import traveller.model.HotelList;
import traveller.model.Reservation;
import traveller.model.ReservationList;
import traveller.model.Review;
import traveller.model.ReviewList;
import traveller.model.User;
import traveller.model.UserList;

public interface TravellerPersistence
{
   
   public HotelList loadHotels() throws IOException;
   public UserList loadUsers() throws IOException;
   public ReservationList loadReservations() throws IOException;
   public ReviewList loadReviews() throws IOException;
   public int addHotel(Hotel hotel) throws IOException;
   public int addUser(User user) throws IOException;
   public int editHotel(Hotel hotel, int pid) throws IOException;
   public int deleteHotel(int hotelId) throws IOException;
   public int addReservation(Reservation rsrv, int userId, int hotelId) throws IOException;
   public int deleteReservation(int rsrvId) throws IOException;
   public int addReview(Review review) throws IOException;
   public int deleteReview(int reviewId) throws IOException;
   

}
