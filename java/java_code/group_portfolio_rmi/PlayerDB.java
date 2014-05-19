import java.rmi.*;
import java.rmi.server.*;

class PlayerDB extends UnicastRemoteObject implements PlayerDBIntf {

    public PlayerDB() throws RemoteException {
	super();
    }

    public void world() throws RemoteException {
	System.out.println("world");
    }

}
