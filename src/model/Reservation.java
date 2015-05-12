package model;

public class Reservation {

	private MyDate checkIn;
	private MyDate checkOut;
	private User guest;
	private Hotel hotel;
	private int numberOfSingleRooms;
	private int numberOfDoubleRooms;
	private int numberOfTripleRooms;
	private int numberOfApartments;
	private int status;
 	
	
	public Reservation(MyDate checkIn, MyDate checkOut, User guest,
			Hotel hotel, int numberOfSingleRooms, int numberOfDoubleRooms,
			int numberOfTripleRooms, int numberOfApartments) {

		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.guest = guest;
		this.hotel = hotel;
		this.numberOfSingleRooms = numberOfSingleRooms;
		this.numberOfDoubleRooms = numberOfDoubleRooms;
		this.numberOfTripleRooms = numberOfTripleRooms;
		this.numberOfApartments = numberOfApartments;
		this.status = 0;
	}


	public MyDate getCheckIn() {
		return checkIn;
	}


	public void setCheckIn(MyDate checkIn) {
		this.checkIn = checkIn;
	}


	public MyDate getCheckOut() {
		return checkOut;
	}


	public void setCheckOut(MyDate checkOut) {
		this.checkOut = checkOut;
	}


	public User getGuest() {
		return guest;
	}


	public void setGuest(User guest) {
		this.guest = guest;
	}


	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}


	public int getNumberOfSingleRooms() {
		return numberOfSingleRooms;
	}


	public void setNumberOfSingleRooms(int numberOfSingleRooms) {
		this.numberOfSingleRooms = numberOfSingleRooms;
	}


	public int getNumberOfDoubleRooms() {
		return numberOfDoubleRooms;
	}


	public void setNumberOfDoubleRooms(int numberOfDoubleRooms) {
		this.numberOfDoubleRooms = numberOfDoubleRooms;
	}


	public int getNumberOfTripleRooms() {
		return numberOfTripleRooms;
	}


	public void setNumberOfTripleRooms(int numberOfTripleRooms) {
		this.numberOfTripleRooms = numberOfTripleRooms;
	}


	public int getNumberOfApartments() {
		return numberOfApartments;
	}


	public void setNumberOfApartments(int numberOfApartments) {
		this.numberOfApartments = numberOfApartments;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}
	
	
	public void reserve()
	{
		
		
	}
	
}
