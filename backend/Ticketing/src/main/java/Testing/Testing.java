package Testing;

import com.example.demo.controller.Bus;
import com.example.demo.controller.CreditCard;
import com.example.demo.controller.CurrentJourney;
import com.example.demo.controller.LocalPassenger;

public class Testing 
{
	
	
	public Bus busTest;
	public CurrentJourney CJTest;
	public LocalPassenger LPTest;
    public Testing()
    {
    	busTest = new Bus("T001",35,"Malabe-Kaduwela");
    	CJTest = new CurrentJourney("T001","TUser","card");
    	LPTest = new LocalPassenger("TUser","4765746V",200,"Kandy","1996-05-05","test","TUser@gmail.com");
    }
    
//-------------------------------------------------------------------------------------
    public void createBus()
    {
    	assertCheck(busTest.create("T001",35,"Malabe-Kaduwela") == true);
        System.out.println("Create Bus Test Successful");
    }
    
    public void checkBusID()
    {
    	assertCheck(busTest.getBusId("T001") == true);
    	assertCheck(busTest.getBusId("T005") == false);
        System.out.println("Check Bus Test Successful");
    }
    
    public void checkBusSeats()
    {
    	assertCheck(busTest.getBusSeats("T001") == 35);
    	assertCheck(busTest.getBusSeats("T005") == -1);
        System.out.println("Check Bus Test Successful");
    }
    
    
//-------------------------------------------------------------------------------------
    public void addToJourney()
    {
    	assertCheck(CJTest.addNewUserToJourney("T001","TUser2","card") == true);
        System.out.println("add To Journey Test Successful");
    }
    
    public void deleteJourney()
    {
    	assertCheck(CJTest.deleteOneJourney("TUser2") == true);
    	assertCheck(CJTest.deleteOneJourney("TUser2") == false);
        System.out.println("delete Journey Test Successful");
    }
    
    
  //-------------------------------------------------------------------------------------
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * To avoid passing -ea in VM arguments
    */
    public void assertCheck(boolean bool)
    {
        if(!bool)
        {
            //Getting the calling methods name from stacktrace
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            StackTraceElement e = stacktrace[2];
            String methodName = e.getMethodName();
            
            
            System.err.println("Assertion Fail in "+methodName);
            System.exit(-1);
        }
    }
    
    public static void main(String[] args)
    {
        new Testing();
    }

}
