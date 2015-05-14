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
//      roomList = new RoomList(numberOfSingleRooms, numberOfDoubleRooms, numberOfTripleRooms, numberOfApartments);
      roomList = new RoomList();
      roomList.setPriceOfRooms(0, singleRoomPrice);
      roomList.setPriceOfRooms(1, doubleRoomPrice);
      roomList.setPriceOfRooms(2, tripleRoomPrice);
      roomList.setPriceOfRooms(3, apartmentPrice);
      roomList.addRooms(numberOfSingleRooms, numberOfDoubleRooms, numberOfTripleRooms, numberOfApartments);
      
      /*roomList.setNumberOfRooms(numberOfSingleRooms, 0);
      roomList.setNumberOfRooms(numberOfDoubleRooms, 1);
      roomList.setNumberOfRooms(numberOfTripleRooms, 2);
      roomList.setNumberOfRooms(numberOfApartments, 3);*/
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
   public int getRoomId(int index){
	   return roomList.getId(index);
   }
   public Room getfirstAvailableSingleRoom(){
	   return roomList.getFirstSingleRoom();
   }
   public Room getfirstAvailableDoubleRoom(){
	   return roomList.getFirstDoubleRoom();
   }
   public Room getfirstAvailableTripleRoom(){
	   return roomList.getFirstTripleRoom();
   }
   public Room getfirstAvailableApartment(){
	   return roomList.getFirstApartment();
   }
   public void setAvailability(Room r, boolean isAv, MyDate checkIn, MyDate checkOut)
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
}
