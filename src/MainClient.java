import traveller.controller.TravellerClientController;
import traveller.mediator.TravellerClientModelManager;
import traveller.view.TravellerClientConsole;
import traveller.view.TravellerClientView;


public class MainClient
{

   public static void main(String[] args)
   {
      try
      {
         TravellerClientModelManager model = new TravellerClientModelManager();
         TravellerClientView view = new TravellerClientConsole();
         TravellerClientController controller = new TravellerClientController(model, view);

         view.start(controller);
      }
      catch (Exception e)
      
      {
         e.printStackTrace();
      }
   }

}
