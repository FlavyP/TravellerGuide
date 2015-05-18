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
         //DatabaseQueries db = new DatabaseQueries();
         TravellerController controller = new TravellerController(model, view);
         
         view.start(controller);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}
