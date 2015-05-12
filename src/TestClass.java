import model.MyDate;
import model.User;


public class TestClass
{
   public static void main(String[] args)
   {
	   User user = new User("bob","bob@0", "1656", "hhsad", true, 1);
	   user.reserve(1, 2, new MyDate(), new MyDate());
	   
   }
}
