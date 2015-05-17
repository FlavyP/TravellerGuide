import traveller.controller.TravellerController;
import traveller.mediator.TravellerModelManager;
import traveller.model.*;
import traveller.view.TravellerConsole;
import traveller.view.TravellerView;

public class TestClass {
	public static void main(String[] args) {
		// User user = new User("bob","bob@0", "1656", "hhsad", true, 1);
		// Hotel h1 = new Hotel("Hotel1", "Name1", "City", 25, 25.25, 25, 30.25,
		// 25, 50.25, 25, 100.25);
		// Hotel h2 = new Hotel("Hotel2", "Name2", "City2", 25, 25.25, 25,
		// 30.25, 25, 50.25, 25, 100.25);
		// ReservationList rs = new ReservationList();
		// System.out.println(rs.reserve(user, h1, new MyDate(10, 05, 2015), new
		// MyDate(20, 05, 2015), 2, 1, 0, 0));
		// System.out.println(h1.getfirstAvailableSingleRoom().getId());
		// System.out.println(rs.reserve(user, h1, new MyDate(10, 05, 2015), new
		// MyDate(13, 05, 2015), 2, 1, 0, 0));
		// // System.out.println(h1.getRoomId(0));
		// System.out.println(h1.getfirstAvailableSingleRoom().getId());
		//
		// HotelList list = new HotelList();
		// list.addHotel(h1);
		// list.addHotel(h2);
		//
		// System.out.println(list.getHotelsInCity("City2").get(0).getName());
		// //System.out.println(rs.reserve(user, h1, new MyDate(), new
		// MyDate(20, 06, 2015), 1, 1, 0, 1));
	   
		try {
			TravellerModelManager model = new TravellerModelManager();
			TravellerView view = new TravellerConsole();
			//DatabaseQueries db = new DatabaseQueries();
			TravellerController controller = new TravellerController(view,
					model);

			view.start(controller);
		} catch (Exception e)

		{
			e.printStackTrace();
		}
	}
}