package traveller.model;

import java.util.ArrayList;

public class ReservationList
{
   private ArrayList<Reservation> resList;
   
   public ReservationList()
   {
      resList = new ArrayList<Reservation>();
   }
   
   public double reserve(User user, Hotel hotel, MyDate checkIn, MyDate checkOut, int sRn, int dRn, int tRn, int apN)
   {
      Reservation res = new Reservation(user, hotel, checkIn, checkOut, sRn, dRn, tRn, apN);
      resList.add(res);
      
      
      for(int i=0;i<sRn;i++){
    	  Room r = resList.get(resList.size()-1).getHotel().getfirstAvailableSingleRoom();
    	  resList.get(resList.size()-1).getHotel().setAvailability(r, false, checkIn, checkOut);
      }
      for(int i=0;i<dRn;i++){
    	  Room r = resList.get(resList.size()-1).getHotel().getfirstAvailableDoubleRoom();
    	  resList.get(resList.size()-1).getHotel().setAvailability(r, false, checkIn, checkOut);
      }
      for(int i=0;i<tRn;i++){
    	  Room r = resList.get(resList.size()-1).getHotel().getfirstAvailableTripleRoom();
    	  resList.get(resList.size()-1).getHotel().setAvailability(r, false, checkIn, checkOut);
      }
      for(int i=0;i<apN;i++){
    	  Room r = resList.get(resList.size()-1).getHotel().getfirstAvailableApartment();
    	  resList.get(resList.size()-1).getHotel().setAvailability(r, false, checkIn, checkOut);
      }
      hotel.markFreeRooms();
      return res.getTotalPrice();
      
      //SQL Code for insert into 'Reservation'
   }
   
   public void editReservation()
   {
      //SQL Code for ALTERING
   }
   
   public void cancelReservation(int index)
   {
      //Not sure = when you delete a reservation from DB, index is lost, when you delete a reservation from ArrayList
      //every reservation goes -1 in index
      resList.remove(index);
      //SQL Code for removing
   }
}
