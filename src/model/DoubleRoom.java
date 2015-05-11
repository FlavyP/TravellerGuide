package model;

public class DoubleRoom extends Room{

	private double price;
	
	public DoubleRoom(double price)
	{
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	
}
