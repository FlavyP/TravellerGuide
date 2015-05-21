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
}
