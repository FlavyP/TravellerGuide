package traveller.mediator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import traveller.model.Hotel;

public class ServerCommunicationThread extends Thread implements Observer {
	private ObjectInputStream inFromClient;
	private ObjectOutputStream outToClient;
	private TravellerModelManager model;

	public ServerCommunicationThread(Socket clientSocket, TravellerModelManager model)
			throws IOException {
		inFromClient = new ObjectInputStream(clientSocket.getInputStream());
		outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
		this.model = model;
		Observable obs = (Observable) model;
		obs.addObserver(this);
	}

	public void run() {
		try {
			while (true) {
				int choice = Integer.parseInt((String) inFromClient
						.readObject());
				switch (choice) {
				case 1:
					String[] input1 = (String[]) inFromClient.readObject();
					boolean[] b = model.getUser(input1[0], input1[1]);
					send(b);
					break;
				case 2:
					String[] input2 = (String[]) inFromClient.readObject();
					model.addHotel(input2);
					break;
				case 3:
					// model.returnItem();
					break;
				case 4:
					// model.reserveItem();
					break;
				case 5:
					// model.searchItem();
					break;
				case 6:
					System.exit(0);
					break;
				default:
					break;
				}
			}
		} catch (SocketException e) {
			// ok
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void send(String message) {
		try {
			outToClient.writeObject(message);
		} catch (Exception e) {
			// no client connection
			System.out.println("Exception for client broadcast to client - "
					+ e.getMessage());

		}
	}
	public void send(Object message) {
		try {
			outToClient.writeObject(message);
		} catch (Exception e) {
			// no client connection
			System.out.println("Exception for client broadcast to client - "
					+ e.getMessage());

		}
	}

	@Override
	public void update(Observable o, Object arg) {
		this.send(arg.toString());
	}
}
