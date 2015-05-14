package model;

import java.util.ArrayList;

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
   
	
	public RoomList()
	{
	   priceOfRooms = new ArrayList<Double>();
	   sRn = new ArrayList<SingleRoom>();
	   dRn = new ArrayList<DoubleRoom>();
	   tRn = new ArrayList<TripleRoom>();
	   aN = new ArrayList<Apartment>(); 

	   //numberOfRooms = new ArrayList<Integer>();
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
	
	public void addSingleRoom()
	{
         sRn.add(new SingleRoom(sRID,priceOfRooms.get(0)));
         sRID++;
	}
	public void addDoubleRoom(){
        dRn.add(new DoubleRoom(dRID,priceOfRooms.get(1)));
        dRID++;
	}
	public void addTripleRoom(){
        tRn.add(new TripleRoom(tRID,priceOfRooms.get(2)));
        tRID++;
	}
	public void addApartment(){
        aN.add(new Apartment(aID,priceOfRooms.get(3)));
        aID++;
	}
   
   public double getPriceOfRooms(int idx)
   {
      return priceOfRooms.get(idx);
   }
   
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
   public int getId(int index){
	   return sRn.get(index).getId();
   }
   public Room getFirstSingleRoom(){
	   for(int i=0;i<sRn.size();i++){
		   if(sRn.get(i).isAvailable() == true)
			   return sRn.get(i);
	   }
	   return null;
   }
   public Room getFirstDoubleRoom(){
	   for(int i=0;i<dRn.size();i++){
		   if(dRn.get(i).isAvailable() == true)
			   return dRn.get(i);
	   }
	   return null;
   }
   public Room getFirstTripleRoom(){
	   for(int i=0;i<tRn.size();i++){
		   if(tRn.get(i).isAvailable() == true)
			   return tRn.get(i);
	   }
	   return null;
   }
   public Room getFirstApartment(){
	   for(int i=0;i<aN.size();i++){
		   if(aN.get(i).isAvailable() == true)
			   return aN.get(i);
	   }
	   return null;
   }
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
   
   public Room getRoom(int index)
   {
      return sRn.get(index);
   }
   
   public void markFreeRooms()
   {
//	   System.out.println(sRn.get(0).getCheckIn());
//	   System.out.println(sRn.get(1).getCheckIn());
      for( int i = 0; i < sRn.size(); i++)
      {
         if (sRn.get(i).getCheckOut() != null && sRn.get(i).getCheckOut().isBefore(MyDate.today()))
         {
            sRn.get(i).markFreeRoom();
         }
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
