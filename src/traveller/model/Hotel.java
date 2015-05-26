package traveller.model;

	/**
	* A class representing a hotel.
	* @author Flavian Popa
	* @author Gytis Kuosaitis
	* @author Julius Jurgauskas
	* @author Mihaela Diaconescu
	* @version 1.0
	*/

public class Hotel {
	private RoomList roomList;
	private String name;
	private String address;
	private String city;
	private int hotelId;
	private ReviewList rl;
	
	/**
	* Twelve-argument constructor.
	* @param hotelId hotel's id
	* @param name hotel's name
	* @param city hotel's city
	* @param address hotel's address
	* @param numberOfSingleRooms hotel's number of single rooms
	* @param singleRoomPrice hotel's price of single rooms
	* @param numberOfDoubleRooms hotel's number of double rooms
	* @param doubleRoomPrice hotel's price of double rooms
	* @param numberOfTripleRooms hotel's number of triple rooms
	* @param tripleRoomPrice hotel's price of triple rooms
	* @param numberOfApartments hotel's number of apartments
	* @param apartmentPrice hotel's price of apartments
	*/
	public Hotel(int hotelId, String name, String city, String address,
			int numberOfSingleRooms, double singleRoomPrice,
			int numberOfDoubleRooms, double doubleRoomPrice,
			int numberOfTripleRooms, double tripleRoomPrice,
			int numberOfApartments, double apartmentPrice) {
		this.hotelId = hotelId;
		this.name = name;
		this.address = address;
		this.city = city;
		// roomList = new RoomList(numberOfSingleRooms, numberOfDoubleRooms,
		// numberOfTripleRooms, numberOfApartments);
		roomList = new RoomList();
		roomList.setPriceOfRooms(0, singleRoomPrice);
		roomList.setPriceOfRooms(1, doubleRoomPrice);
		roomList.setPriceOfRooms(2, tripleRoomPrice);
		roomList.setPriceOfRooms(3, apartmentPrice);
		roomList.addRooms(numberOfSingleRooms, numberOfDoubleRooms,
				numberOfTripleRooms, numberOfApartments);
		rl = new ReviewList();

		/*
		 * roomList.setNumberOfRooms(numberOfSingleRooms, 0);
		 * roomList.setNumberOfRooms(numberOfDoubleRooms, 1);
		 * roomList.setNumberOfRooms(numberOfTripleRooms, 2);
		 * roomList.setNumberOfRooms(numberOfApartments, 3);
		 */
	}
	/**
	* Gets the hotel's name.
	* @return the hotel's name.
	*/
	public String getName() {
		return name;
	}
	/**
	* Sets the hotel's name.
	* @param name what the hotel's name will be set to
	*/
	public void setName(String name) {
		this.name = name;
	}
	/**
	* Gets the hotel's address.
	* @return the hotel's address.
	*/
	public String getAddress() {
		return address;
	}
	/**
	* Sets the hotel's address.
	* @param address what the hotel's address will be set to
	*/
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	* Gets the hotel's city.
	* @return the hotel's city.
	*/
	public String getCity() {
		return city;
	}
	/**
	* Sets the hotel's city.
	* @param address what the hotel's city will be set to
	*/
	public void setCity(String city) {
		this.city = city;
	}
	/**
	* Gets the hotel's number of rooms.
	* @param idx at what index get number of rooms
	* @return the hotel's number of rooms at index.
	*/
	public int getNumberOfRooms(int idx) {
		return roomList.getNumberOfRooms(idx);
	}

	/**
	 * Gets the hotel's price of rooms.
	 * @param idx at what index get price of rooms
	 * @return the hotel's price of rooms at index.
	 */
	public double getPriceOfRooms(int idx) {
		return roomList.getPriceOfRooms(idx);
	}

	/**
	 * Sets the hotel's price of rooms
	 * @param idx at what index set price of rooms
	 * @param price what price will be set to
	 */
	public void setPriceOfRooms(int idx, double price) {
		roomList.setPriceOfRooms(idx, price);
	}

	/**
	 * Gets the hotel's room's Id
	 * @param index what index to get room Id
	 * @return the hotel's room's Id at index
	 */
	public int getRoomId(int index) {
		return roomList.getId(index);
	}

	/**
	 * Gets first available single room in the hotel
	 * @return first available single room in the hotel
	 */
	public Room getfirstAvailableSingleRoom() {
		return roomList.getFirstSingleRoom();
	}
	
	/**
	 * Gets first available double room in the hotel
	 * @return first available double room in the hotel
	 */
	public Room getfirstAvailableDoubleRoom() {
		return roomList.getFirstDoubleRoom();
	}
	/**
	 * Gets first available triple room in the hotel
	 * @return first available triple room in the hotel
	 */
	public Room getfirstAvailableTripleRoom() {
		return roomList.getFirstTripleRoom();
	}
	/**
	 * Gets first available apartment in the hotel
	 * @return first available apartment in the hotel
	 */
	public Room getfirstAvailableApartment() {
		return roomList.getFirstApartment();
	}
	
	/**
	 * Gets the hotel's Id
	 * @return the hotel's Id
	 */
	public int getHotelId() {
		return hotelId;
	}

	/**
	 * Sets the hotel's Id
	 * @param hotelId what the hotel's Id will be set to
	 */
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	/**
	 * Gets the hotel's review list
	 * @return the hotel's review list
	 */
	public ReviewList getRl() {
		return rl;
	}

	/**
	 * Sets the hotel's review list
	 * @param rl what the hotel's review list will be set to
	 */
	public void setRl(ReviewList rl) {
		this.rl = rl;
	}

	/**
	 * Sets the hotel's room availability
	 * @param r what room availability will be set to
	 * @param isAv what availability will be set to
	 * @param checkIn what check in date will be set to
	 * @param checkOut what check out date will be set to
	 */
	public void setAvailability(Room r, boolean isAv, MyDate checkIn,
			MyDate checkOut) {
		roomList.setAvailability(r, isAv, checkIn, checkOut);
	}

	/**
	 * Marks free rooms in the hotel
	 */
	public void markFreeRooms() {
		roomList.markFreeRooms();
	}

	/**
	 * Gets the hotel's room at index
	 * @param index what index to get room
	 * @return the hotel's room at index
	 */
	public Room getRoom(int index) {
		return roomList.getRoom(index);
	}

	public String toString() {
		return "ID: " + hotelId + "; Name: " + name + "; Address: " + address
				+ "; City: " + city + "\n" + "Number of Single Rooms: "
				+ roomList.getNumberOfRooms(0) + " Price of Single Rooms: "
				+ roomList.getPriceOfRooms(0) + "\n"
				+ "Number of Double Rooms: " + roomList.getNumberOfRooms(1)
				+ " Price of Double Rooms: " + roomList.getPriceOfRooms(1)
				+ "\n" + "Number of Triple Rooms: "
				+ roomList.getNumberOfRooms(2) + " Price of Triple Rooms: "
				+ roomList.getPriceOfRooms(2) + "\n" + "Number of Apartments: "
				+ roomList.getNumberOfRooms(3) + " Price of Apartments: "
				+ roomList.getPriceOfRooms(3) + "\n" + "Reviews: \n" + rl;
	}
}
