package model;

public class DoubleRoom extends Room{

	private double price;
	
	public DoubleRoom(int roomId, double price)
	{
	   super(roomId);
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	
}
