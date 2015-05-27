package traveller.model;

/**
* A class representing a hotel.
* @author Flavian Popa
* @author Gytis Kuosaitis
* @author Julius Jurgauskas
* @author Mihaela Diaconescu
* @version 1.0
*/

public class Review {
	private int grade;
	private String comment;
	private int revId;
	private User user;
	private Hotel hotel;
	
	/**
	   * Five-argument constructor.
	   * @param revId reservation's id
	   * @param user user's object
	   * @param hotel hotel's object
	   * @param grade given grade of review
	   * @param comment review's comment
	   */

	public Review(int revId, User user, Hotel hotel, int grade, String comment) {
		this.grade = grade;
		this.comment = comment;
		this.revId = revId;
		this.user = user;
		this.hotel = hotel;
	}
   /**
   * Gets the review's grade.
   * @return the review's grade.
   */
	public int getGrade() {
		return grade;
	}
   /**
   * Sets the grade.
   * @param grade what the review grade will be
   */
	public void setGrade(int grade) {
		this.grade = grade;
	}
	/**
   * Gets the review's comment.
   * @return the review's comment.
	*/
	public String getComment() {
		return comment;
	}
   /**
   * Sets the comment.
   * @param comment what the review comment will be
   */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
   * Gets the reservation's id.
   * @return the reservation's id.
   */
	public int getRevId() {
		return revId;
	}
   /**
   * Sets the reservation id.
   * @param revId what reservation id you assign
   */
	public void setRevId(int revId) {
		this.revId = revId;
	}
   /**
   * Gets the user.
   * @return the user's object.
   */
	public User getUser() {
		return user;
	}
   /**
   * Sets the user object.
   * @param user which object you assign to user
   */
	public void setUser(User user) {
		this.user = user;
	}
   /**
   * Gets the hotel.
   * @return the hotel's object.
   */
	public Hotel getHotel() {
		return hotel;
	}
   /**
   * Sets the hotel object.
   * @param hotel which object you assign to hotel
   */
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String toString() {
		return "User: " + user.getName() + "; Hotel: " + hotel.getName()
				+ "; Grade: " + grade + "; Comment: " + comment;
	}

}
