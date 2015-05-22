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
		if (command.equals("Back")) {
			this.gui.disposeActiveWindow();
		} else if (command.equals("Cancel")) {
			this.gui.disposeActiveWindow();
		} else if (command.equals("Log Out")) {
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
		} else if (this.gui.getActiveWindow().getName()
				.equals("GiveReviewsFrame")) {
			this.controllerGiveReviewsFrame(command);
		} else if (this.gui.getActiveWindow().getName()
				.equals("GetReviewsFrame")) {
			this.controllerGetReviewsFrame(command);
		} else if (this.gui.getActiveWindow().getName()
				.equals("MyReservationFrame")) {
			this.controllerMyReservationFrame(command);
		} else if (this.gui.getActiveWindow().getName()
				.equals("InterestPointsFrame")) {
			this.controllerInterestPointsFrame(command);
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
		} else if (command.equals("My reservations")) {
			this.gui.display("MyReservationFrame");
		} else if (command.equals("My reviews")) {
			this.gui.display("MyReviewsFrame");
		}
	}

	public void controllerSearchFrame1(String command) {
		if (command.equals("Search")) {
			String[] input = this.gui.getInput();
			model.copy(model.searchHotel(input));
			this.gui.display("SearchFrame2");
		}
	}

	public void controllerSearchFrame2(String command) {
		if (command.equals("windowFocus")) {
			this.gui.update(model.getTableCopy());
		} else if (command.equals("Reserve")) {
			model.copy(this.gui.getInput());
			this.gui.display("ReserveFrame");
		} else if (command.equals("Give Reviews")) {
			this.gui.display("GiveReviewsFrame");
		} else if (command.equals("Get Reviews")) {
			this.gui.display("GetReviewsFrame");
		} else if (command.equals("Find interest points")) {
			model.copy(this.gui.getInput());
			this.gui.display("InterestPointsFrame");
		}
	}

	public void controllerReserveFrame(String command) {
		String[] hotelId = model.getDataCopy();
		if (command.equals("Reserve")) {
			String[] input = this.gui.getInput();
			input[0] = "" + model.getUserId();
			input[1] = hotelId[0];
			model.reserve(input);
			this.gui.disposeActiveWindow();
		}
	}

	public void controllerGiveReviewsFrame(String command) {
		String[][] hotelId = model.getTableCopy();
		if (command.equals("Submit")) {
			String[] input = this.gui.getInput();
			input[0] = "" + model.getUserId();
			input[1] = hotelId[0][0];
			model.addReview(input);
			this.gui.disposeActiveWindow();
		}
	}

	public void controllerGetReviewsFrame(String command) {
		if (command.equals("windowFocus")) {
			String[][] hotelId = model.getTableCopy();
			this.gui.update(model.getReviews(Integer.parseInt(hotelId[0][0])));
		}
	}

	public void controllerInterestPointsFrame(String command) {
		String[][] hotel = model.getTableCopy();
		int hotelId = Integer.parseInt(hotel[0][0]);
		if (command.equals("Get interest points")) {
			String[] input = this.gui.getInput();
			System.out.println("hotelId: " + hotelId + " intr selec: "
					+ input[0]);
			String[] inform = new String[2];
			inform[0] = input[0];
			inform[1] = "" + hotelId;
			this.gui.update(model.getInterestPoints(inform));
		}
	}

	public void controllerMyReservationFrame(String command) {
		if (command.equals("windowFocus")) {
			this.gui.update(model.getReservations(model.getUserId()));
		} else if (command.equals("Cancel Reservation")) {
			String[] reservationId = this.gui.getInput();
			model.cancelReservation(Integer.parseInt(reservationId[0]));
			this.gui.update(model.getReservations(model.getUserId()));
		}
	}

}
