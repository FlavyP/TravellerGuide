package traveller.view;

import java.util.Observable;
import java.util.Scanner;

import traveller.controller.TravellerController;

public class TravellerConsole implements TravellerView
{
   private Scanner in;
   
   public TravellerConsole()
   {
      in = new Scanner(System.in);
   }
   public void show(String value) {
      System.out.println(value);
   }

   public String get(String what) {
      show("Please enter: " + what + ": ");
      String input = in.nextLine();
      return input;
   }
   
   @Override
   public void start(TravellerController controller) {
      System.out.println("Testing the server..");
   }
   @Override
   public void update(Observable o, Object arg)
   {
      show((String) arg);  
   }
}
