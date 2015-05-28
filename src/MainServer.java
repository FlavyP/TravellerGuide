import traveller.mediator.ServerCommunicationThread;
import traveller.mediator.ServerConnectionThread;
import traveller.mediator.TravellerModelManager;
import traveller.view.ServerFrame;

public class MainServer {
	public static void main(String[] args) {
		try {
			TravellerModelManager model = new TravellerModelManager();
			ServerFrame.getInstance();
			ServerConnectionThread server = new ServerConnectionThread(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
