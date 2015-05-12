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
			int numberOfTripleRooms, int numberOfApartments, int status) {

		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.guest = guest;
		this.hotel = hotel;
		this.numberOfSingleRooms = numberOfSingleRooms;
		this.numberOfDoubleRooms = numberOfDoubleRooms;
		this.numberOfTripleRooms = numberOfTripleRooms;
		this.numberOfApartments = numberOfApartments;
		this.status = status;
	}
	
	
}
