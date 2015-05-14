package model;

public abstract class Room {
   
   private boolean isAvailable;
   private MyDate checkIn;
   private MyDate checkOut;
   private int roomId;
   
	public Room(int roomId)
	{
		isAvailable = true;
		this.checkIn = null;
		this.checkOut = null;
		this.roomId = roomId;
	}
	
	public boolean isAvailable()
	{
	   return isAvailable;
	}
	
	
	public abstract double getPrice();
	
	public int getId()
	{
	   return roomId;
	}
	
	public MyDate getCheckIn()
   {
      return checkIn;
   }

   public void setCheckIn(MyDate checkIn)
   {
      this.checkIn = checkIn;
   }

   public MyDate getCheckOut()
   {
      return checkOut;
   }

   public void setCheckOut(MyDate checkOut)
   {
      this.checkOut = checkOut;
   }

   public void setAvailable(boolean isAvailable, MyDate checkIn, MyDate checkOut)
	{
	   this.isAvailable = isAvailable;
	   this.checkIn = checkIn;
	   this.checkOut = checkOut;
	}
	
	public void markFreeRoom()
	{
	   this.checkIn = null;
	   this.checkOut = null;
	   this.isAvailable = true;
	}

}
