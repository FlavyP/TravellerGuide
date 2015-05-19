package traveller.controller;

import traveller.view.TravellerGUI;

public class Controller {

	private TravellerGUI gui;

	public Controller(TravellerGUI gui) {
		this.gui = gui;
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
		}
		else if (this.gui.getActiveWindow().getName().equals("ReserveFrame")) {
			this.controllerReserveFrame(command);
		}
		else if (this.gui.getActiveWindow().getName().equals("GiveReviewsFrame")) {
			this.controllerReserveFrame(command);
		}
	}

	public void controllerLogInFrame(String command) {
		if (command.equals("Register")) {
			this.gui.display("RegisterFrame");
		} else if (command.equals("Log in")) {
			this.gui.display("GiveReviewsFrame");
		}
	}

	public void controllerRegisterFrame(String command) {
		if (command.equals("Register")) {
			this.gui.disposeActiveWindow();
			this.gui.display("LogInFrame");
		} 

	}
	public void controllerReserveFrame(String command) {
//		if (command.equals("Reserve")) {
//		}
	}
	public void controllerGiveReviewsFrame(String command){
		
	}

}