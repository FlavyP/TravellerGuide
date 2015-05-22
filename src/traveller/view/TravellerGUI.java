package traveller.view;

import java.awt.Window;

import traveller.controller.Controller;
import traveller.controller.TravellerClientController;

public class TravellerGUI {
	private TravellerGUIHandler handler;
	private View active;
	private String[] dataCopy;
	private String[][] tableCopy;

	public TravellerGUI() {
		this.handler = null;
		this.active = null;
		this.dataCopy = null;
		this.tableCopy = null;
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

	public void update(String[] update) {
		View window = (View) this.getActiveWindow();
		window.update(update);
	}

	public void update(String[][] update) {
		View window = (View) this.getActiveWindow();
		window.update(update);
	}

	public void copy(String[] data) {
		this.dataCopy = data;
	}

	public void copy(String[][] table) {
		this.tableCopy = table;
	}

	public void copy(String[] data, String[][] table) {
		this.dataCopy = data;
		this.tableCopy = table;
	}

	public String[] getDataCopy() {
		return dataCopy;
	}

	public String[][] getTableCopy() {
		return tableCopy;
	}

	public void clearCopies() {
		this.dataCopy = null;
		this.tableCopy = null;
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
		}
		else if (frame.equals("MyReservationFrame")) {
         MyReservationFrame.getInstance(this.getActiveWindow(), this.handler,
               this.handler);
      }
	}

}
