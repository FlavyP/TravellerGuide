package traveller.mediator;

public class TravellerClientModelManager implements
		TravellerModel {

	private TravellerModelProxy proxy;
	private int userId;
	private String[] dataCopy;
	private String[][] tableCopy;

	public TravellerClientModelManager() {
		proxy = new TravellerModelProxy(this);
		this.userId = -1;
		this.dataCopy = null;
		this.tableCopy = null;
	}

	public void copy(String[] data) {
		this.dataCopy = data;
	}

	public void copy(String[][] table) {
		this.tableCopy = table;
	}

	public void copy(String[] data, String[][] table) {
		this.dataCopy = data;
		this.tableCopy = table;
	}

	public String[] getDataCopy() {
		return dataCopy;
	}

	public String[][] getTableCopy() {
		return tableCopy;
	}

	public void clearCopies() {
		this.dataCopy = null;
		this.tableCopy = null;
	}

	public String[] login(String[] input) {
		String[] answer = proxy.login(input);
		if(answer[0] == null){
			this.userId = -1;
		}
		else{
		this.userId = Integer.parseInt(answer[0]);
		}
		return answer;
	}

	public void addHotel(String[] input) {
		proxy.addHotel(input);
	}

	public String[] getHotelInfo(int input) {
		return proxy.getHotelInfo(input);
	}

	public void editHotel(String[] input) {
		proxy.editHotel(input);
	}

	public void deleteHotel(int hotelId) {
		proxy.deleteHotel(hotelId);
	}

	public String[][] searchHotel(String[] input) {
		return proxy.searchHotel(input);
	}

	public void reserve(String[] input) {
		proxy.reserve(input);
	}

	public void addReview(String[] input) {
		proxy.addReview(input);
	}

	public String[] getReviews(int input) {
		return proxy.getReviews(input);
	}

	public String[][] getReservations(int input) {
		return proxy.getReservations(input);
	}

	public void cancelReservation(int input) {
		proxy.cancelReservation(input);
	}

	public String[][] getInterestPoints(String[] input) {
		return proxy.getInterestPoints(input);
	}

	public String getDirections(String[] input) {
		return proxy.getDirections(input);
	}

	public String[][] getUserReviews(int input) {
		return proxy.getUserReviews(input);
	}
	public void cancelReview(int input){
		proxy.cancelReview(input);
	}

	public void addUser(String[] input) {
		proxy.addUser(input);
	}

	public int getUserId() {
		return this.userId;
	}
	public double totalPrice(String[] input){
		return proxy.totalPrice(input);
	}
	public boolean isBefore(String[] input){
	   return proxy.isBefore(input);
	}
}
