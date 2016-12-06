package Mediator;
import java.util.ArrayList;
import Iterator.SecretSharingIterator;

public class SecretSharingChatRoom {
	 public static void main(String[] args) {
	      User mihai = new User("Mihai");
	      User nicu = new User("Nicu");
	      mihai.setSubsecret("subsecretMihai");
	      nicu.setSubsecret("subsecretNicu");
	      
	      mihai.sendMessage("Subsecretul meu este: " + mihai.getSubsecret());
	      nicu.sendMessage("Subsecretul meu este: " + nicu.getSubsecret());
	      
	      ArrayList<User> users = new ArrayList();
	      users.add(mihai);
	      users.add(nicu);
	         
	      SecretSharingIterator subsecrets = new SecretSharingIterator();
	      subsecrets.combineSubsecrets(users);	      
	      
	   }
}
