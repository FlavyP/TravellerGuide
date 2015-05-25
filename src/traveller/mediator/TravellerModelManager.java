package traveller.mediator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import traveller.model.*;

public class TravellerModelManager extends Observable implements TravellerModel {

	private ReservationList resList;
	private HotelList hList;
	private UserList userList;
	private ReviewList reviewList;
	private ServerConnectionThread server;
	private TravellerPersistence database;

	public TravellerModelManager() throws ClassNotFoundException {
		database = new TravellerDatabaseAdapter();
		resList = new ReservationList();
		hList = new HotelList();
		userList = new UserList();
		reviewList = new ReviewList();
		server = new ServerConnectionThread(this);
		server.start();
		try {
			this.userList = database.loadUsers();
			this.hList = database.loadHotels();
			this.resList = database.loadReservations();
			this.reviewList = database.loadReviews();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public String[] login(String[] input) {
		String[] b = new String[3];
		User user = userList.getUser(input[0], input[1]);
		if (user != null) {
			b[0] = "" + user.getUserId();
			b[1] = "1";
			if (user.isGuest())
				b[2] = "1";
			else
				b[2] = "0";
		} else {
			b[1] = "0";
			b[2] = "0";
		}
		return b;
	}

	@Override
	public void addHotel(String[] hotel) {
		Hotel hotel2 = new Hotel(hList.size() + 1, hotel[0], hotel[1],
				hotel[2], Integer.parseInt(hotel[3]),
				Double.parseDouble(hotel[4]), Integer.parseInt(hotel[5]),
				Double.parseDouble(hotel[6]), Integer.parseInt(hotel[7]),
				Double.parseDouble(hotel[8]), Integer.parseInt(hotel[9]),
				Double.parseDouble(hotel[10]));
		hList.addHotel(hotel2);
		try {
			database.addHotel(hotel2);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public String[] getHotelInfo(int input) {
		Hotel hotel = hList.getHotel(input);
		String[] a = new String[11];
		a[0] = hotel.getName();
		a[1] = hotel.getCity();
		a[2] = hotel.getAddress();
		a[3] = "" + hotel.getNumberOfRooms(0);
		a[4] = "" + hotel.getPriceOfRooms(0);
		a[5] = "" + hotel.getNumberOfRooms(1);
		a[6] = "" + hotel.getPriceOfRooms(1);
		a[7] = "" + hotel.getNumberOfRooms(2);
		a[8] = "" + hotel.getPriceOfRooms(2);
		a[9] = "" + hotel.getNumberOfRooms(3);
		a[10] = "" + hotel.getPriceOfRooms(3);
		return a;
	}

	public void editHotel(String[] input) {
		Hotel hotel2 = new Hotel(Integer.parseInt(input[0]), input[1],
				input[2], input[3], Integer.parseInt(input[4]),
				Double.parseDouble(input[5]), Integer.parseInt(input[6]),
				Double.parseDouble(input[7]), Integer.parseInt(input[8]),
				Double.parseDouble(input[9]), Integer.parseInt(input[10]),
				Double.parseDouble(input[11]));
		hList.editHotel(Integer.parseInt(input[0]), hotel2);
		try {
			database.editHotel(hotel2, Integer.parseInt(input[0]));
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void deleteHotel(int hotelId) {
		hList.deleteHotel(hotelId);
		try {
			database.deleteHotel(hotelId);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public String[][] searchHotel(String[] input) {
		String[][] list = null;
		if (input[0].equals("City")) {
			ArrayList<Hotel> a = hList.getHotelsInCity(input[1]);
			list = new String[a.size()][12];// [rows][collumns]
			for (int i = 0; i < a.size(); i++) {
				list[i][0] = "" + a.get(i).getHotelId();
				list[i][1] = a.get(i).getName();
				list[i][2] = a.get(i).getCity();
				list[i][3] = a.get(i).getAddress();
				list[i][4] = "" + a.get(i).getNumberOfRooms(0);
				list[i][5] = "" + a.get(i).getPriceOfRooms(0);
				list[i][6] = "" + a.get(i).getNumberOfRooms(1);
				list[i][7] = "" + a.get(i).getPriceOfRooms(1);
				list[i][8] = "" + a.get(i).getNumberOfRooms(2);
				list[i][9] = "" + a.get(i).getPriceOfRooms(2);
				list[i][10] = "" + a.get(i).getNumberOfRooms(3);
				list[i][11] = "" + a.get(i).getPriceOfRooms(3);
			}
		} else if (input[0].equals("Hotel")) {
			ArrayList<Hotel> a = hList.getHotelsByName(input[1]);
			list = new String[a.size()][12];
			for (int i = 0; i < a.size(); i++) {
				list[i][0] = "" + a.get(i).getHotelId();
				list[i][1] = a.get(i).getName();
				list[i][2] = a.get(i).getCity();
				list[i][3] = a.get(i).getAddress();
				list[i][4] = "" + a.get(i).getNumberOfRooms(0);
				list[i][5] = "" + a.get(i).getPriceOfRooms(0);
				list[i][6] = "" + a.get(i).getNumberOfRooms(1);
				list[i][7] = "" + a.get(i).getPriceOfRooms(1);
				list[i][8] = "" + a.get(i).getNumberOfRooms(2);
				list[i][9] = "" + a.get(i).getPriceOfRooms(2);
				list[i][10] = "" + a.get(i).getNumberOfRooms(3);
				list[i][11] = "" + a.get(i).getPriceOfRooms(3);
			}
		} else {
			ArrayList<Hotel> a = hList.getHotelsInAddress(input[1]);
			list = new String[a.size()][12];
			for (int i = 0; i < a.size(); i++) {
				list[i][0] = "" + a.get(i).getHotelId();
				list[i][1] = a.get(i).getName();
				list[i][2] = a.get(i).getCity();
				list[i][3] = a.get(i).getAddress();
				list[i][4] = "" + a.get(i).getNumberOfRooms(0);
				list[i][5] = "" + a.get(i).getPriceOfRooms(0);
				list[i][6] = "" + a.get(i).getNumberOfRooms(1);
				list[i][7] = "" + a.get(i).getPriceOfRooms(1);
				list[i][8] = "" + a.get(i).getNumberOfRooms(2);
				list[i][9] = "" + a.get(i).getPriceOfRooms(2);
				list[i][10] = "" + a.get(i).getNumberOfRooms(3);
				list[i][11] = "" + a.get(i).getPriceOfRooms(3);
			}

		}
		return list;
	}

	public void reserve(String[] input) {
		Reservation reservation = new Reservation(resList.size() + 1,
				userList.getUser(Integer.parseInt(input[0]) - 1),
				hList.getHotel(Integer.parseInt(input[1]) - 1), new MyDate(
						Integer.parseInt(input[4]), Integer.parseInt(input[3]),
						Integer.parseInt(input[2])), new MyDate(
						Integer.parseInt(input[7]), Integer.parseInt(input[6]),
						Integer.parseInt(input[5])),
				Integer.parseInt(input[8]), Integer.parseInt(input[9]),
				Integer.parseInt(input[10]), Integer.parseInt(input[11]));
		resList.reserve(reservation);
		try {
			database.addReservation(reservation, Integer.parseInt(input[0]),
					Integer.parseInt(input[1]));
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void addReview(String[] input) {
		Review review = new Review(reviewList.size() + 1,
				userList.getUser(Integer.parseInt(input[0]) - 1),
				hList.getHotel(Integer.parseInt(input[1]) - 1),
				Integer.parseInt(input[2]), input[3]);
		reviewList.addReview(review);
	}

	public String[] getReviews(int hotelId) {
		ArrayList<Review> a = reviewList.getReviewsByHotel(hotelId);
		String[] answer = new String[a.size()];
		for (int i = 0; i < a.size(); i++) {
			answer[i] = a.get(i).toString();
		}
		return answer;
	}

	public String[][] getReservations(int input) {
		ArrayList<Reservation> a = resList.getReservationsByUser(input);
		String[][] list = new String[a.size()][9];
		for (int i = 0; i < a.size(); i++) {
			list[i][0] = "" + a.get(i).getResId();
			list[i][1] = a.get(i).getHotel().getName();
			list[i][2] = a.get(i).getCheckIn().toString();
			list[i][3] = a.get(i).getCheckOut().toString();
			list[i][4] = "" + a.get(i).getNumberOfSingleRooms();
			list[i][5] = "" + a.get(i).getNumberOfDoubleRooms();
			list[i][6] = "" + a.get(i).getNumberOfTripleRooms();
			list[i][7] = "" + a.get(i).getNumberOfApartments();
			list[i][8] = "" + a.get(i).getTotalPrice();
		}
		return list;
	}

	public void cancelReservation(int resId) {
		resList.cancelReservation(resId);
		try {
			database.deleteReservation(resId);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public String[][] getInterestPoints(String[] input) {
		int hotelId = Integer.parseInt(input[0]);
		Hotel hotel = hList.getHotel(hotelId - 1);
		double[] latLng = null;
		GooglePlaces places = null;
		try {
			latLng = new GoogleDirections(hotel.getAddress(), hotel.getCity())
					.getPlaceLatAndLng();
			places = new GooglePlaces(latLng[0], latLng[1], 500, input[1]);
		} catch (IOException e) {

		}
		String[][] answer = places.getInformation();
		return answer;
	}

	public String getDirections(String[] input) {
		int hotelId = Integer.parseInt(input[0]);
		Hotel hotel = hList.getHotel(hotelId - 1);
		double[] latLng = null;
		double pLat = 0, pLng = 0;
		GooglePlaces places = null;
		String answer = null;
		try {
			latLng = new GoogleDirections(hotel.getAddress(), hotel.getCity())
					.getPlaceLatAndLng();
			places = new GooglePlaces(latLng[0], latLng[1], 500, input[2]);
			pLat = places.getPlaceLat(Integer.parseInt(input[1]) - 1);
			pLng = places.getPlaceLng(Integer.parseInt(input[1]) - 1);
			answer = new GoogleDirections(latLng[0], latLng[1], pLat, pLng)
					.getInformation();
		} catch (IOException e) {

		}
		return answer;
	}

	public String[][] getUserReviews(int input) {
		ArrayList<Review> a = reviewList.getReviews(input);
		String[][] list = new String[a.size()][4];
		for (int i = 0; i < a.size(); i++) {
			list[i][0] = "" + a.get(i).getRevId();
			list[i][1] = a.get(i).getHotel().getName();
			list[i][2] = "" + a.get(i).getGrade();
			list[i][3] = a.get(i).getComment();
		}
		return list;
	}
	
	public void cancelReview(int input) {
		reviewList.deleteReview(input - 1);
	}
	
	public void addUser(String[] input) {
		User user = new User(userList.size() + 1, input[0], input[1], input[2],
				input[3], true, input[4]);
		userList.addUser(user);
		try {
			database.addUser(user);
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
