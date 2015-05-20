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
		// Observable obs = (Observable) model;
		// obs.addObserver(view);
	}

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
		} else if (this.gui.getActiveWindow().getName().equals("AdminFrame")) {
			this.controllerAdminFrame(command);
		}
	}

	public void controllerLogInFrame(String command) {
		if (command.equals("Register")) {
			this.gui.display("RegisterFrame");
		} else if (command.equals("Log in")) {
			String[] input = this.gui.getInput();
			boolean[] answer = model.login(input);
			if (answer[0] == false && answer[1] == false) {

			} else if (answer[0] == true && answer[1] == false) {
				this.gui.display("AdminFrame");
			}

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

	public void controllerAdminFrame(String command) {
		if (command.equals("Add Hotel")) {
			this.gui.display("AddHotelFrame");
		}
	}
}
