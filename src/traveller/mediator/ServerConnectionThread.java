package traveller.mediator;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnectionThread extends Thread
{
   private static final int PORT = 2910;
   private TravellerModel model;
   
   public ServerConnectionThread (TravellerModel model)
   {
      this.model = model;
   }
   
   public void run ()
   {
      try
      {
         System.out.println("Starting server...");
         ServerSocket welcomeSocket = new ServerSocket(PORT);
         while (true)
         {
            System.out.println("Waiting for a client...");
            Socket connectionSocket = welcomeSocket.accept();
            ServerCommunicationThread communicationThread = new ServerCommunicationThread(connectionSocket, model);
            communicationThread.start();
            System.out.println("Connected");
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}
