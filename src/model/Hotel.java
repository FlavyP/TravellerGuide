package model;

import java.util.ArrayList;

public class Hotel {
  private ArrayList<Room> roomList;
  private String name;
  private String adress;
  private String city;
  private MyDate checkIn;
  private MyDate checkOut;
  
  
  
  public Hotel(String name,String adress, String city, int singleRoomNumber, double singleRoomPrice, int doubleRoomNumber)
  {
	  this.roomList = new ArrayList<>();
	  this.name = name;
	  this.adress = adress;
	  this.city = city;
	  
	  for(int i = 0; i < singleRoomNumber; i++)
	  {
	     addSingleRoom(new SingleRoom(singleRoomPrice));
	  }
  }
  
  public void addSingleRoom(SingleRoom r)
  {
     roomList.add(r);
  }
  
}
