import java.rmi.*;

public interface EmployeeIntf extends Remote {
    public String work(String code, String name) throws RemoteException;
}
