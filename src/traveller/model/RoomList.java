package traveller.model;

import java.util.ArrayList;

/**
* A class representing a room list.
* @author Flavian Popa
* @author Gytis Kuosaitis
* @author Julius Jurgauskas
* @author Mihaela Diaconescu
* @version 1.0
*/

public class RoomList {
   
   private ArrayList<SingleRoom> sRn;
   private ArrayList<DoubleRoom> dRn;
   private ArrayList<TripleRoom> tRn;
   private ArrayList<Apartment> aN;
//   private ArrayList<Integer> numberOfRooms;
   private ArrayList<Double> priceOfRooms;
   
   private int sRID = 1;
   private int dRID = 1;
   private int tRID = 1;
   private int aID = 1;
   
   /**
    * No-argument constructor
    */
	
	public RoomList()
	{
	   priceOfRooms = new ArrayList<Double>();
	   sRn = new ArrayList<SingleRoom>();
	   dRn = new ArrayList<DoubleRoom>();
	   tRn = new ArrayList<TripleRoom>();
	   aN = new ArrayList<Apartment>(); 

	   //numberOfRooms = new ArrayList<Integer>();
	   
	   /**
	    * Add rooms to the room list
	    * @param numberOfSingleR number of single rooms added
	    * @param numberOfDoubleR number of double rooms added
	    * @param numberOfTripleR number of triple rooms added
	    * @param numberOfApartment number of apartments added
	    */
	}
	public void addRooms(int numberOfSingleR, int numberOfDoubleR, int numberOfTripleR, int numberOfApartment){
		   for(int i=0;i<numberOfSingleR;i++){
			   addSingleRoom();
		   }
		   for(int i=0;i<numberOfDoubleR;i++){
			   addDoubleRoom();
		   }
		   for(int i=0;i<numberOfTripleR;i++){
			   addTripleRoom();
		   }
		   for(int i=0;i<numberOfApartment;i++){
			   addApartment();
		   }
	}
	
	/**
	 * Gets the number of rooms
	 * @param idx index
	 * @return the total number of rooms
	 */
	
	public int getNumberOfRooms(int idx)
   {
	   int count = 0;
	   
	   switch (idx)
	   {
	      case 0: 
	         count = sRn.size();
	         break;
	      case 1:
	         count = dRn.size();
	         break;
	      case 2:
	         count = tRn.size();
	         break;
	      case 3:
	         count = aN.size();
	         break;
	   }
	   
	   return count;
      
   }
	
	/**
	 * Add single rooms to the list
	 */
	
	public void addSingleRoom()
	{
         sRn.add(new SingleRoom(sRID,priceOfRooms.get(0)));
         sRID++;
	}
	
	/**
	 * Add double rooms to the list
	 */
	public void addDoubleRoom(){
        dRn.add(new DoubleRoom(dRID,priceOfRooms.get(1)));
        dRID++;
	}
	
	/**
	 * Add triple rooms to the list
	 */
	
	public void addTripleRoom(){
        tRn.add(new TripleRoom(tRID,priceOfRooms.get(2)));
        tRID++;
	}
	
	/**
	 * Add apartments to the list
	 */
	
	public void addApartment(){
        aN.add(new Apartment(aID,priceOfRooms.get(3)));
        aID++;
	}
	
	/**
	 * Gets the price of rooms by the index
	 * @param idx index
	 * @return the price of rooms by the index
	 */
   
   public double getPriceOfRooms(int idx)
   {
      return priceOfRooms.get(idx);
   }
   
   /**
    * Sets the price of rooms by the index
    * @param idx index
    * @param price price to be set
    */ 
   
   public void setPriceOfRooms(int idx, double price)
   {
      priceOfRooms.add(idx, price);
   }
   
   /*public int getNumberOfRooms(int idx)
   {
      return numberOfRooms.get(idx);
   }
   
   public void setNumberOfRooms(int number, int idx)
   {
      numberOfRooms.add(idx, number);
   }*/
   
   /**
    * Gets the id of a room by the index
    * @param index index
    * @return the id of a room by the index
    */
   
   public int getId(int index){
	   return sRn.get(index).getId();
   }
   
   /**
    * Gets the first single room available
    * @return the first single room available
    */
   
   public Room getFirstSingleRoom(){
	   for(int i=0;i<sRn.size();i++){
		   if(sRn.get(i).isAvailable() == true)
			   return sRn.get(i);
	   }
	   return null;
   }
   
   /**
    * Gets the first double room available
    * @return the first double room available
    */
   public Room getFirstDoubleRoom(){
	   for(int i=0;i<dRn.size();i++){
		   if(dRn.get(i).isAvailable() == true)
			   return dRn.get(i);
	   }
	   return null;
   }
   
   /**
    * Gets the first triple room available
    * @return the first triple room available
    */
   
   public Room getFirstTripleRoom(){
	   for(int i=0;i<tRn.size();i++){
		   if(tRn.get(i).isAvailable() == true)
			   return tRn.get(i);
	   }
	   return null;
   }
   
   /**
    * Gets the first available apartment
    * @return the first available apartment
    */
   public Room getFirstApartment(){
	   for(int i=0;i<aN.size();i++){
		   if(aN.get(i).isAvailable() == true)
			   return aN.get(i);
	   }
	   return null;
   }
   
   /**
    * Sets availability for a room
    * @param r room
    * @param isAv is available
    * @param checkIn check in date
    * @param checkOut check out date
    */ 
   
   public void setAvailability(Room r, boolean isAv, MyDate checkIn, MyDate checkOut)
   {
      if( r instanceof SingleRoom)
         sRn.get(r.getId()-1).setAvailable(isAv, checkIn, checkOut);
      if( r instanceof DoubleRoom)
         dRn.get(r.getId()-1).setAvailable(isAv, checkIn, checkOut);
      if( r instanceof TripleRoom)
         tRn.get(r.getId()-1).setAvailable(isAv, checkIn, checkOut);
      if( r instanceof Apartment)
         aN.get(r.getId()-1).setAvailable(isAv, checkIn, checkOut);
   }
   
   /**
    * Gets a room by the index
    * @param index index
    * @return a room by the index
    */
   
   public Room getRoom(int index)
   {
      return sRn.get(index);
   }
   
   /**
    * It shows the free rooms
    */
   
   public void markFreeRooms()
   {
//	   System.out.println(sRn.get(0).getCheckIn());
//	   System.out.println(sRn.get(1).getCheckIn());
      for( int i = 0; i < sRn.size(); i++)
      {
         if (sRn.get(i).getCheckOut() != null && sRn.get(i).getCheckOut().isBefore(MyDate.today()))
         {
            sRn.get(i).markFreeRoom();         }
      }
      
//      for( int i = 0; i < dRn.size(); i++)
//      {
//         if ( dRn.get(i).getCheckOut().isBefore(MyDate.today()))
//         {
//            dRn.get(i).markFreeRoom();
//         }
//      }
//      
//      for( int i = 0; i < tRn.size(); i++)
//      {
//         if ( tRn.get(i).getCheckOut().isBefore(MyDate.today()))
//         {
//            tRn.get(i).markFreeRoom();
//         }
//      }
//      
//      for( int i = 0; i < aN.size(); i++)
//      {
//         if ( aN.get(i).getCheckOut().isBefore(MyDate.today()))
//         {
//            aN.get(i).markFreeRoom();
//         }
//      }
   }
}
