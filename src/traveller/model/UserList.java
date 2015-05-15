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
}
