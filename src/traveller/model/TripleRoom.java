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

public class TripleRoom extends Room{

   private double price;
   
   /**
    * Two-argument constructor.
    * @param roomId room's id.
    * @param price room's price per night.
    */
   public TripleRoom(int roomId, double price)
   {
      super(roomId);
      this.price = price;
   }
   
   /**
    * Gets room's price per night.
    * @return room's price per night.
    */
   public double getPrice() {
      return price;
   }
   
}
