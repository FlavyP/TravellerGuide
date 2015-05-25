package traveller.model;

import java.util.ArrayList;

public class UserList
{
   private ArrayList<User> userList;

   public UserList()
   {
      userList = new ArrayList<User>();
   }

   public void addUser(User user)
   {
      userList.add(user);
   }

   public User getUser(int index)
   {
      return userList.get(index);
   }
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
