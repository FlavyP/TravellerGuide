package traveller.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import traveller.controller.Controller;
import traveller.controller.TravellerClientController;

public class TravellerGUIHandler implements ActionListener, WindowFocusListener {
	private TravellerGUI gui;
	private TravellerClientController controller;

	public TravellerGUIHandler(TravellerGUI gui, TravellerClientController controller) {
		this.gui = gui;
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
//		System.out.println(command + ", " + e.toString());
		controller.execute(command);
	}

	public void windowGainedFocus(WindowEvent event) {
		String command = "windowFocus";
//		System.out.println(command + ", " + event.toString());
		controller.execute(command);
	}

	@Override
	public void windowLostFocus(WindowEvent event) {
	}
}
