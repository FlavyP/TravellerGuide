package model;

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
   private int status;
   private double totalPrice;

   public Reservation(User guest, Hotel hotel, MyDate checkIn, MyDate checkOut, int sRn, int dRn, int tRn, int apN)
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
   
   public int getNumberOfSingleRooms()
   {
      return numberOfSingleRooms;
   }

   public void setNumberOfSingleRooms(int numberOfSingleRooms)
   {
      this.numberOfSingleRooms = numberOfSingleRooms;
   }

   public int getNumberOfDoubleRooms()
   {
      return numberOfDoubleRooms;
   }

   public void setNumberOfDoubleRooms(int numberOfDoubleRooms)
   {
      this.numberOfDoubleRooms = numberOfDoubleRooms;
   }

   public int getNumberOfTripleRooms()
   {
      return numberOfTripleRooms;
   }

   public void setNumberOfTripleRooms(int numberOfTripleRooms)
   {
      this.numberOfTripleRooms = numberOfTripleRooms;
   }

   public int getNumberOfApartments()
   {
      return numberOfApartments;
   }

   public void setNumberOfApartments(int numberOfApartments)
   {
      this.numberOfApartments = numberOfApartments;
   }

   public int getStatus()
   {
      return status;
   }

   public void setStatus(int status)
   {
      this.status = status;
   }

   public User getUser()
   {
      return user;
   }

   public void setUser(User user)
   {
      this.user = user;
   }

   public void setHotel(Hotel hotel)
   {
      this.hotel = hotel;
   }
   
   public Hotel getHotel()
   {
      return hotel;
   }
   
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
