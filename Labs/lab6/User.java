	
public class User {
	
	private String name;
	private String subsecret;
	private int id;
	
	public void setName(String n)
	{
		name = n;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setID(int idUser)
	{
		setId(idUser);
	}
	
	public void setSubsecret(String subsecret)
	{
		this.subsecret = subsecret;
	}
	
    public void sendSubsecret(int id)
    {
    	System.out.println("Subsecret " + this.subsecret + " was send");
    }
    
    public static void testMethod(String one, String two)
    {
    	
    }
    
    private int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}
	
	public static void main(String[] args) {
		User michael = new User();
		michael.setName("Michael");
		michael.setSubsecret("subsecretMichael");
		michael.setID(3);
		michael.sendSubsecret(michael.getId());
		testMethod("one", "two");
	}

	

}
