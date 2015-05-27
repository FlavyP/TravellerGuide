package traveller.model;

import java.util.ArrayList;

/**
 * A class representing reservation list.
 * @author Flavian Popa
 * @author Gytis Kuosaitis
 * @author Julius Jurgauskas
 * @author Mihaela Diaconescu
 * @version 1.0
 */

public class UserList
{
   private ArrayList<User> userList;
   
   /**
   * No-argument constructor
   */
   public UserList()
   {
      userList = new ArrayList<User>();
   }
   /**
    * Adds user to user list
    * @param user what user will be added
    */
   public void addUser(User user)
   {
      userList.add(user);
   }
   /**
    * Gets user
    * @param index which user will be selected
    * @return user by selected index
    */
   public User getUser(int index)
   {
      return userList.get(index);
   }
   /**
    * Gets the user list size
    * @return the user list size
    */
   public int size(){
	   return userList.size();
   }
   
   
   public String toString()
   {
      String msg = "";
      for (int i = 0; i < userList.size(); i++)
      {
         msg += userList.get(i).getUserId() + " " + userList.get(i).getName()
               + " " + userList.get(i).getEmail() + " "
               + userList.get(i).getAddress() + " "
               + userList.get(i).getPhoneNumber() + " "
               + userList.get(i).getPassword();

      }
      
      return msg;
   }
   
   public User getUser(String email, String password){
	   for(int i=0;i<userList.size();i++){
		   if(userList.get(i).getEmail().equals(email) && userList.get(i).getPassword().equals(password))
			   return userList.get(i);
	   }
	   return null;
   }
}
