package traveller.model;

import java.util.ArrayList;

public class ReservationList
{
   private ArrayList<Reservation> resList;
   
   public ReservationList()
   {
      resList = new ArrayList<Reservation>();
   }
   
   public double reserve(Reservation res)
   {
      
      resList.add(res);
      
      
      for(int i=0;i<res.getNumberOfSingleRooms();i++){
    	  Room r = resList.get(resList.size()-1).getHotel().getfirstAvailableSingleRoom();
    	  resList.get(resList.size()-1).getHotel().setAvailability(r, false, res.getCheckIn(), res.getCheckOut());
      }
      for(int i=0;i<res.getNumberOfDoubleRooms();i++){
    	  Room r = resList.get(resList.size()-1).getHotel().getfirstAvailableDoubleRoom();
    	  resList.get(resList.size()-1).getHotel().setAvailability(r, false, res.getCheckIn(), res.getCheckOut());
      }
      for(int i=0;i<res.getNumberOfTripleRooms();i++){
    	  Room r = resList.get(resList.size()-1).getHotel().getfirstAvailableTripleRoom();
    	  resList.get(resList.size()-1).getHotel().setAvailability(r, false, res.getCheckIn(), res.getCheckOut());
      }
      for(int i=0;i<res.getNumberOfApartments();i++){
    	  Room r = resList.get(resList.size()-1).getHotel().getfirstAvailableApartment();
    	  resList.get(resList.size()-1).getHotel().setAvailability(r, false, res.getCheckIn(), res.getCheckOut());
      }
      res.getHotel().markFreeRooms();
      return res.getTotalPrice();
      
      //SQL Code for insert into 'Reservation'
   }
   public int size()
   {
      return resList.size();
   }
   
   public Reservation getReservation(int index){
	   return resList.get(index);
   }
   public void cancelReservation(int resId)
   {
      //Not sure = when you delete a reservation from DB, index is lost, when you delete a reservation from ArrayList
      //every reservation goes -1 in index
      for( int i = 0; i < resList.size(); i++)
      {
         if ( resList.get(i).getResId() == resId)
         {
            resList.remove(i);
         }
      }
      //SQL Code for removing
   }
   
   public ArrayList<Reservation> getReservationsByUser(int userId)
   {
      ArrayList<Reservation> res = new ArrayList<Reservation>();
      for(int i = 0; i < resList.size(); i++)
      {
         if( resList.get(i).getUser().getUserId() == userId)
         {
            res.add(resList.get(i));
         }
      }
      return res;
   }
   
   public String toString()
   {
      String msg = "";
      for(int i = 0; i < resList.size(); i++)
      {
         msg+="Reservation ID: " + resList.get(i).getResId() + " User ID:" + resList.get(i).getUser().getUserId() 
               + " Hotel ID:" + resList.get(i).getHotel().getHotelId() + "\n" 
               + " Check In Date: " + resList.get(i).getCheckIn().toString() + " Check out Date: " + resList.get(i).getCheckOut().toString() + "\n" 
               + " Single rooms:" + resList.get(i).getNumberOfSingleRooms() + "\n" 
               + " Double rooms: " + resList.get(i).getNumberOfDoubleRooms() + "\n"
               + " Triple rooms: " + resList.get(i).getNumberOfTripleRooms() + "\n"
               + " Apartments: " + resList.get(i).getNumberOfApartments();
      }
      
      return msg;
   }
}
