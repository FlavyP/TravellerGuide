package traveller.controller;

import java.util.ArrayList;

import traveller.mediator.TravellerModel;
import traveller.model.Hotel;
import traveller.model.HotelList;
import traveller.model.MyDate;
import traveller.model.Reservation;
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
         case "addHotel":
            String name = view.get("Name");
            String city = view.get("City");
            String address = view.get("Address");
            int nSr = Integer.parseInt(view.get("number single: "));
            double pSr = Double.parseDouble(view.get("price single: "));
            int nDr = Integer.parseInt(view.get("number double: "));
            double pDr = Double.parseDouble(view.get("price double: "));
            int nTr = Integer.parseInt(view.get("number triple: "));
            double pTr = Double.parseDouble(view.get("price triple: "));
            int nA = Integer.parseInt(view.get("number apartment: "));
            double pA = Double.parseDouble(view.get("price apartment: "));
            Hotel hotel = new Hotel(name, city, address, nSr,pSr, nDr, pDr, nTr,pTr, nA, pA);
            model.addHotel(hotel);
            //db.addHotelToDatabase(name, address, city, nSr, pSr, nDr, pDr, nTr, pTr, nA, pA);
            break;
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
