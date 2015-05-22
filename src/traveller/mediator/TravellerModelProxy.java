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
			// System.out.println("Connected to server");
			outToServer = new ObjectOutputStream(socket.getOutputStream());
			inFromServer = new ObjectInputStream(socket.getInputStream());
			// ClientRecieverThread recieverThread = new ClientRecieverThread(
			// inFromServer, model);
			// recieverThread.setDaemon(true);
			// recieverThread.start();
			// System.out.println("Receiver thread started");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String[] login(String[] input) {
		String[] answer = null;
		try {
			outToServer.writeObject("1");
			outToServer.writeObject(input);
			answer = (String[]) inFromServer.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return answer;
	}

	public void addHotel(String[] input) {
		try {
			outToServer.writeObject("2");
			outToServer.writeObject(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String[] editHotelGetInfo(int input) {
		String[] answer = null;
		try {
			outToServer.writeObject("3");
			outToServer.writeObject(input);
			answer = (String[]) inFromServer.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return answer;
	}

	public void editHotel(String[] input) {
		try {
			outToServer.writeObject("4");
			outToServer.writeObject(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteHotel(int hotelId) {
		try {
			outToServer.writeObject("5");
			outToServer.writeObject(hotelId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String[][] searchHotel(String[] input) {
		String[][] answer = null;
		try {
			outToServer.writeObject("6");
			outToServer.writeObject(input);
			answer = (String[][]) inFromServer.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return answer;
	}

	public void reserve(String[] input) {
		try {
			outToServer.writeObject("7");
			outToServer.writeObject(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addReview(String[] input) {
		try {
			outToServer.writeObject("8");
			outToServer.writeObject(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String[] getReviews(int input) {
		String[] answer = null;
		try {
			outToServer.writeObject("9");
			outToServer.writeObject(input);
			answer = (String[]) inFromServer.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return answer;
	}
}