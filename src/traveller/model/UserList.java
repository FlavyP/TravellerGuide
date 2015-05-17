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
}
