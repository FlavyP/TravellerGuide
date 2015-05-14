package traveller.controller;

import traveller.mediator.TravellerModel;

public class TravellerClientController {
       private TravellerModel model;
       private TravellerClientView view;
       
 public TravellerClientController(TravellerModel model, TravellerClientView view )
 {
	 this.model = model;
	 this.view = view;
 }
       

}
