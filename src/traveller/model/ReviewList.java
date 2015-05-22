package traveller.model;

import java.util.ArrayList;

public class ReviewList
{
   private ArrayList<Review> reviews;
   
   public ReviewList()
   {
      reviews = new ArrayList<Review>();
   }
   
   public void addReview(Review r)
   {
      reviews.add(r);
   }
   
   public void deleteReview(int index)
   {
      reviews.remove(index);
   }
   
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
   
   public double getAverage()
   {
      double average = 0;
      for( int i = 0; i < reviews.size(); i++)
      {
         average = average + reviews.get(i).getGrade();
      }
      return average / reviews.size();
   }
   
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
