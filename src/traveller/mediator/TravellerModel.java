package traveller.mediator;

public interface TravellerModel {
	public String[] login(String[] input);
	public void addHotel(String[] hotel);
	public String[] getHotelInfo(int input);
	public void editHotel(String[] input);
	public void deleteHotel(int hotelId);
	public String[][] searchHotel(String[] input);
	public void reserve(String[] input);
	public void addReview(String[] input);
	public String[] getReviews(int input);
	public String[][] getReservations(int input);
	public void cancelReservation(int input);
	public String[][] getInterestPoints(String[] input);
	public String getDirections(String[] input);
	public String[][] getUserReviews(int input);
	public void cancelReview(int input);
	public void addUser(String[] input);
}
