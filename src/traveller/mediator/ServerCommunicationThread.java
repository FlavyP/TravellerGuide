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

	public ServerCommunicationThread(Socket clientSocket,
			TravellerModelManager model) throws IOException {
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
					String[] b = model.getUser(input1[0], input1[1]);
					send(b);
					break;
				case 2:
					String[] input2 = (String[]) inFromClient.readObject();
					model.addHotel(input2);
					break;
				case 3:
					int input3 = (int) inFromClient.readObject();
					send(model.getHotelInfo(input3 - 1));
					break;
				case 4:
					String[] input4 = (String[]) inFromClient.readObject();
					model.editHotel(input4);
					break;
				case 5:
					int input5 = (int) inFromClient.readObject();
					model.deleteHotel(input5);
					break;
				case 6:
					String[] input6 = (String[]) inFromClient.readObject();
					send(model.searchHotel(input6));
					break;
				case 7:
					String[] input7 = (String[]) inFromClient.readObject();
					model.reserve(input7);
					break;
				case 8:
					String[] input8 = (String[]) inFromClient.readObject();
					model.addReview(input8);
					break;
				case 9:
					int input9 = (int) inFromClient.readObject();
					send(model.getReviews(input9));
					break;
				case 10:
					int input10 = (int) inFromClient.readObject();
					send(model.getReservations(input10));
					break;
				case 11:
					int input11 = (int) inFromClient.readObject();
					model.cancelReservation(input11);
					break;
				case 12:
					String[] input12 = (String[]) inFromClient.readObject();
					send(model.getInterestPoints(input12));
					break;
				case 13:
					String[] input13 = (String[]) inFromClient.readObject();
					send(model.getDirections(input13));
					break;
				case 14:
					int input14 = (int) inFromClient.readObject();
					send(model.getUserReviews(input14));
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
