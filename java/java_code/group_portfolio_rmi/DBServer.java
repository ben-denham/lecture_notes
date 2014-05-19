import java.rmi.*;

class DBServer {

    public static void main(String[] args) {
	try {
	    PlayerDB playerDB = new PlayerDB();
	    Naming.rebind("PlayerDB", playerDB);
	}
	catch (Exception ex) {
	    System.out.println(ex);
	}
    }

}
