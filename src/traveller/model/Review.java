package traveller.model;
 
public class Review
{
   private int grade;
   private String comment;
   
   public Review(int grade, String comment)
   {
      this.grade = grade;
      this.comment = comment;
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
   
   public String toString()
   {
      return "Grade: " + grade + "; Comment: " + comment;
   }
   
   
}
