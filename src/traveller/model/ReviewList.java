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
   
   public double getAverage()
   {
      double average = 0;
      for( int i = 0; i < reviews.size(); i++)
      {
         average = average + reviews.get(i).getGrade();
      }
      return average / reviews.size();
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
