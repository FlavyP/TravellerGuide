import traveller.mediator.ServerCommunicationThread;
import traveller.mediator.ServerConnectionThread;
import traveller.mediator.TravellerModelManager;
import traveller.view.ServerFrame;

public class MainServer {
	public static void main(String[] args) {
		try {
			ServerFrame.getInstance();
			TravellerModelManager model = new TravellerModelManager();
			ServerConnectionThread server = new ServerConnectionThread(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
