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
 private TravellerModel model;
 private TravellerView view;
 
 public TravellerController(TravellerModel model,TravellerView view)
 {
    this.model= model;
    this.view = view; 
 }
 
 public void execute(String what)
 {
    
           switch (what) {
         case "addHotel":
            int hotelId = Integer.parseInt(view.get("Hotel id"));
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
            Hotel hotel = new Hotel(hotelId, name, city, address, nSr,pSr, nDr, pDr, nTr,pTr, nA, pA);
            //db.addHotelToDatabase(name, address, city, nSr, pSr, nDr, pDr, nTr, pTr, nA, pA);
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
