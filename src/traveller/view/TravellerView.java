package traveller.view;

import java.util.Observer;

import traveller.controller.TravellerController;

public interface TravellerView extends Observer
{
   public void start(TravellerController controller);
   public void show(String value);
   public String get(String what);
}
