package traveller.view;

import java.util.Observable;
import java.util.Scanner;

import traveller.controller.TravellerClientController;
import traveller.controller.TravellerController;

public class TravellerClientConsole implements TravellerClientView
{

   private Scanner in;
   
   public TravellerClientConsole()
   {
      in = new Scanner(System.in);
   }
   @Override
   public void start(TravellerClientController controller)
   {
      int menuSelection;
      do {
         menuSelection = menu();
         switch (menuSelection) {
         case 1:
            controller.execute("addHotel");
            break;
         case 2:
             controller.execute("searchHotelByCity");
             break;
         case 3:
             controller.execute("searchHotelByAddress");
             break;
         case 4:
             controller.execute("reserve");
             break;
         case 5:
          controller.execute("showHotels");
         default:
            break;
         }
         show("\nPress ENTER to continue...");
         in.nextLine();
      } while (menuSelection != 6);
   }

   public void show(String value) {
      System.out.println(value);
   }

   public String get(String what) {
      show("Please enter: " + what + ": ");
      String input = in.nextLine();
      return input;
   }

   private int menu()
   {
      show("TravellerGuide Application");
      show("--------------");
      show("1) Add hotel");
      show("2) Search for hotel by city");
      show("3) Search for hotel by address");
      show("4) Reserve");
      show("5) Show all hotels");
      show("6) Quit");
      show("");
      show("Select an item 1-6: ");
      int selection = in.nextInt();
      in.nextLine();
      return selection;
   }
   
    
   public void start(TravellerController controller) {
      int menuSelection;
      do {
         menuSelection = menu();
         switch (menuSelection) {
         case 1:
            controller.execute("addHotel");
            break;
         case 2:
             controller.execute("searchHotelByCity");
             break;
         case 3:
             controller.execute("searchHotelByAddress");
             break;
         case 4:
             controller.execute("reserve");
             break;
         case 5:
          controller.execute("showHotels");
         default:
            break;
         }
         show("\nPress ENTER to continue...");
         in.nextLine();
      } while (menuSelection != 6);
   }
   
   @Override
   public void update(Observable o, Object arg)
   {
      show((String) arg);  
   }

}
