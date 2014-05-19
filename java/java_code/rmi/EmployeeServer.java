import java.rmi.*;
import java.net.*;

public class EmployeeServer {

    public static void main(String[] s) {
	try {
	    Employee e = new Employee();
	    Naming.rebind("EmployeeService",e);
	} catch (Exception e) {}
    }

}
