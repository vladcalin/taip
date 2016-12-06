package Iterator;
import java.util.*;

import Mediator.User;

public class SecretSharingIterator {

   public static void combineSubsecrets(ArrayList<User> users) {
   
      System.out.print("Subsecrets of users: ");
      Iterator i = users.iterator();
      
      while(i.hasNext()) {
         Object userObj = i.next();
         User user = (User) userObj;
         System.out.print(user.getSubsecret() + " ");
      }  
   }  
}
   