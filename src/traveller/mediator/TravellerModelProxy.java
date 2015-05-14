package traveller.mediator;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TravellerModelProxy extends Thread {
	private final int PORT = 2910;
	private final String HOST = "localhost";
	private Socket socket;
	private ObjectOutputStream outToServer;
	private ObjectInputStream inFromServer;
	private TravellerModel model;

	public TravellerModelProxy(TravellerModel model) {
		try {
			this.model = model;
			socket = new Socket(HOST, PORT);
//			System.out.println("Connected to server");
			outToServer = new ObjectOutputStream(socket.getOutputStream());
			inFromServer = new ObjectInputStream(socket.getInputStream());
			ClientRecieverThread recieverThread = new ClientRecieverThread(
					inFromServer, model);
			recieverThread.setDaemon(true);
			recieverThread.start();
//			System.out.println("Receiver thread started");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchHotelByCity() {
		try {
			outToServer.writeObject("1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeToServer(String message) {
		try {
			outToServer.writeObject(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}