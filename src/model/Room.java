package model;

public abstract class Room {
	
   private MyDate checkIn;
   private MyDate checkOut;
   
	public Room()
	{
		
	}
	
	public abstract double getPrice();

}
