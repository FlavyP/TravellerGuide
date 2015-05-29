package traveller.model;

/**
* A class representing a room.
* @author Flavian Popa
* @author Gytis Kuosaitis
* @author Julius Jurgauskas
* @author Mihaela Diaconescu
* @version 1.0
*/

public abstract class Room {
   
   private boolean isAvailable;
   private MyDate checkIn;
   private MyDate checkOut;
   private int roomId;
   
   /**
    * One argument constructor
    * @param roomId the room id
    */
   
	public Room(int roomId)
	{
		isAvailable = true;
		this.checkIn = null;
		this.checkOut = null;
		this.roomId = roomId;
	}
	
	
	/**
	 * Method to show that the room is available
	 * @return the room is available
	 */
	
	public boolean isAvailable()
	{
	   return isAvailable;
	}
	
	/**
	 * Abstract method
	 * @return the price of the room
	 */
	
	
	public abstract double getPrice();
	
	/**
	 * Gets the id of the room
	 * @return the id of the room
	 */
	
	public int getId()
	{
	   return roomId;
	}
	
	/**
	 * Gets the check in date
	 * @return the check in date
	 */
	
	public MyDate getCheckIn()
   {
      return checkIn;
   }
	
	/**
	 * Sets the check in date
	 * @param checkIn the check in date
	 */
	
   public void setCheckIn(MyDate checkIn)
   {
      this.checkIn = checkIn;
   }
   
   /**
    * Gets the check out date
    * @return the check out date
    */ 

   public MyDate getCheckOut()
   {
      return checkOut;
   }
   
   /**
    * Sets the check out date
    * @param checkOut the check out date
    */

   public void setCheckOut(MyDate checkOut)
   {
      this.checkOut = checkOut;
   }
   
   /**
    * Sets availability for a room
    * @param isAvailable the room is available
    * @param checkIn the check in date
    * @param checkOut the check out date
    */

   public void setAvailable(boolean isAvailable, MyDate checkIn, MyDate checkOut)
	{
	   this.isAvailable = isAvailable;
	   this.checkIn = checkIn;
	   this.checkOut = checkOut;
	}
   
   /**
    * Method to show that the room is free for reservations
    */
	
	public void markFreeRoom()
	{
	   this.checkIn = null;
	   this.checkOut = null;
	   this.isAvailable = true;
	}

}
