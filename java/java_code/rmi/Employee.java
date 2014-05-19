import java.rmi.*;
import java.rmi.server.*;

public class Employee extends UnicastRemoteObject implements EmployeeIntf {

    public Employee() throws RemoteException {}

    public String work(String code, String name) throws RemoteException {
	System.out.println(code+","+name);
	return "Hello "+name;
    }
	
}
