package traveller.model;
 
public class Review
{
   private int grade;
   private String comment;
   private int revId;
   private User user;
   private Hotel hotel;
   
   public Review(int revId, User user, Hotel hotel, int grade, String comment)
   {
      this.grade = grade;
      this.comment = comment;
      this.revId = revId;
      this.user = user;
      this.hotel = hotel;
   }

   public int getGrade()
   {
      return grade;
   }

   public void setGrade(int grade)
   {
      this.grade = grade;
   }

   public String getComment()
   {
      return comment;
   }

   public void setComment(String comment)
   {
      this.comment = comment;
   }
   
   public int getRevId()
   {
      return revId;
   }

   public void setRevId(int revId)
   {
      this.revId = revId;
   }

   public User getUser()
   {
      return user;
   }

   public void setUser(User user)
   {
      this.user = user;
   }

   public Hotel getHotel()
   {
      return hotel;
   }

   public void setHotel(Hotel hotel)
   {
      this.hotel = hotel;
   }

   public String toString()
   {
      return "ID: " + revId + "; User: " + user.getName() + "; Hotel: " + hotel.getName() + "; Grade: " + grade + "; Comment: " + comment;
   }
   
   
}
