import java.rmi.*;

interface PlayerAppIntf extends Remote {
    void hello() throws RemoteException;
}
