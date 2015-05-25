package traveller.mediator;

import java.io.IOException;
import java.util.ArrayList;

import traveller.model.Hotel;
import traveller.model.HotelList;
import traveller.model.MyDate;
import traveller.model.Reservation;
import traveller.model.ReservationList;
import traveller.model.Review;
import traveller.model.ReviewList;
import traveller.model.User;
import traveller.model.UserList;
import utility.persistence.MyDatabase;

public class TravellerDatabaseAdapter implements TravellerPersistence {

	private MyDatabase db;
	private static final String DB_NAME = "TravellerGuide";

	public TravellerDatabaseAdapter() throws ClassNotFoundException {
		this.db = new MyDatabase(DB_NAME);
	}

	@Override
	public HotelList loadHotels() throws IOException {
		HotelList hotels = new HotelList();

		String sql = "SELECT * FROM hotel";
		try {
			ArrayList<Object[]> results = db.query(sql);
			for (int i = 0; i < results.size(); i++) {
				Object[] row = results.get(i);
				int hotelId = Integer.parseInt(row[0].toString());
				String name = row[1].toString();
				String city = row[2].toString();
				String address = row[3].toString();
				int nSr = Integer.parseInt(row[4].toString());
				double pSr = Double.parseDouble(row[5].toString());
				int nDr = Integer.parseInt(row[6].toString());
				double pDr = Double.parseDouble(row[7].toString());
				int nTr = Integer.parseInt(row[8].toString());
				double pTr = Double.parseDouble(row[9].toString());
				int nA = Integer.parseInt(row[10].toString());
				double pA = Double.parseDouble(row[11].toString());

				Hotel hotel = new Hotel(hotelId, name, city, address, nSr, pSr,
						nDr, pDr, nTr, pTr, nA, pA);
				hotels.addHotel(hotel);
			}

		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}

		return hotels;
	}

	@Override
	public UserList loadUsers() throws IOException {
		UserList users = new UserList();
		String sql = "SELECT * FROM user";
		try {
			ArrayList<Object[]> results = db.query(sql);
			for (int i = 0; i < results.size(); i++) {
				Object[] row = results.get(i);
				int userId = Integer.parseInt(row[0].toString());
				String name = row[1].toString();
				String email = row[2].toString();
				String phone = row[3].toString();
				String address = row[4].toString();
				int guest = Integer.parseInt(row[5].toString());
				String password = row[6].toString();
				boolean isGuest;
				if (guest == 1) {
					isGuest = true;
				} else {
					isGuest = false;
				}

				User user = new User(userId, name, email, phone, address,
						isGuest, password);
				users.addUser(user);
				// System.out.println(user.getName());

			}
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}
		return users;

	}
	
	@Override
   public ReservationList loadReservations() throws IOException
   {
	   ReservationList reservations = new ReservationList();
	   
	   String sql = "SELECT r.reservationID, r.userID, r.hOTELID,"
	         + " EXTRACT(YEAR FROM r.checkInDate),"
	         + " EXTRACT(MONTH FROM r.checkInDate),"
	         + " EXTRACT(DAY FROM r.checkInDate),"
	         + " EXTRACT(YEAR FROM r.checkOutDate),"
	         + " EXTRACT(MONTH FROM r.checkOutDate),"
	         + " EXTRACT(DAY FROM r.checkOutDate),"
	         + " r.singleRoomNumber, r.doubleRoomNumber, r.tripleRoomNumber, r.apartmentsNumber, r.totalPrice,"
	         + " u.*, h.*"
	         + " FROM reservations as r"
	         + " LEFT JOIN user as u ON r.userId=u.userID"
	         + " LEFT JOIN hotel as h ON r.hOTELID=h.hotelID";
	   
	   
                    
	   
	   try {
	      ArrayList<Object[]> results = db.query(sql);
	      for (int i = 0; i < results.size(); i++) {
	         Object[] row = results.get(i);
	         int rsrvId = Integer.parseInt(row[0].toString());
	         int userId = Integer.parseInt(row[1].toString());
	         int hotelId = Integer.parseInt(row[2].toString());
	         int checkInYear = Integer.parseInt(row[3].toString());
	         int checkInMonth = Integer.parseInt(row[4].toString());
	         int checkInDay = Integer.parseInt(row[5].toString());
	         int checkOutYear = Integer.parseInt(row[6].toString());
	         int checkOutMonth = Integer.parseInt(row[7].toString());
	         int checkOutDay = Integer.parseInt(row[8].toString());
	         int sRn = Integer.parseInt(row[9].toString());
	         int dRn = Integer.parseInt(row[10].toString());
	         int tRn = Integer.parseInt(row[11].toString());
	         int aN = Integer.parseInt(row[12].toString());
	         double totalPrice = Double.parseDouble(row[13].toString());
	         String uName = row[15].toString();
	         String uEmail = row[16].toString();
	         String uPhone = row[17].toString();
	         String uAddress = row[18].toString();
	         int uGuest = Integer.parseInt(row[19].toString());
	         String uPassword = row[20].toString();
	         boolean isGuest;
            if (uGuest == 1) {
               isGuest = true;
            } else {
               isGuest = false;
            }
            String hName = row[22].toString();
            String hCity = row[23].toString();
            String hAddress = row[24].toString();
            int hnSr = Integer.parseInt(row[25].toString());
            double hpSr = Double.parseDouble(row[26].toString());
            int hnDr = Integer.parseInt(row[27].toString());
            double hpDr = Double.parseDouble(row[28].toString());
            int hnTr = Integer.parseInt(row[29].toString());
            double hpTr = Double.parseDouble(row[30].toString());
            int hnA = Integer.parseInt(row[31].toString());
            double hpA = Double.parseDouble(row[32].toString());
            
            
            
            
            User user = new User(userId, uName, uEmail, uPhone, uAddress,
                isGuest, uPassword);
            Hotel hotel = new Hotel(hotelId, hName, hCity, hAddress, hnSr, hpSr,
                  hnDr, hpDr, hnTr, hpTr, hnA, hpA);
            
            MyDate checkIn = new MyDate(checkInYear, checkInMonth, checkInDay);
            MyDate checkOut = new MyDate(checkOutYear, checkOutMonth, checkOutDay);
            
            Reservation reservation = new Reservation(rsrvId, user, hotel, checkIn, checkOut, sRn, dRn, tRn, aN);
            reservation.setTotalPrice(totalPrice);
	         reservations.reserve(reservation);
            
	         
	      }
	   
	   }
	   catch (Exception e) {
	      throw new IOException(e.getMessage());
	   }
	   
	   return reservations;
	   
	   
   }
	
	@Override
   public ReviewList loadReviews() throws IOException
   {
      ReviewList reviews = new ReviewList();
      
      String sql = "SELECT r.*, u.*, h.*"
            + " FROM reviews as r"
            + " LEFT JOIN user as u ON r.userID=u.userID"
            + " LEFT JOIN hotel as h ON r.hotelID=h.hotelID";
      
      try {
         ArrayList<Object[]> results = db.query(sql);
         for (int i = 0; i < results.size(); i++) {
            Object[] row = results.get(i);
            int reviewId = Integer.parseInt(row[0].toString());
            int userId = Integer.parseInt(row[1].toString());
            int hotelId = Integer.parseInt(row[2].toString());
            int grade = Integer.parseInt(row[3].toString());
            String comment = row[4].toString();
            String uName = row[6].toString();
            String uEmail = row[7].toString();
            String uPhone = row[8].toString();
            String uAddress = row[9].toString();
            int uGuest = Integer.parseInt(row[10].toString());
            boolean isGuest;
            if (uGuest == 1) {
               isGuest = true;
            } else {
               isGuest = false;
            }
            String uPassword = row[11].toString();
            String hName = row[13].toString();
            String hCity = row[14].toString();
            String hAddress = row[15].toString();
            int nSr = Integer.parseInt(row[16].toString());
            double pSr = Double.parseDouble(row[17].toString());
            int nDr = Integer.parseInt(row[18].toString());
            double pDr = Double.parseDouble(row[19].toString());
            int nTr = Integer.parseInt(row[20].toString());
            double pTr = Double.parseDouble(row[21].toString());
            int nA = Integer.parseInt(row[22].toString());
            double pA = Double.parseDouble(row[23].toString());
            
            User user = new User(userId, uName, uEmail, uPhone, uAddress,
                  isGuest, uPassword);
            
            Hotel hotel = new Hotel(hotelId, hName, hCity, hAddress, nSr, pSr,
                  nDr, pDr, nTr, pTr, nA, pA);
            
            Review review = new Review(reviewId, user, hotel, grade, comment);
            
            reviews.addReview(review);
         }
         
      }
      
      catch (Exception e) {
         throw new IOException(e.getMessage());
      }
      
      
      return reviews;
   }

	@Override
	public int addHotel(Hotel hotel) throws IOException {
		int sum = 0;

		int hotelid = hotel.getHotelId();
		String name = hotel.getName();
		String city = hotel.getCity();
		String address = hotel.getAddress();
		int nSr = hotel.getNumberOfRooms(0);
		double pSr = hotel.getPriceOfRooms(0);
		int nDr = hotel.getNumberOfRooms(1);
		double pDr = hotel.getPriceOfRooms(1);
		int nTr = hotel.getNumberOfRooms(2);
		double pTr = hotel.getPriceOfRooms(2);
		int nA = hotel.getNumberOfRooms(3);
		double pA = hotel.getPriceOfRooms(3);

		String sql = "INSERT INTO Hotel (hotelID, name, city, address, numberOfSingleRooms,"
				+ "priceOfASingleRooms, numberOfDoubleRooms, priceOfADoubleRooms, "
				+ "numberOfTripleRooms, priceOfATripleRooms, numberOfApartments, priceOfAnApartment"
				+ ") VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			sum += db.update(sql, hotelid, name, city, address, nSr, pSr, nDr,
					pDr, nTr, pTr, nA, pA);
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}

		return sum;

	}

	@Override
	public int addUser(User user) throws IOException {
		int sum = 0;
		String name = user.getName();
		String email = user.getEmail();
		String phone = user.getPhoneNumber();
		String address = user.getAddress();
		boolean isGuest = user.isGuest();
		String password = user.getPassword();
		int guest;
		if (isGuest == true) {
			guest = 1;
		} else {
			guest = 0;
		}

		String sql = "INSERT INTO USER (name, email, phone, address,"
				+ "isGuest, pasword" + ") VALUES(?, ?, ?, ?, ?, ?)";

		try {
			sum += db.update(sql, name, email, phone, address, guest, password);
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}

		return sum;
	}

	@Override
	public int addReservation(Reservation reservation, int userId, int hotelId) throws IOException {
		int sum = 0;
		int resId = reservation.getResId();
		MyDate checkIn = reservation.getCheckIn();
		MyDate checkOut = reservation.getCheckOut();		
		
		int nSr = reservation.getNumberOfSingleRooms();
		int nDr = reservation.getNumberOfDoubleRooms();
		int nTr = reservation.getNumberOfTripleRooms();
		int nAp = reservation.getNumberOfApartments();
		double totalPrice = reservation.getTotalPrice();

		String sql = "INSERT INTO RESERVATIONS (reservationID, userID, hOTELID, checkInDate, checkOutDate,"
				+ " singleRoomNumber, doubleRoomNumber, tripleRoomNumber, apartmentsNumber, totalPrice)"
				+ " VALUES (?, ?, ?, ? ,?, ?, ?, ?, ?,?)";
		
		try {
         sum += db.update(sql, resId, userId, hotelId, checkIn.toString(), checkOut.toString(), nSr, nDr, nTr, nAp, totalPrice);
      } catch (Exception e) {
         throw new IOException(e.getMessage());
      }

		
		return sum;
	}

	@Override
	public int editHotel(Hotel hotel, int pid) throws IOException {
		int sum = 0;
		int hotelid = hotel.getHotelId();
		String name = hotel.getName();
		String city = hotel.getCity();
		String address = hotel.getAddress();
		int nSr = hotel.getNumberOfRooms(0);
		double pSr = hotel.getPriceOfRooms(0);
		int nDr = hotel.getNumberOfRooms(1);
		double pDr = hotel.getPriceOfRooms(1);
		int nTr = hotel.getNumberOfRooms(2);
		double pTr = hotel.getPriceOfRooms(2);
		int nA = hotel.getNumberOfRooms(3);
		double pA = hotel.getPriceOfRooms(3);

		String sql = "UPDATE Hotel SET hotelID=?, name=?, city=?, address=?, numberOfSingleRooms=?, priceOfASingleRooms=?, numberOfDoubleRooms=?, priceOfADoubleRooms=?, numberOfTripleRooms=?, "
				+ "priceOfATripleRooms=?, numberOfApartments=?, priceOfAnApartment=? WHERE hotelID="
				+ pid;

		try {
			sum += db.update(sql, hotelid, name, city, address, nSr, pSr, nDr,
					pDr, nTr, pTr, nA, pA);
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}
		return sum;
	}

	@Override
	public int deleteHotel(int hotelId) throws IOException {
		int sum = 0;

		String sql = "DELETE FROM Hotel WHERE hotelID=?";

		try {
			sum += db.update(sql, hotelId);
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}

		return sum;

	}

   @Override
   public int deleteReservation(int rsrvId) throws IOException
   {
      int sum = 0;
      
      String sql = "DELETE FROM reservations WHERE reservationID=?";
      
      try {
         sum += db.update(sql, rsrvId);
      } catch (Exception e) {
         throw new IOException(e.getMessage());
      }

      return sum;
   }

   @Override
   public int addReview(Review review) throws IOException
   {
      int sum = 0;
      String sql = "INSERT INTO REVIEWS(reviewsID, userID, hotelID, grade, comments) VALUES(?,?,?,?,?)";
      
      int revId = review.getRevId();
      int userId = review.getUser().getUserId();
      int hotelId = review.getHotel().getHotelId();
      int grade = review.getGrade();
      String comments = review.getComment();
      
      try {
         sum += db.update(sql, revId, userId, hotelId, grade, comments);
      } catch (Exception e) {
         throw new IOException(e.getMessage());
      }
      
      return sum;
   }

   @Override
   public int deleteReview(int reviewId) throws IOException
   {
      int sum = 0;
      
      String sql = "DELETE FROM reviews WHERE reviewsID=?";
      
      try {
         sum += db.update(sql, reviewId);
      } catch (Exception e) {
         throw new IOException(e.getMessage());
      }

      return sum;
   }   
}
