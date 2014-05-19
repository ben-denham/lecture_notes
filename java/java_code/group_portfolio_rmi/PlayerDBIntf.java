import java.rmi.*;

interface PlayerDBIntf extends Remote {
    public void world() throws RemoteException;
}
