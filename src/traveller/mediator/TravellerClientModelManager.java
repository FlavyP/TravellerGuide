package traveller.mediator;

import java.util.ArrayList;
import java.util.Observable;

import traveller.model.Hotel;
import traveller.model.HotelList;
import traveller.model.MyDate;
import traveller.model.Reservation;
import traveller.model.ReservationList;
import traveller.model.User;
import traveller.model.UserList;

public class TravellerClientModelManager extends Observable implements
		TravellerModel {

	private ReservationList resList;
	private HotelList hList;
	private UserList userList;
	private TravellerModelProxy proxy;
	private int userId;
	private String[] dataCopy;
	private String[][] tableCopy;

	public TravellerClientModelManager() {
		resList = new ReservationList();
		hList = new HotelList();
		userList = new UserList();
		proxy = new TravellerModelProxy(this);
		this.userId = -1;
		this.dataCopy = null;
		this.tableCopy = null;
	}

	public void copy(String[] data) {
		this.dataCopy = data;
	}

	public void copy(String[][] table) {
		this.tableCopy = table;
	}

	public void copy(String[] data, String[][] table) {
		this.dataCopy = data;
		this.tableCopy = table;
	}

	public String[] getDataCopy() {
		return dataCopy;
	}

	public String[][] getTableCopy() {
		return tableCopy;
	}

	public void clearCopies() {
		this.dataCopy = null;
		this.tableCopy = null;
	}

	@Override
	public void addHotel(Hotel hotel) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Hotel> searchHotelByName(String name) {
		return null;
	}

	@Override
	public ArrayList<Hotel> searchHotelByCity(String city) {
		// proxy.searchHotelByCity();
		return null;
	}

	public String[] login(String[] input) {
		String[] answer = proxy.login(input);
		this.userId = Integer.parseInt(answer[0]);
		return answer;
	}

	public void addHotel(String[] input) {
		proxy.addHotel(input);
	}

	public String[] editHotelGetInfo(int input) {
		return proxy.editHotelGetInfo(input);
	}

	public void editHotel(String[] input) {
		proxy.editHotel(input);
	}

	public void deleteHotel(int hotelId) {
		proxy.deleteHotel(hotelId);
	}

	public String[][] searchHotel(String[] input) {
		return proxy.searchHotel(input);
	}

	public void reserve(String[] input) {
		proxy.reserve(input);
	}

	public void addReview(String[] input) {
		proxy.addReview(input);
	}

	public String[] getReviews(int input) {
		return proxy.getReviews(input);
	}

	public String[][] getReservations(int input) {
		return proxy.getReservations(input);
	}

	public void cancelReservation(int input) {
		proxy.cancelReservation(input);
	}

	public String[][] getInterestPoints(String[] input) {
		return proxy.getInterestPoints(input);
	}

	public String getDirections(String[] input) {
		return proxy.getDirections(input);
	}

	@Override
	public ArrayList<Hotel> searchHotelByAddress(String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double reserve(Reservation res) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getHotels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel getHotel(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showAnswer(String answer) {
		setChanged();
		notifyObservers(answer);
	}

	public void addUser(User user) {
		userList.addUser(user);
	}

	public int getUserId() {
		return this.userId;
	}
}
