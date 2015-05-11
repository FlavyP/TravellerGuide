package model;

import java.util.ArrayList;

public class Hotel
{
   private ArrayList<Room> roomList;
   private String name;
   private String adress;
   private String city;

   public Hotel(String name, String adress, String city, int singleRoomNumber,
         double singleRoomPrice, int doubleRoomNumber, double doubleRoomPrice,
         int tripleRoomNumber, double tripleRoomPrice, int apartmentNumber,
         double apartmentPrice)
   {
      this.roomList = new ArrayList<>();
      this.name = name;
      this.adress = adress;
      this.city = city;
      addSingleRoom(new SingleRoom(singleRoomPrice), singleRoomNumber);
      addDoubleRoom(new DoubleRoom(doubleRoomPrice), doubleRoomNumber);
      addTripleRoom(new TripleRoom(tripleRoomPrice), tripleRoomNumber);
      addApartment(new Apartment(apartmentPrice), apartmentNumber);
   }

   public void addSingleRoom(SingleRoom r, int singleRoomNumber)
   {
      for (int i = 0; i < singleRoomNumber; i++)
      {
         roomList.add(r);
      }
   }

   public void addDoubleRoom(DoubleRoom r, int doubleRoomNumber)
   {
      for (int i = 0; i < doubleRoomNumber; i++)
      {
         roomList.add(r);
      }
   }

   public void addTripleRoom(TripleRoom r, int tripleRoomNumber)
   {
      for (int i = 0; i < tripleRoomNumber; i++)
      {
         roomList.add(r);
      }
   }

   public void addApartment(Apartment a, int apartmentNumber)
   {
      for (int i = 0; i < apartmentNumber; i++)
      {
         roomList.add(a);
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

   public String getAdress()
   {
      return adress;
   }

   public void setAdress(String adress)
   {
      this.adress = adress;
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
