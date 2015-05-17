package traveller.model;

public class Hotel
{
   private RoomList roomList;
   private String name;
   private String address;
   private String city;

   public Hotel(String name, String city, String address,
         int numberOfSingleRooms, double singleRoomPrice,
         int numberOfDoubleRooms, double doubleRoomPrice,
         int numberOfTripleRooms, double tripleRoomPrice,
         int numberOfApartments, double apartmentPrice)
   {
      this.name = name;
      this.address = address;
      this.city = city;
      // roomList = new RoomList(numberOfSingleRooms, numberOfDoubleRooms,
      // numberOfTripleRooms, numberOfApartments);
      roomList = new RoomList();
      roomList.setPriceOfRooms(0, singleRoomPrice);
      roomList.setPriceOfRooms(1, doubleRoomPrice);
      roomList.setPriceOfRooms(2, tripleRoomPrice);
      roomList.setPriceOfRooms(3, apartmentPrice);
      roomList.addRooms(numberOfSingleRooms, numberOfDoubleRooms,
            numberOfTripleRooms, numberOfApartments);

      /*
       * roomList.setNumberOfRooms(numberOfSingleRooms, 0);
       * roomList.setNumberOfRooms(numberOfDoubleRooms, 1);
       * roomList.setNumberOfRooms(numberOfTripleRooms, 2);
       * roomList.setNumberOfRooms(numberOfApartments, 3);
       */
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

   public double getPriceOfRooms(int idx)
   {
      return roomList.getPriceOfRooms(idx);
   }

   public void setPriceOfRooms(int idx, double price)
   {
      roomList.setPriceOfRooms(idx, price);
   }

   public int getRoomId(int index)
   {
      return roomList.getId(index);
   }

   public Room getfirstAvailableSingleRoom()
   {
      return roomList.getFirstSingleRoom();
   }

   public Room getfirstAvailableDoubleRoom()
   {
      return roomList.getFirstDoubleRoom();
   }

   public Room getfirstAvailableTripleRoom()
   {
      return roomList.getFirstTripleRoom();
   }

   public Room getfirstAvailableApartment()
   {
      return roomList.getFirstApartment();
   }

   public void setAvailability(Room r, boolean isAv, MyDate checkIn,
         MyDate checkOut)
   {
      roomList.setAvailability(r, isAv, checkIn, checkOut);
   }

   public void markFreeRooms()
   {
      roomList.markFreeRooms();
   }

   public Room getRoom(int index)
   {
      return roomList.getRoom(index);
   }

   public String toString()
   {
      return "Name: " + name + "; Address: " + address + "; City: " + city
            + "\n" + "Number of Single Rooms: " + roomList.getNumberOfRooms(0)
            + " Price of Single Rooms: " + roomList.getPriceOfRooms(0) + "\n"
            + "Number of Double Rooms: " + roomList.getNumberOfRooms(1)
            + " Price of Double Rooms: " + roomList.getPriceOfRooms(1) + "\n"
            + "Number of Triple Rooms: " + roomList.getNumberOfRooms(2)
            + " Price of Triple Rooms: " + roomList.getPriceOfRooms(2) + "\n"
            + "Number of Apartments: " + roomList.getNumberOfRooms(3)
            + " Price of Apartments: " + roomList.getPriceOfRooms(3);
   }
}
