package model;

public class Hotel
{
   private RoomList roomList;
   private String name;
   private String address;
   private String city;
   
   public Hotel(String name, String address, String city,
         int numberOfSingleRooms, double singleRoomPrice,
         int numberOfDoubleRooms, double doubleRoomPrice,
         int numberOfTripleRooms, double tripleRoomPrice,
         int numberOfApartments, double apartmentPrice)
   {
      this.name = name;
      this.address = address;
      this.city = city;
      
      roomList.setNumberOfRooms(numberOfSingleRooms, 0);
      roomList.setNumberOfRooms(numberOfDoubleRooms, 1);
      roomList.setNumberOfRooms(numberOfTripleRooms, 2);
      roomList.setNumberOfRooms(numberOfApartments, 3);
      
      roomList.setPriceOfRooms(singleRoomPrice, 0);
      roomList.setPriceOfRooms(doubleRoomPrice, 1);
      roomList.setPriceOfRooms(tripleRoomPrice, 2);
      roomList.setPriceOfRooms(apartmentPrice, 3);
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
   
   public int getNumberOfRooms(int idx)
   {
      return roomList.getNumberOfRooms(idx);
   }
   
   public void setNumberOfRooms(int number, int idx)
   {
      roomList.setNumberOfRooms(number, idx);
   }
   
   public double getPriceOfRooms(int idx)
   {
      return roomList.getPriceOfRooms(idx);
   }
   
   public void setPriceOfRooms(double price, int idx)
   {
      roomList.setPriceOfRooms(price, idx);
   }

}
