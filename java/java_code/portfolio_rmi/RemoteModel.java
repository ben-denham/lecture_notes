import java.rmi.*;

interface PlayerRemote extends Remote {

    Player get(int id) throws RemoteException;

}
