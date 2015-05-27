package traveller.model;

/**
* A class representing a hotel.
* @author Flavian Popa
* @author Gytis Kuosaitis
* @author Julius Jurgauskas
* @author Mihaela Diaconescu
* @version 1.0
*/

public class User {
	
	private String name;
	private String email;
	private String phoneNumber;
	private String address;
	private String password;
	private boolean isGuest;
	private int userId;
	
   /**
    * Seven-argument constructor.
    * @param userId user's id
    * @param name user's name
    * @param email user's email
    * @param phoneNumber user's phone number
    * @param address user's address
    * @param isGuest user's type member/admin
    * @param password user's password
    */
	
	public User(int userId, String name,String email,String phoneNumber,String address,boolean isGuest, String password)
	{
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.isGuest = isGuest;
		this.userId = userId;
		this.password = password;
	}
   /**
   * Gets the user's name.
   * @return the user's name.
   */
   public String getName() {
		return name;
	}
   /**
   * Sets the user name.
   * @param name what name will be assigned to user.
   */
	public void setName(String name) {
		this.name = name;
	}
   /**
   * Gets the user's email.
   * @return the user's email.
   */	
	public String getEmail() {
		return email;
	}
   /**
   * Sets the user email.
   * @param email what email will be assigned to user.
   */
	public void setEmail(String email) {
		this.email = email;
	}
   /**
   * Gets the user's phone number.
   * @return the user's phone number.
   */ 
	public String getPhoneNumber() {
		return phoneNumber;
	}
   /**
   * Sets the user phone number.
   * @param phoneNumber what phone number will be assigned to user.
   */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
   /**
   * Gets the user's address.
   * @return the user's address.
   */ 
	public String getAddress() {
		return address;
	}
   /**
   * Sets the user address.
   * @param address what address will be assigned to user.
   */
	public void setAddress(String address) {
		this.address = address;
	}
   /**
   * Gets the user's type.
   * @return the user's type.
   */ 
	public boolean isGuest() {
		return isGuest;
	}
   /**
   * Sets the user type.
   * @param isGuest which type will be assigned to user.
   */
	public void setGuest(boolean isGuest) {
		this.isGuest = isGuest;
	}
   /**
   * Gets the user's id.
   * @return the user's id.
   */ 
   public int getUserId()
   {
      return userId;
   }
   /**
   * Sets the user id.
   * @param userId what user id will be assigned to user.
   */
   public void setUserId(int userId)
   {
      this.userId = userId;
   }
   /**
   * Gets the user's password.
   * @return the user's password.
   */ 
   public String getPassword()
   {
      return password;
   }
   /**
   * Sets the user password.
   * @param password what password will be assigned to user.
   */
   public void setPassword(String password)
   {
      this.password = password;
   }
	
   

}
