package traveller.mediator;

import java.io.IOException;
import java.io.ObjectInputStream;

public class ClientRecieverThread extends Thread
{
   private ObjectInputStream in;
   private TravellerModel model;
   private String answer;

   public ClientRecieverThread(ObjectInputStream in, TravellerModel model)
         throws IOException
   {
      this.in = in;
      this.model = model;
   }

   public void run()
   {
      while (true)
      {
         try
         {
            answer = (String) in.readObject();
            model.showAnswer(answer);
         }
         catch (Exception e)
         {
            e.printStackTrace();
            break;
         }
      }
   }
}