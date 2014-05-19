import java.rmi.*;

class TennisDatabaseServer {

    public static void main(String[] args) {
	try {
	    RemoteDatabase tennisDb = new TennisDatabase();
	    Naming.rebind("TennisDatabase", tennisDb);
	} catch (Exception e) {}
    }

}
