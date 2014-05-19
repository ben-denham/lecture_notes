import java.rmi.*;

public class EmployeeClient {

    public static void main (String[] s) {
	try {
	    Remote r = Naming.lookup("rmi://127.0.0.1/EmployeeService");
	    EmployeeIntf e = (EmployeeIntf) r;
	    System.out.println(e.work(s[0],s[1]));
	} catch (Exception e) {
	    e.printStackTrace();
	} 
    }
}
