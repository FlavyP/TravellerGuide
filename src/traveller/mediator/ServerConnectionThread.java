package traveller.mediator;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnectionThread extends Thread
{
   private static final int PORT = 2910;
   private TravellerModelManager model;
   
   public ServerConnectionThread (TravellerModelManager model)
   {
      this.model = model;
   }
   
   public void run ()
   {
      try
      {
         ServerSocket welcomeSocket = new ServerSocket(PORT);
         while (true)
         {
            Socket connectionSocket = welcomeSocket.accept();
            ServerCommunicationThread communicationThread = new ServerCommunicationThread(connectionSocket, model);
            communicationThread.start();
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}
