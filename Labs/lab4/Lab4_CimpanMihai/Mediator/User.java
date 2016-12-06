package Mediator;
public class User {
   private String userName;
   private String subSecret;

   public String getName() {
      return userName;
   }

   public void setName(String userName) {
      this.userName = userName;
   }
   
   public void setSubsecret(String subSecret)
   {
	   this.subSecret = subSecret;
   }
   
   public String getSubsecret()
   {
	   return subSecret;
   }

   public User(String userName){
      this.userName  = userName;
   }
   
   

   public void sendMessage(String message){
      ChatRoom.showMessage(this,message);
   }
}