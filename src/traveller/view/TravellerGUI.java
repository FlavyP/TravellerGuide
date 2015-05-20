package traveller.view;

import java.awt.Window;

import traveller.controller.Controller;
import traveller.controller.TravellerClientController;

public class TravellerGUI {
	private TravellerGUIHandler handler;
	private View active;

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
		View window = (View) this.getActiveWindow();

		return window.getInput();
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
		} else if (frame.equals("ReserveFrame")) {
			ReserveFrame.getInstance(this.getActiveWindow(), this.handler,
					this.handler);
		} else if (frame.equals("GiveReviewsFrame")) {
			GiveReviewsFrame.getInstance(this.getActiveWindow(), this.handler,
					this.handler);
		}
		else if(frame.equals("AddHotelFrame")){
			AddHotelFrame addHotel = new AddHotelFrame(this.handler, this.handler);
		}
	}

}
