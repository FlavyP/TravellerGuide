package model;

import java.util.ArrayList;

public class Hotel {
  private ArrayList<Room> roomList;
  private String name;
  private String adress;
  private String city;
  private MyDate checkIn;
  private MyDate checkOut;
  
  
  
  public Hotel(String name,String adress, String city)
  {
	  this.roomList = new ArrayList<>();
	  this.name = name;
	  this.adress = adress;
	  this.city = city;
  }
  
  
}
