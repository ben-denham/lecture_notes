import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;
import java.util.Vector;

class PlayerService extends UnicastRemoteObject implements PlayerRemote {

    private RemoteDatabase tennisDb;

    public PlayerService() throws RemoteException {
	super();
    }

    public Player get(int id) throws RemoteException {
	try {
	    if (tennisDb == null) {
		Remote remote = Naming.lookup("rmi://127.0.0.1/TennisDatabase");
		tennisDb = (RemoteDatabase) remote;
	    }
	    Vector result = tennisDb.query("select name, town from players where playerno=" + id);
	    if (result.elementAt(0) != null) {
		Vector playerRow = (Vector) result.elementAt(0);
		return new Player(id, (String) playerRow.elementAt(0), (String) playerRow.elementAt(1));
	    }
	} catch (Exception e) {
	    System.out.println(e);
	}
	return new Player();
    }

}
