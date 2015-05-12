package model;

import java.util.ArrayList;

public class Hotel
{
   private ArrayList<Room> roomList;
   private String name;
   private String address;
   private String city;
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
      addRoom(new SingleRoom(singleRoomPrice), singleRoomNumber);
      addRoom(new DoubleRoom(doubleRoomPrice), doubleRoomNumber);
      addRoom(new TripleRoom(tripleRoomPrice), tripleRoomNumber);
      addRoom(new Apartment(apartmentPrice), apartmentNumber);
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

}
