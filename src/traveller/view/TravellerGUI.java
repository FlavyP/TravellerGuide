package traveller.view;

import java.awt.Window;

import javax.swing.JOptionPane;

import traveller.controller.TravellerClientController;

public class TravellerGUI {
	private TravellerGUIHandler handler;
	private TravellerView active;

	public TravellerGUI() {
		this.handler = null;
		this.active = null;
	}

	public void startGUI(TravellerClientController controller) {
		this.handler = new TravellerGUIHandler(this, controller);
		this.active = LogInFrame.getInstance(handler, handler);
	}

	public Window getActiveWindow() {
		Window output = null;
		Window[] windows = LogInFrame.getWindows();
		for (int i = 0; i < windows.length && output == null; ++i) {
			if (windows[i].isActive()) {
				output = windows[i];
			}
		}
		return output;
	}

	public String[] getInput() {
		TravellerView window = (TravellerView) this.getActiveWindow();

		return window.getInput();
	}

	public void update(String[] update) {
		TravellerView window = (TravellerView) this.getActiveWindow();
		window.update(update);
	}

	public void update(String[][] update) {
		TravellerView window = (TravellerView) this.getActiveWindow();
		window.update(update);
	}

	public void disposeActiveWindow() {
		this.getActiveWindow().dispose();
	}

	public void display(String frame) {
		if (frame.equals("LogInFrame")) {
			LogInFrame.getInstance(this.handler, this.handler);
		} else if (frame.equals("RegisterFrame")) {
			RegisterFrame.getInstance(this.getActiveWindow(), this.handler,
					this.handler);
		} else if (frame.equals("GiveReviewsFrame")) {
			GiveReviewsFrame.getInstance(this.getActiveWindow(), this.handler,
					this.handler);
		} else if (frame.equals("AdminFrame")) {
			AdminFrame.getInstance(this.getActiveWindow(), this.handler,
					this.handler);
		} else if (frame.equals("AddHotelFrame")) {
			AddHotelFrame.getInstance(this.getActiveWindow(), this.handler,
					this.handler);
		} else if (frame.equals("EditHotelFrame")) {
			EditHotelFrame.getInstance(this.getActiveWindow(), this.handler,
					this.handler);
		} else if (frame.equals("GuestFrame")) {
			GuestFrame.getInstance(this.getActiveWindow(), this.handler,
					this.handler);
		} else if (frame.equals("SearchFrame1")) {
			SearchFrame1.getInstance(this.getActiveWindow(), this.handler,
					this.handler);
		} else if (frame.equals("SearchFrame2")) {
			SearchFrame2.getInstance(this.getActiveWindow(), this.handler,
					this.handler);
		} else if (frame.equals("ReserveFrame")) {
			ReserveFrame.getInstance(this.getActiveWindow(), this.handler,
					this.handler);
		} else if (frame.equals("GiveReviewsFrame")) {
			GiveReviewsFrame.getInstance(this.getActiveWindow(), this.handler,
					this.handler);
		} else if (frame.equals("GetReviewsFrame")) {
			GetReviewsFrame.getInstance(this.getActiveWindow(), this.handler,
					this.handler);
		} else if (frame.equals("MyReservationFrame")) {
			MyReservationFrame.getInstance(this.getActiveWindow(),
					this.handler, this.handler);
		} else if (frame.equals("MyReviewsFrame")) {
			MyReviewsFrame.getInstance(this.getActiveWindow(), this.handler,
					this.handler);
		} else if (frame.equals("InterestPointsFrame")) {
			InterestPointsFrame.getInstance(this.getActiveWindow(),
					this.handler, this.handler);
		} else if (frame.equals("DirectionsFrame")) {
			DirectionsFrame.getInstance(this.getActiveWindow(), this.handler,
					this.handler);
		}
	}

	public void displayErrorMessage(String message) {
		JOptionPane.showMessageDialog(this.getActiveWindow(), message, "Error",
				JOptionPane.ERROR_MESSAGE);
	}

}
