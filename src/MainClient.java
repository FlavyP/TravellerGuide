import traveller.controller.TravellerClientController;
import traveller.mediator.TravellerClientModelManager;
import traveller.mediator.TravellerModel;
import traveller.mediator.TravellerModelManager;
import traveller.view.TravellerGUI;


public class MainClient
{

   public static void main(String[] args)
   {
	      try
	      {
	         TravellerGUI gui = new TravellerGUI();
	         TravellerClientModelManager model = new TravellerClientModelManager();
	         TravellerClientController controller = new TravellerClientController(model, gui);
	         gui.startGUI(controller);
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
   }

}
