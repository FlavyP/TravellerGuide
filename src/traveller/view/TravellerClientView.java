package traveller.view;

import java.util.Observer;


public interface TravellerClientView extends Observer
{
   public void start(TravellerClientController controller);
   public void show(String value);
   public String get(String what);
}
