package model;

public class SingleRoom extends Room{

	private double price;
	
	public SingleRoom(int roomId, double price)
	{
	   super(roomId);
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	
}
