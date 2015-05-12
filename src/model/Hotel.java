package model;

import java.util.ArrayList;

public class Hotel
{
   private ArrayList<Room> roomList;
   private String name;
   private String address;
   private String city;
   private int numberOfSingleRooms;
   private double singleRoomPrice;
   private int numberOfDoubleRooms;
   private double doubleRoomPrice;
   private int numberOfTripleRooms;
   private double tripleRoomPrice;
   private int numberOfApartments;
   private double apartmentPrice;
   //create private parameters for each number of room

   public Hotel(String name, String address, String city, 
         int singleRoomNumber, double singleRoomPrice, 
         int doubleRoomNumber, double doubleRoomPrice,
         int tripleRoomNumber, double tripleRoomPrice, 
         int apartmentNumber, double apartmentPrice)
   {
      this.roomList = new ArrayList<>();
      this.name = name;
      this.address = address;
      this.city = city;
   }

   public void addRoom(Room r, int numberOfRooms)
   {
      for (int i = 0; i < numberOfRooms; i++)
      {
         roomList.add(r);
      }
   }
   
   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public String getAddress()
   {
      return address;
   }

   public void setAddress(String address)
   {
      this.address = address;
   }

   public String getCity()
   {
      return city;
   }

   public void setCity(String city)
   {
      this.city = city;
   }
   
   public int getNumberOfSingleRooms()
   {
      return numberOfSingleRooms;
   }

   public void setNumberOfSingleRooms(int numberOfSingleRooms)
   {
      this.numberOfSingleRooms = numberOfSingleRooms;
   }

   public double getSingleRoomPrice()
   {
      return singleRoomPrice;
   }

   public void setSingleRoomPrice(double singleRoomPrice)
   {
      this.singleRoomPrice = singleRoomPrice;
   }

   public int getNumberOfDoubleRooms()
   {
      return numberOfDoubleRooms;
   }

   public void setNumberOfDoubleRooms(int numberOfDoubleRooms)
   {
      this.numberOfDoubleRooms = numberOfDoubleRooms;
   }

   public double getDoubleRoomPrice()
   {
      return doubleRoomPrice;
   }

   public void setDoubleRoomPrice(double doubleRoomPrice)
   {
      this.doubleRoomPrice = doubleRoomPrice;
   }

   public int getNumberOfTripleRooms()
   {
      return numberOfTripleRooms;
   }

   public void setNumberOfTripleRooms(int numberOfTripleRooms)
   {
      this.numberOfTripleRooms = numberOfTripleRooms;
   }

   public double getTripleRoomPrice()
   {
      return tripleRoomPrice;
   }

   public void setTripleRoomPrice(double tripleRoomPrice)
   {
      this.tripleRoomPrice = tripleRoomPrice;
   }

   public int getNumberOfApartments()
   {
      return numberOfApartments;
   }

   public void setNumberOfApartments(int numberOfApartments)
   {
      this.numberOfApartments = numberOfApartments;
   }

   public double getApartmentPrice()
   {
      return apartmentPrice;
   }

   public void setApartmentPrice(double apartmentPrice)
   {
      this.apartmentPrice = apartmentPrice;
   }

}
