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
		} else if (this.gui.getActiveWindow().getName().equals("AddHotelFrame")) {
			this.controllerAddHotelFrame(command);
		} else if (this.gui.getActiveWindow().getName()
				.equals("EditHotelFrame")) {
			this.controllerEditHotelFrame(command);
		} else if (this.gui.getActiveWindow().getName().equals("GuestFrame")) {
			this.controllerGuestFrame(command);
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
			} else if (answer[0] == true && answer[1] == true) {
				this.gui.display("GuestFrame");
			}
			this.gui.update(null);
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
		} else if (command.equals("Edit Hotel")) {
			this.gui.display("EditHotelFrame");
		}
	}

	public void controllerAddHotelFrame(String command) {
		if (command.equals("Add hotel")) {
			String[] input = this.gui.getInput();
			model.addHotel(input);
		} else if (command.equals("Clear")) {
			this.gui.update(null);
		}
	}

	public void controllerEditHotelFrame(String command) {
		if (command.equals("Get info")) {
			String[] input = this.gui.getInput();
			String[] answer = model
					.editHotelGetInfo(Integer.parseInt(input[0]));
			this.gui.update(answer);
		} else if (command.equals("Clear")) {
			this.gui.update(null);
		} else if (command.equals("Edit hotel")) {
			String[] input = this.gui.getInput();
			model.editHotel(input);
		}
	}

	public void controllerGuestFrame(String command){
		if(command.equals("")){
			
		}
	}
}
