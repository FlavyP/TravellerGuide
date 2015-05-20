package traveller.mediator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import traveller.model.*;

public class TravellerModelManager extends Observable implements TravellerModel {

	private ReservationList resList;
	private HotelList hList;
	private UserList userList;
	private ServerConnectionThread server;
	private TravellerPersistence database;

	public TravellerModelManager() throws ClassNotFoundException {
		database = new TravellerDatabaseAdapter();
		resList = new ReservationList();
		hList = new HotelList();
		userList = null;
		server = new ServerConnectionThread(this);
		server.start();
		try {
			this.userList = database.loadUsers();
			this.hList = database.loadHotels();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public void addHotel(Hotel hotel) {
		hList.addHotel(hotel);
	}

	@Override
	public void addHotel(String[] hotel) {
		Hotel hotel2 = new Hotel(hList.size()+1, hotel[0], hotel[1], hotel[2],
				Integer.parseInt(hotel[3]), Double.parseDouble(hotel[4]),
				Integer.parseInt(hotel[5]), Double.parseDouble(hotel[6]),
				Integer.parseInt(hotel[7]), Double.parseDouble(hotel[8]),
				Integer.parseInt(hotel[9]), Double.parseDouble(hotel[10]));
		hList.addHotel(hotel2);
		try {
			database.addHotel(hotel2);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public ArrayList<Hotel> searchHotelByCity(String city) {
		return hList.getHotelsInCity(city);
	}

	public ArrayList<Hotel> searchHotelByName(String name) {
		return hList.getHotelsByName(name);
	}

	@Override
	public ArrayList<Hotel> searchHotelByAddress(String address) {
		return hList.getHotelsInAddress(address);
	}

	@Override
	public double reserve(Reservation res) {
		super.setChanged();
		super.notifyObservers("Reservation added");
		return resList.reserve(res);
	}

	public Hotel getHotel(int index) {
		return hList.getHotel(index);
	}
	public String[] getHotelString(int index) {
		Hotel hotel = hList.getHotel(index);
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

	public String getHotels() {
		return hList.toString();
	}

	public void addUser(User user) {
		userList.addUser(user);
	}

	public boolean[] getUser(String email, String password) {
		boolean[] b = new boolean[2];
		User user = userList.getUser(email, password);
		if (user != null) {
			b[0] = true;
			if (user.isGuest())
				b[1] = true;
			else
				b[1] = false;
		} else {
			b[0] = false;
			b[1] = false;
		}
		return b;
	}

	public void showAnswer(String answer) {
		setChanged();
		notifyObservers(answer);
	}

}
