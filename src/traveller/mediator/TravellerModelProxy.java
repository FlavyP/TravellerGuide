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
	private TravellerClientModelManager model;

	public TravellerModelProxy(TravellerClientModelManager model) {
		try {
			this.model = model;
			socket = new Socket(HOST, PORT);
//			System.out.println("Connected to server");
			outToServer = new ObjectOutputStream(socket.getOutputStream());
			inFromServer = new ObjectInputStream(socket.getInputStream());
//			ClientRecieverThread recieverThread = new ClientRecieverThread(
//					inFromServer, model);
//			recieverThread.setDaemon(true);
//			recieverThread.start();
//			System.out.println("Receiver thread started");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean[] login(String[] input) {
		boolean[] answer = null;
		try {
			outToServer.writeObject("1");
			outToServer.writeObject(input);
			answer = (boolean[]) inFromServer.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return answer;
	}

	public void writeToServer(String[] input) {
		try {
			outToServer.writeObject(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}