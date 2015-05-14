package traveller.view;

import java.util.Observer;

import traveller.controller.TravellerClientController;


public interface TravellerClientView extends Observer
{
   public void start(TravellerClientController controller);
   public void show(String value);
   public String get(String what);
}
