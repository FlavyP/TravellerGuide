package traveller.controller;

import java.util.ArrayList;

import cd.domain.model.Cd;
import cd.domain.model.CdList;
import library.domain.mediator.LibraryModelManager;
import traveller.mediator.TravellerModel;
import traveller.model.Hotel;
import traveller.model.HotelList;
import traveller.model.User;
import traveller.view.TravellerView;

public class TravellerController
{
 private TravellerView view;
 private TravellerModel model;
 
 public TravellerController(TravellerView view, TravellerModel model)
 {
	 this.view = view;
	 this.model= model;
 }
 
 public void execute(String what)
 {
	 
           switch (what) {
   		case "add a hotel":
   			String name = view.get("name");
   			String address = view.get("address");
   			String city = view.get("city");
   			int nSr = Integer.parseInt(view.get("numberS"));
   			double pSr = Double.parseDouble(view.get("priceS"));
   			int nDr = Integer.parseInt(view.get("numberD"));
   			double pDr = Double.parseDouble(view.get("priceD"));
   			int nTr = Integer.parseInt(view.get("numberT"));
   			double pTr = Double.parseDouble(view.get("priceT"));
   			int nA = Integer.parseInt(view.get("numberA"));
   			double pA = Double.parseDouble(view.get("priceA"));
   			Hotel hotel = new Hotel(name, address, city, nSr,pSr, nDr, pDr, nTr,pTr, nA, pA);
   			model.addHotel(hotel);
   			break;
   		case "Search by title":
   			String input = view.get("Title");
   			if (input == null)
   				return;
   			String msg = "";
   		     
   			ArrayList<Hotel> list = model.searchHotelByCity(city);
   			for (int i = 0; i < list.size(); i++)
   			{
   				msg += list.get(i) + "\n";
   			}
   			
   			if (list.size() == 0) {
   				msg = "No hotel: \"" + input + "\" found";
   			}
   			view.show(msg);
   			break;
   		case "search by address":
   			 input = view.get("Address");
   			if (input == null)
   				return;
   			 msg = "";
   	 
   		    list = model.searchHotelByCity(address);
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
   		case "Quit":
   			System.out.println("Quit");
   			break;
   		default:
   			view.show("Wrong input");
   			break;
     }
 }
 }
