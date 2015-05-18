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
//		} else if (command.equals("Cancel")) {
//			this.gui.disposeActiveWindow();
		} else if (this.gui.getActiveWindow().getName().equals("LogInFrame")) {
			this.controllerLogInFrame(command);
		} else if (this.gui.getActiveWindow().getName().equals("RegisterFrame")) {
			this.controllerRegisterFrame(command);
		}
	}

	public void controllerLogInFrame(String command) {
		if (command.equals("Register")) {
			this.gui.display("RegisterFrame");
		} else if (command.equals("Log in")) {
		}
	}

	public void controllerRegisterFrame(String command) {
		if (command.equals("Register")) {
			this.gui.disposeActiveWindow();
			this.gui.display("LogInFrame");
		} 
		else if (command.equals("Cancel")) {
			this.gui.disposeActiveWindow();
			this.gui.display("LogInFrame");
		}
	}

}