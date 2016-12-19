import java.text.SimpleDateFormat;
import java.util.Calendar;


public aspect Aspect {
	
	pointcut publicMethodExecuted(): execution(public * *(..));
	after(): publicMethodExecuted() {
	
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(Calendar.getInstance().getTime());
	    System.out.println("Method used at " + timeStamp + ": " + thisJoinPoint.getSignature());
	    
	    Object[] arguments = thisJoinPoint.getArgs();
	    if(arguments.length != 0)
	    {
	    	System.out.print("    with values: ");
	    }
	    for (int i = 0; i < arguments.length; i++){
	        Object argument = arguments[i];
	        if (argument != null){
	        	if(i != arguments.length - 1)
	        		System.out.print(argument + ", ");
	        	else 
	    	            System.out.print(argument + ". ");
	        }
	    }
	    System.out.println();
	}

	
	void around(): call(public void User.sendSubsecret(int)) {
		 Integer idMichael = new Integer(3);
		 Object[] arguments = thisJoinPoint.getArgs();
		 if(idMichael.equals((Integer) arguments[0]))
		 {
			 System.out.println("Identity was checked and is ok.");
			 proceed();
		 }
	}
	
}
