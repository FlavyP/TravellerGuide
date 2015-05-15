package traveller.controller;

import java.util.ArrayList;
import java.util.Observable;

import traveller.mediator.TravellerClientModelManager;
import traveller.mediator.TravellerModel;
import traveller.model.Hotel;
import traveller.model.MyDate;
import traveller.model.Reservation;
import traveller.model.User;
import traveller.view.TravellerClientView;

public class TravellerClientController {
       private TravellerClientModelManager model;
       private TravellerClientView view;
       
 public TravellerClientController(TravellerClientModelManager model, TravellerClientView view )
 {
	 this.model = model;
	 this.view = view;
     Observable obs = (Observable) model;
     obs.addObserver(view);
 }
 
 public void execute(String what)
 {
	 switch (what) {
		case "searchHotelByCity":
			model.searchHotelByCity("");
			model.writeToServer(view.get(""));
			break;
		case "searchHotelByAddress":
			model.searchHotelByCity("");
			break;
		case "reserve":
		   User user = new User(1, "name", "email", "phoneNumber", "address", true, "pass");
			view.show (model.getHotels());
			int id = Integer.parseInt(view.get("Enter id of hotel: "));
			int sRn = Integer.parseInt(view.get("number single: "));
			int dRn = Integer.parseInt(view.get("number double: "));
			int tRn = Integer.parseInt(view.get("number triple: "));
			int apN = Integer.parseInt(view.get("number apartment: "));
			Reservation res = new Reservation(1, user, model.getHotel(id), new MyDate(), new MyDate(20,05,2015), sRn, dRn, tRn, apN);
         view.show("Price:" + model.reserve(res));			
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
