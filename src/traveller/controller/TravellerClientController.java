package traveller.controller;

import java.util.ArrayList;

import traveller.mediator.TravellerModel;
import traveller.model.Hotel;
import traveller.model.MyDate;
import traveller.model.User;
import traveller.view.TravellerClientView;

public class TravellerClientController {
       private TravellerModel model;
       private TravellerClientView view;
       
 public TravellerClientController(TravellerModel model, TravellerClientView view )
 {
	 this.model = model;
	 this.view = view;
 }
 
 public void execute(String what)
 {
	 switch (what) {
		case "searchHotelByCity":
			String input = view.get("City");
			if (input == null)
				return;
			String msg = "";
		     
			ArrayList<Hotel> list = model.searchHotelByCity(input);
			for (int i = 0; i < list.size(); i++)
			{
				msg += list.get(i) + "\n";
			}
			
			if (list.size() == 0) {
				msg = "No hotel: \"" + input + "\" found";
			}
			view.show(msg);
			break;
		case "searchHotelByAddress":
			 input = view.get("Address");
			if (input == null)
				return;
			 msg = "";
	 
		    list = model.searchHotelByAddress(input);
			for (int i = 0; i < list.size(); i++)
			{
				msg += list.get(i) + "\n";
			}
			
			if (list.size() == 0) {
				msg = "No hotel: \"" + input + "\" found";
			}
			view.show(msg);
			break;
		case "reserve":
			User user = new User("name", "email", "phoneNumber", "address", true, 12);
			view.show (model.getHotels());
			int id = Integer.parseInt(view.get("Enter id of hotel: "));
			int sRn = Integer.parseInt(view.get("number single: "));
			int dRn = Integer.parseInt(view.get("number double: "));
			int tRn = Integer.parseInt(view.get("number triple: "));
			int apN = Integer.parseInt(view.get("number apartment: "));
			view.show("Price:" + model.reserve(user, model.getHotel(id), new MyDate(), new MyDate(20,05,2015), sRn, dRn, tRn, apN));
			break;
		case "showHotels":
			view.show (model.getHotels());
			break;
		case "Quit":
			System.out.println("Quit");
			break;
		default:
			view.show("Wrong input");
			break;
 }
       

}
}
