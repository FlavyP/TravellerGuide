package traveller.model;

/**
* A class representing a reservation.
* @author Flavian Popa
* @author Gytis Kuosaitis
* @author Julius Jurgauskas
* @author Mihaela Diaconescu
* @version 1.0
*/

public class Reservation
{

   private MyDate checkIn;
   private MyDate checkOut;
   private User user;
   private Hotel hotel;
   private int numberOfSingleRooms;
   private int numberOfDoubleRooms;
   private int numberOfTripleRooms;
   private int numberOfApartments;
   private double totalPrice;
   private int resId;
   
   /**
    * Nine arguments constructor
    * @param resId reservation id
    * @param guest the user that makes the reservation
    * @param hotel the hotel in were the reservation is made
    * @param checkIn the date that the guest checks in
    * @param checkOut the date that the guest checks out
    * @param sRn single rooms number
    * @param dRn double rooms number
    * @param tRn triple rooms number
    * @param apN apartments number
    */

   public Reservation(int resId, User guest, Hotel hotel, MyDate checkIn, MyDate checkOut, int sRn, int dRn, int tRn, int apN)
   {

      this.checkIn = checkIn;
      this.checkOut = checkOut;
      this.user = guest;
      this.hotel = hotel;
      this.numberOfSingleRooms = sRn;
      this.numberOfDoubleRooms = dRn;
      this.numberOfTripleRooms = tRn;
      this.numberOfApartments = apN;
      totalPrice = 0;
      this.resId = resId;
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
    * Set the check in date
    * @param checkIn what the check in date will be set to
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
    * Set the check out date
    * @param checkIn what the check out date will be set to
    */

   public void setCheckOut(MyDate checkOut)
   {
      this.checkOut = checkOut;
   }
   
   /**
    * Gets the number of single rooms
    * @return the number of single rooms
    */
   
   public int getNumberOfSingleRooms()
   {
      return numberOfSingleRooms;
   }
   
   /**
    * Sets the number of single rooms
    * @param numberOfSingleRooms what the number of single rooms will be
    */

   public void setNumberOfSingleRooms(int numberOfSingleRooms)
   {
      this.numberOfSingleRooms = numberOfSingleRooms;
   }
   
   /**
    * Gets the number of double rooms
    * @return the number of double rooms
    */

   public int getNumberOfDoubleRooms()
   {
      return numberOfDoubleRooms;
   }
   
   /**
    * Sets the number of double rooms
    * @param numberOfDoubleRooms what the number of double rooms will be
    */

   public void setNumberOfDoubleRooms(int numberOfDoubleRooms)
   {
      this.numberOfDoubleRooms = numberOfDoubleRooms;
   }
   
   /**
    * Gets the number of triple rooms
    * @return the number of triple rooms
    */

   public int getNumberOfTripleRooms()
   {
      return numberOfTripleRooms;
   }

   /**
    * Sets the number of triple rooms
    * @param numberOfTripleRooms what the number of triple rooms will be
    */
   
   public void setNumberOfTripleRooms(int numberOfTripleRooms)
   {
      this.numberOfTripleRooms = numberOfTripleRooms;
   }

   /**
    * Gets the number of apartments 
    * @return the number of apartments
    */
   public int getNumberOfApartments()
   {
      return numberOfApartments;
   }
   
   /**
    * Sets the number of apartments
    * @param numberOfApartments what the number of apartments will be
    */

   public void setNumberOfApartments(int numberOfApartments)
   {
      this.numberOfApartments = numberOfApartments;
   }
   
   /**
    * Gets the user
    * @return the user
    */
   
   public User getUser()
   {
      return user;
   }
   
   /**
    * Sets the user
    * @param user user of the reservation
    */

   public void setUser(User user)
   {
      this.user = user;
   }
   
  /**
   * Sets the hotel
   * @param hotel the hotel where the reservation will be made
   */
   
   public void setHotel(Hotel hotel)
   {
      this.hotel = hotel;
   }
   
   /**
    * Gets the hotel  where the reservation will be made
    * @return the hotel where the reservation will be made
    */
   
   public Hotel getHotel()
   {
      return hotel;
   }
   
   /**
    * Gets the reservation id
    * @return the reservation id
    */
   
   public int getResId()
   {
      return resId;
   }
   
   /**
    * Sets the reservation id
    * @param resId reservation id
    */

   public void setResId(int resId)
   {
      this.resId = resId;
   }
   
   /**
    * Sets the total price for the reservation
    * @param totalPrice the total price for the reservation
    */
   
   public void setTotalPrice(double totalPrice)
   {
      this.totalPrice = totalPrice;
   }
   
   
   /**
    * Finds the total price for the reservation
    * @param h hotel
    * @param checkIn check in date
    * @param checkOut check out date
    * @param sR number of single rooms
    * @param dR number of double rooms
    * @param tR number of triple rooms
    * @param aP number of apartments
    * @return
    */
   public static double totalPrice(Hotel h, MyDate checkIn, MyDate checkOut, int sR, int dR, int tR, int aP)
   {
      double totalSr = h.getPriceOfRooms(0) * sR * MyDate.numberOfDays(checkIn, checkOut);
      double totalDr = h.getPriceOfRooms(1) * dR * MyDate.numberOfDays(checkIn, checkOut);
      double totalTr = h.getPriceOfRooms(2) * tR * MyDate.numberOfDays(checkIn, checkOut);
      double totalAp = h.getPriceOfRooms(3) * aP * MyDate.numberOfDays(checkIn, checkOut);
      
      return totalSr + totalDr + totalTr + totalAp;
   }
   
   /**
    * Gets the total price of the reservation
    * @return the total price of the reservation
    */

   public double getTotalPrice()
   {
      double totalSr = hotel.getPriceOfRooms(0) * numberOfSingleRooms * MyDate.numberOfDays(checkIn, checkOut);
      double totalDr = hotel.getPriceOfRooms(1) * numberOfDoubleRooms * MyDate.numberOfDays(checkIn, checkOut);
      double totalTr = hotel.getPriceOfRooms(2) * numberOfTripleRooms * MyDate.numberOfDays(checkIn, checkOut);
      double totalAp = hotel.getPriceOfRooms(3) * numberOfApartments * MyDate.numberOfDays(checkIn, checkOut);
      
      this.totalPrice = totalSr + totalDr + totalTr + totalAp;
      return totalPrice;
   }

}
