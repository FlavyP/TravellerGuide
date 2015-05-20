package traveller.mediator;

import java.io.IOException;
import java.io.ObjectInputStream;

public class ClientRecieverThread extends Thread {
	private ObjectInputStream in;
	private TravellerClientModelManager model;
	private String[] answer;

	public ClientRecieverThread(ObjectInputStream in,
			TravellerClientModelManager model) throws IOException {
		this.in = in;
		this.model = model;
	}

	public void run() {
		while (true) {
			try {
				answer = (String[]) in.readObject();
				switch (answer[0]) {
				case "1":
//					model.sendAnswerLogIn(answer);
					break;
				default:
					break;
				}
				

				// System.out.println(answer);
				// model.showAnswer(answer);
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}
}