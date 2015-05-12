package model;

import java.util.Scanner;

public class User {
	
	private String name;
	private String email;
	private String phoneNumber;
	private String address;
	private boolean isGuest;
	private int userId;
	private Hotel hotelId;
	private Reservation book;
	
	
	//
	
	
	public User(String name,String email,String phoneNumber,String address,boolean isGuest, int userId)
	{
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.isGuest = isGuest;
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isGuest() {
		return isGuest;
	}

	public void setGuest(boolean isGuest) {
		this.isGuest = isGuest;
	}
	
	public void reserve(int userId, int hotelId, MyDate checkIn, MyDate checkOut)
	{
	   
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter how many single rooms: ");
		int singleRooms = scan.nextInt();
		System.out.print("Enter how many double rooms: ");
		int doubleRooms = scan.nextInt();
		System.out.print("Enter how many triple rooms: ");
		int tripleRooms = scan.nextInt();
		System.out.print("Enter how many apartments: ");
		int apartments = scan.nextInt();
//	   for(int i = 0; i < rooms; i++)
//	   {
//	      System.out.println("Enter the type of room you want to book: ");
//	      String type = scan.nextLine();
//	      
//	      Class newclass = Class.forName(type);
//	      
//	      
//	      book = new Reservation(checkIn, checkOut, 1, 2, new newclass(12.2));
//	      System.out.println(book.getGuest() +" " + book.getHotel() +" " + book.getCheckIn());
//	   }
	   for(int i=0;i<singleRooms;i++){
		      book = new Reservation(checkIn, checkOut, 1, 2, new SingleRoom(12.2));
		      System.out.println(book.getGuest() +" " + book.getHotel() +" " + book.getCheckIn());
	   }
	   for(int i=0;i<doubleRooms;i++){
		      book = new Reservation(checkIn, checkOut, 1, 2, new DoubleRoom(12.2));
		      System.out.println(book.getGuest() +" " + book.getHotel() +" " + book.getCheckIn());
	   }
	   for(int i=0;i<tripleRooms;i++){
		      book = new Reservation(checkIn, checkOut, 1, 2, new TripleRoom(12.2));
		      System.out.println(book.getGuest() +" " + book.getHotel() +" " + book.getCheckIn());
	   }
	   for(int i=0;i<apartments;i++){
		      book = new Reservation(checkIn, checkOut, 1, 2, new Apartment(12.2));
		      System.out.println(book.getGuest() +" " + book.getHotel() +" " + book.getCheckIn());
	   }
	   
	   
	   
	   
	}
	
	

}
