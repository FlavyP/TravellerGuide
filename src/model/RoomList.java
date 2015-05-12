package model;

import java.util.ArrayList;

public class RoomList {

	private ArrayList<SingleRoom> singleRoom;
	private ArrayList<DoubleRoom> doubleRoom;
	private ArrayList<TripleRoom> tripleRoom;
	private ArrayList<Apartment> apartment;
	
	
	public RoomList()
	{
		singleRoom = new ArrayList<SingleRoom>();
		doubleRoom = new ArrayList<DoubleRoom>();
		tripleRoom = new ArrayList<TripleRoom>();
		 apartment = new ArrayList<Apartment>();
	}
	
	public int getAllSingle()
	{
		return singleRoom.size();
	}
	
	public int getAllDouble()
	{
		return doubleRoom.size();
	}
	
	public int getAllTriple()
	{
		return tripleRoom.size();
	}
	
	public int getAllApartments()
	{
		return apartment.size();
	}
	

	
}
