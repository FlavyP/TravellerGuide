package traveller.model;

public class TripleRoom extends Room{

	private double price;
	
	public TripleRoom(int roomId, double price)
	{
	   super(roomId);
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	
}
