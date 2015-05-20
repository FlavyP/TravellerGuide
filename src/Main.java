import traveller.controller.Controller;
import traveller.view.TravellerGUI;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      try
	      {
	         TravellerGUI gui = new TravellerGUI();
	         Controller controller = new Controller(gui);
//	         gui.startGUI(controller);
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	}

}
