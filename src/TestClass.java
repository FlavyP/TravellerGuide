import model.*;


public class TestClass
{
   public static void main(String[] args)
   {
	   User user = new User("bob","bob@0", "1656", "hhsad", true, 1);
	   Hotel h1 = new Hotel("Hotel1", "Name1", "City", 25, 25.25, 25, 30.25, 25, 50.25, 25, 100.25);
	   ReservationList rs = new ReservationList();
	   System.out.println(rs.reserve(user, h1, new MyDate(10, 05, 2015), new MyDate(20, 05, 2015), 2, 1, 0, 0));
	   System.out.println(h1.getfirstAvailableSingleRoom().getId());
	   System.out.println(rs.reserve(user, h1, new MyDate(10, 05, 2015), new MyDate(13, 05, 2015), 2, 1, 0, 0));
//	   System.out.println(h1.getRoomId(0));
	   System.out.println(h1.getfirstAvailableSingleRoom().getId());

	   //System.out.println(rs.reserve(user, h1, new MyDate(), new MyDate(20, 06, 2015), 1, 1, 0, 1));
   }
}
