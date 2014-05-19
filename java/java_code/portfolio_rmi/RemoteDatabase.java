import java.rmi.*;
import java.sql.*;
import java.util.Vector;

interface RemoteDatabase extends Remote {

    Vector query(String query) throws RemoteException;

}
