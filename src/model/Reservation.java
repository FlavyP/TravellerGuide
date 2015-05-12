package model;

public class Reservation {
   
   
   private int reservationId;
	private MyDate checkIn;
	private MyDate checkOut;
	private int guestId;
	private int hotelId;
	private Room type;
	private int numberOfSingleRooms;
	private int numberOfDoubleRooms;
	private int numberOfTripleRooms;
	private int numberOfApartments; 
	private int status;
	
	
	
 	
	
	public Reservation(MyDate checkIn, MyDate checkOut, int guestId,
			int hotelId, Room type ) {
	   
	   
	   this.reservationId = 0;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.guestId = guestId;
		this.hotelId = hotelId;
		this.type = type;
		
	}
	
	
	public void Reserve(MyDate checkIn, MyDate checkOut, int guestId,
         int hotelId, Room type)
	{
	   this.checkIn = checkIn;
      this.checkOut = checkOut;
      this.guestId = guestId;
      this.hotelId = hotelId;
      this.type = type;
      reservationId++;
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


	public int getGuest() {
		return guestId;
	}


	public void setGuest(int guest) {
		this.guestId = guest;
	}


	public int getHotel() {
		return hotelId;
	}


	public void setHotel(int hotel) {
		this.hotelId = hotel;
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
	
}
