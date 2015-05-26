package traveller.model;

/**
 * A class representing the Google Directions API.
 * 
 * @author Flavian Popa
 * @author Gytis Kuosaitis
 * @author Julius Jurgauskas
 * @author Mihaela Diaconescu
 * @version 1.0
 */

public class Apartment extends Room{

	private double price;
	
	/**
	 * Two-argument constructor
	 * @param roomId apartment's id.
	 * @param price apartment's price per night.
	 */
	public Apartment(int roomId, double price)
	{
	   super(roomId);
		this.price = price;
	}
	
	/**
	 * Gets the price of the room per night.
	 * @return price of the room per night.
	 */
	public double getPrice() {
		return price;
	}
	
}

