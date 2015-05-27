package traveller.model;

import java.util.ArrayList;

/**
 * A class representing reservation list.
 * @author Flavian Popa
 * @author Gytis Kuosaitis
 * @author Julius Jurgauskas
 * @author Mihaela Diaconescu
 * @version 1.0
 */

public class ReservationList
{
   private ArrayList<Reservation> resList;
   
   /**
	* No-argument constructor
   */
   public ReservationList()
   {
      resList = new ArrayList<Reservation>();
   }
   
   /**
    * Reserves hotel's rooms
    * @param res what reservation will be added
    * @return total price of reservation
    */
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

   /**
    * Gets the reservation list size
    * @return the reservation list size
    */
public int size()
   {
      return resList.size();
   }
   
   public Reservation getReservation(int index){
	   return resList.get(index);
   }
   
   /**
    * Cancels reservation at Id
    * @param resId what reservation will be canceled Id
    */
public void cancelReservation(int resId)
   {
      for( int i = 0; i < resList.size(); i++)
      {
         if ( resList.get(i).getResId() == resId)
         {
            resList.remove(i);
         }
      }
   }
   
   /**
    * Gets reservation list by user Id
    * @param userId what reservations will be selected by
    * @return reservation list by user Id
    */
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
               + " Apartments: " + resList.get(i).getNumberOfApartments() + "\n"
               + "Total Price: " + resList.get(i).getTotalPrice();
      }
      
      return msg;
   }
}
