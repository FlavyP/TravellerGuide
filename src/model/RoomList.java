package model;

import java.util.ArrayList;

public class RoomList {
   
   private ArrayList<Integer> numberOfRooms;
   private ArrayList<Double> priceOfRooms;
	
	public RoomList()
	{
	   numberOfRooms = new ArrayList<Integer>();
	   priceOfRooms = new ArrayList<Double>();
	}
	
	public int getNumberOfRooms(int idx)
   {
      return numberOfRooms.get(idx);
   }
   
   public void setNumberOfRooms(int number, int idx)
   {
      numberOfRooms.set(idx, number);
   }
   
   public double getPriceOfRooms(int idx)
   {
      return priceOfRooms.get(idx);
   }
   
   public void setPriceOfRooms(double price, int idx)
   {
      priceOfRooms.set(idx, price);
   }
	
}
