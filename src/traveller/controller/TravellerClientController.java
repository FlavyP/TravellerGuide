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
	private String[] clear;

	public TravellerClientController(TravellerClientModelManager model,
			TravellerGUI gui) {
		this.model = model;
		this.gui = gui;
		this.clear = new String[] { "clear" };
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
		} else if (this.gui.getActiveWindow().getName().equals("AdminFrame")) {
			this.controllerAdminFrame(command);
		} else if (this.gui.getActiveWindow().getName().equals("AddHotelFrame")) {
			this.controllerAddHotelFrame(command);
		} else if (this.gui.getActiveWindow().getName()
				.equals("EditHotelFrame")) {
			this.controllerEditHotelFrame(command);
		} else if (this.gui.getActiveWindow().getName().equals("GuestFrame")) {
			this.controllerGuestFrame(command);
		} else if (this.gui.getActiveWindow().getName().equals("SearchFrame1")) {
			this.controllerSearchFrame1(command);
		} else if (this.gui.getActiveWindow().getName().equals("SearchFrame2")) {
			this.controllerSearchFrame2(command);
		} else if (this.gui.getActiveWindow().getName().equals("ReserveFrame")) {
			this.controllerReserveFrame(command);
		}
	}

	public void controllerLogInFrame(String command) {
		if (command.equals("Register")) {
			this.gui.display("RegisterFrame");
		} else if (command.equals("Log in")) {
			String[] input = this.gui.getInput();
			String[] answer = model.login(input);
			if (answer[1].equals("0") && answer[2].equals("0")) {
			} else if (answer[1].equals("1") && answer[2].equals("0")) {
				this.gui.display("AdminFrame");
			} else if (answer[1].equals("1") && answer[2].equals("1")) {
				this.gui.display("GuestFrame");
			}
			this.gui.update(this.clear);
		}
	}

	public void controllerRegisterFrame(String command) {
		if (command.equals("Register")) {
			this.gui.disposeActiveWindow();
			this.gui.display("LogInFrame");
		}

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
			this.gui.update(this.clear);
		}
	}

	public void controllerEditHotelFrame(String command) {
		if (command.equals("Get info")) {
			String[] input = this.gui.getInput();
			String[] answer = model
					.editHotelGetInfo(Integer.parseInt(input[0]));
			this.gui.update(answer);
		} else if (command.equals("Clear")) {
			this.gui.update(this.clear);
		} else if (command.equals("Edit hotel")) {
			String[] input = this.gui.getInput();
			model.editHotel(input);
		} else if (command.equals("Delete")) {
			String[] input = this.gui.getInput();
			model.deleteHotel(Integer.parseInt(input[0]));
		}
	}

	public void controllerGuestFrame(String command) {
		if (command.equals("Search")) {
			this.gui.display("SearchFrame1");
		}
	}

	public void controllerSearchFrame1(String command) {
		if (command.equals("Search")) {
			String[] input = this.gui.getInput();
			this.gui.copy(model.searchHotel(input));
			this.gui.display("SearchFrame2");
		}
	}

	public void controllerSearchFrame2(String command) {
		if (command.equals("windowFocus")) {
			this.gui.update(this.gui.getTableCopy());
		} else if (command.equals("Reserve")) {
			this.gui.copy(this.gui.getInput());
			this.gui.display("ReserveFrame");
		}
	}

	public void controllerReserveFrame(String command) {
		String[] hotelId = this.gui.getDataCopy();
		System.out.println(hotelId[0]);
		if (command.equals("Reserve")) {
			String[] input = this.gui.getInput();
			input[0] = "" + model.getUserId();
			input[1] = hotelId[0];
			model.reserve(input);
		}
	}
}
