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
import traveller.view.TravellerGUI;
import traveller.view.View;

public class TravellerClientController {
	private TravellerClientModelManager model;
	private TravellerGUI gui;

	public TravellerClientController(TravellerClientModelManager model,
			TravellerGUI gui) {
		this.model = model;
		this.gui = gui;
//		Observable obs = (Observable) model;
//		obs.addObserver(view);
	}

	// public void execute(String what)
	// {
	// switch (what) {
	// case "searchHotelByCity":
	// model.searchHotelByCity("");
	// model.writeToServer(view.get(""));
	// break;
	// case "searchHotelByAddress":
	// model.searchHotelByCity("");
	// break;
	// case "reserve":
	// User user = new User(1, "name", "email", "phoneNumber", "address", true,
	// "pass");
	// view.show (model.getHotels());
	// int id = Integer.parseInt(view.get("Enter id of hotel: "));
	// int sRn = Integer.parseInt(view.get("number single: "));
	// int dRn = Integer.parseInt(view.get("number double: "));
	// int tRn = Integer.parseInt(view.get("number triple: "));
	// int apN = Integer.parseInt(view.get("number apartment: "));
	// Reservation res = new Reservation(1, user, model.getHotel(id), new
	// MyDate(), new MyDate(20,05,2015), sRn, dRn, tRn, apN);
	// view.show("Price:" + model.reserve(res));
	// break;
	// case "showHotels":
	// view.show (model.getHotels());
	// break;
	// case "Quit":
	// System.out.println("Quit");
	// break;
	// default:
	// view.show("Wrong input");
	// break;
	// }
	public void execute(String command) {
		if (command.equals("Exit")) {
			System.exit(0);
		} else if (command.equals("Cancel")) {
			this.gui.disposeActiveWindow();
		} else if (this.gui.getActiveWindow().getName().equals("LogInFrame")) {
			this.controllerLogInFrame(command);
		} else if (this.gui.getActiveWindow().getName().equals("RegisterFrame")) {
			this.controllerRegisterFrame(command);
		} else if (this.gui.getActiveWindow().getName().equals("ReserveFrame")) {
			this.controllerReserveFrame(command);
		} else if (this.gui.getActiveWindow().getName()
				.equals("GiveReviewsFrame")) {
			this.controllerReserveFrame(command);
		}
	}

	public void controllerLogInFrame(String command) {
		if (command.equals("Register")) {
			this.gui.display("RegisterFrame");
		} else if (command.equals("Log in")) {
			String[] input = this.gui.getInput();
			System.out.println(input[0]);
			System.out.println(input[1]);
			boolean[] answer = model.login(input);
			if(answer[0] == false && answer[1] == false)
				this.gui.display("RegisterFrame");
		}
	}

	public void controllerRegisterFrame(String command) {
		if (command.equals("Register")) {
			this.gui.disposeActiveWindow();
			this.gui.display("LogInFrame");
		}

	}

	public void controllerReserveFrame(String command) {
	}

	public void controllerGiveReviewsFrame(String command) {

	}
}
