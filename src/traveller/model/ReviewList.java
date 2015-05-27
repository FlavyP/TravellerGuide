package traveller.model;

import java.util.ArrayList;

/**
 * A class representing a hotel.
 * @author Flavian Popa
 * @author Gytis Kuosaitis
 * @author Julius Jurgauskas
 * @author Mihaela Diaconescu
 * @version 1.0
 */

public class ReviewList
{
   private ArrayList<Review> reviews;
   
   /**
    * No-argument constructor
    */
   public ReviewList()
   {
      reviews = new ArrayList<Review>();
   }
   /**
    * Adds review to the review list
    * @param hotel what review will be added
    */
   public void addReview(Review r)
   {
      reviews.add(r);
   }
   /**
    * Deletes review from the review list
    * @param index shows what review with index will be deleted
    */
   public void deleteReview(int index)
   {
      reviews.remove(index);
   }
   /**
    * Gets review list by user id
    * @param userId what reviews will be selected
    * @return review list by user id
    */
   public ArrayList<Review> getReviews(int userId)
   {
      ArrayList<Review> newRev = new ArrayList<Review>();
      for(int i = 0; i < reviews.size(); i++)
      {
         if( reviews.get(i).getUser().getUserId() == userId)
         {
            newRev.add(reviews.get(i));
         }
      }
      return newRev;
   }
   /**
    * Gets review list by hotel id
    * @param hotelId what reviews will be selected
    * @return review list by hotel id
    */
   public ArrayList<Review> getReviewsByHotel(int hotelId)
   {
      ArrayList<Review> newRev = new ArrayList<Review>();
      for(int i = 0; i < reviews.size(); i++)
      {
         if( reviews.get(i).getHotel().getHotelId() == hotelId)
         {
            newRev.add(reviews.get(i));
         }
      }
      return newRev;
   }
   /**
    * Gets average grade
    * @return average grade
    */
   public double getAverage()
   {
      double average = 0;
      for( int i = 0; i < reviews.size(); i++)
      {
         average = average + reviews.get(i).getGrade();
      }
      return average / reviews.size();
   }
   /**
    * Gets the review list size
    * @return the review list size
    */
   public int size(){
	   return reviews.size();
   }
   
   public String toString()
   {
      String msg = "";
      for( int i = 0; i < reviews.size(); i++)
      {
         msg = msg + reviews.get(i) + "\n";
      }
      msg = msg + "Average: " + getAverage();
      return msg;
   }
}
