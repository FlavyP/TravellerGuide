package model;

public class SingleRoom extends Room{

	private double price;
	
	public SingleRoom(double price)
	{
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	
}
