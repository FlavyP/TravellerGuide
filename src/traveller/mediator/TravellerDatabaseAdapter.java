package traveller.mediator;

import java.io.IOException;
import java.util.ArrayList;

import traveller.model.Hotel;
import traveller.model.HotelList;
import traveller.model.MyDate;
import traveller.model.Reservation;
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

				Hotel hotel = new Hotel(hotelId, name, city, address, nSr, pSr, nDr,
						pDr, nTr, pTr, nA, pA);
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
//				System.out.println(user.getName());

			}
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}
		return users;

	}

	@Override
	public int addHotel(Hotel hotel) throws IOException {
		int sum = 0;

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

		String sql = "INSERT INTO Hotel (name, city, address, numberOfSingleRooms,"
				+ "priceOfASingleRooms, numberOfDoubleRooms, priceOfADoubleRooms, "
				+ "numberOfTripleRooms, priceOfATripleRooms, numberOfApartments, priceOfAnApartment"
				+ ") VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			sum += db.update(sql, name, city, address, nSr, pSr, nDr, pDr, nTr,
					pTr, nA, pA);
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
	public int addReservation(Reservation reservation) throws IOException {
		int sum = 0;
		MyDate checkIn = reservation.getCheckIn();
		MyDate checkOut = reservation.getCheckOut();
		User user = reservation.getUser();
		Hotel hotel = reservation.getHotel();
		int nSr = reservation.getNumberOfSingleRooms();
		int nDr = reservation.getNumberOfDoubleRooms();
		int nTr = reservation.getNumberOfTripleRooms();
		int nAp = reservation.getNumberOfApartments();
		int status = reservation.getStatus();
		double totalPrice = reservation.getTotalPrice();

		String sql = "INSERT INTO RESERVATIONS (checkInDate, checkOutDate, user, hotel, singleRoomNumber, doubleRoomNumber, tripleRoomNumber, apartmentsNumber, status, totalPrice"
				+ ") Values (?, ?, ? ,?, ?, ?, ?, ?, ?, ?)";
		
		try {
			sum += db.update(sql, checkIn, checkOut, user, hotel, nSr, nDr, nTr, nAp, status, totalPrice);
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}
		return sum;
	}
}
