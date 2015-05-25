package traveller.controller;

import java.util.ArrayList;
import java.util.Observable;

import traveller.mediator.TravellerClientModelManager;
import traveller.mediator.TravellerModel;
import traveller.model.Hotel;
import traveller.model.MyDate;
import traveller.model.Reservation;
import traveller.model.User;
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
	}

	public void execute(String command) {
		if (command.equals("Back") || command.equals("Cancel")
				|| command.equals("Log Out")) {
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
		} else if (this.gui.getActiveWindow().getName()
				.equals("DirectionsFrame")) {
			this.controllerDirectionsFrame(command);
		} else if (this.gui.getActiveWindow().getName()
				.equals("MyReviewsFrame")) {
			this.controllerMyReviewsFrame(command);
		}
	}

	public void controllerLogInFrame(String command) {
		if (command.equals("Register")) {
			this.gui.display("RegisterFrame");
		} else if (command.equals("Log in")) {
			String[] input = this.gui.getInput();
			try {
				String[] answer = model.login(input);
				if (answer[0] == null)
					throw new Exception("Error: incorrect username or password");
				else {
					if (answer[1].equals("0") && answer[2].equals("0")) {
					} else if (answer[1].equals("1") && answer[2].equals("0")) {
						this.gui.display("AdminFrame");
					} else if (answer[1].equals("1") && answer[2].equals("1")) {
						this.gui.display("GuestFrame");
					}
					this.gui.update(this.clear);
				}
			} catch (Exception e) {
				this.gui.displayErrorMessage(e.getMessage());
			}
		}
	}

	public void controllerRegisterFrame(String command) {
		if (command.equals("Register")) {
			try {
				String[] input = this.gui.getInput();
				if (input[0].isEmpty())
					throw new Exception("Error: no name entered");
				else if (input[1].isEmpty())
					throw new Exception("Error: no email entered");
				else if (input[2].isEmpty())
					throw new Exception("Error: no phone number entered");
				else if (input[3].isEmpty())
					throw new Exception("Error: no address entered");
				else if (input[4].isEmpty())
					throw new Exception("Error: no password entered");
				else {
					model.addUser(input);
					this.gui.disposeActiveWindow();
				}
			} catch (Exception e) {
				this.gui.displayErrorMessage(e.getMessage());
			}
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
			String[] answer = model.getHotelInfo(Integer.parseInt(input[0]));
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
			try {
				String[] input = this.gui.getInput();
				if (input[1].isEmpty())
					throw new Exception("Error: no text entered");
				else {
					model.copy(model.searchHotel(input));
					this.gui.display("SearchFrame2");
				}
			} catch (Exception e) {
				this.gui.displayErrorMessage(e.getMessage());
			}

		}
	}

	public void controllerSearchFrame2(String command) {
		try {
			if (command.equals("windowFocus")) {
				this.gui.update(model.getTableCopy());
			} else if (command.equals("Reserve")) {
				String[] input = this.gui.getInput();
				if(input[0].isEmpty())
					throw new Exception("Error: no hotel selected");
				else{
				model.copy(input);
				this.gui.display("ReserveFrame");
				}
			} else if (command.equals("Give Reviews")) {
				String[] input = this.gui.getInput();
				if(input[0].isEmpty())
					throw new Exception("Error: no hotel selected");
				else{
				model.copy(input);
				this.gui.display("GiveReviewsFrame");
				}
			} else if (command.equals("Get Reviews")) {
				String[] input = this.gui.getInput();
				if(input[0].isEmpty())
					throw new Exception("Error: no hotel selected");
				else{
				model.copy(input);
				this.gui.display("GetReviewsFrame");
				}
			} else if (command.equals("Find interest points")) {
				String[] input = this.gui.getInput();
				if(input[0].isEmpty())
					throw new Exception("Error: no hotel selected");
				else{
				model.copy(input);
				this.gui.display("InterestPointsFrame");
				}
			}
		} catch (Exception e) {
			this.gui.displayErrorMessage(e.getMessage());
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
		String[] comboBoxSelection = this.gui.getInput();
		if (command.equals("Get interest points")) {
			String[] input = this.gui.getInput();
			String[] inform = new String[2];
			inform[0] = "" + hotelId;
			inform[1] = input[0];
			this.gui.update(model.getInterestPoints(inform));
		} else if (command.equals("Get directions")) {
			String[] index = this.gui.getInput();
			String[] inform = new String[3];
			inform[0] = "" + hotelId;
			inform[1] = index[1];
			inform[2] = comboBoxSelection[0];
			String[] answer = new String[1];
			answer[0] = model.getDirections(inform);
			model.copy(answer);
			System.out.println(answer[0]);
			this.gui.display("DirectionsFrame");
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

	public void controllerDirectionsFrame(String command) {
		if (command.equals("windowFocus")) {
			this.gui.update(model.getDataCopy());
		}
	}

	public void controllerMyReviewsFrame(String command) {
		if (command.equals("windowFocus")) {
			this.gui.update(model.getUserReviews(model.getUserId()));
		} else if (command.equals("Cancel review")) {
			String[] reviewId = this.gui.getInput();
			model.cancelReview(Integer.parseInt(reviewId[0]));
			this.gui.update(model.getUserReviews(model.getUserId()));
		}
	}

}
