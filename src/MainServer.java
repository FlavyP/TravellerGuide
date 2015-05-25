import traveller.mediator.ServerCommunicationThread;
import traveller.mediator.ServerConnectionThread;
import traveller.mediator.TravellerModelManager;

public class MainServer {
	public static void main(String[] args) {
		try {
			TravellerModelManager model = new TravellerModelManager();
			// TravellerView view = new TravellerConsole();
			// //DatabaseQueries db = new DatabaseQueries();
			// TravellerController controller = new TravellerController(model,
			// view);
			//
			// view.start(controller);
			ServerConnectionThread server = new ServerConnectionThread(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
