package traveller.model;

public class Apartment extends Room{

	private double price;
	
	public Apartment(int roomId, double price)
	{
	   super(roomId);
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	
}

