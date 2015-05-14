import traveller.controller.TravellerController;
import traveller.mediator.TravellerModelManager;
import traveller.view.TravellerConsole;
import traveller.view.TravellerView;

public class MainServer
{
   public static void main(String[] args)
   {
      try
      {
         TravellerModelManager model = new TravellerModelManager();
         TravellerView view = new TravellerConsole();
         TravellerController controller = new TravellerController(view, model);
         
         view.start(controller);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}
