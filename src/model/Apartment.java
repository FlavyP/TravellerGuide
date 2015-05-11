package model;

public class Apartment extends Room{

	private double price;
	
	public Apartment(double price)
	{
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	
}

