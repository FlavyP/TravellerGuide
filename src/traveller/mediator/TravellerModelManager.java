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
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public void addHotel(Hotel hotel) {
		hList.addHotel(hotel);
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
