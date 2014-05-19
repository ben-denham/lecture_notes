import java.rmi.*;

class AppServer {

    public static void main(String[] args) {
	try {
	    PlayerApp playerApp = new PlayerApp();
	    Naming.rebind("PlayerApp", playerApp);
	}
	catch (Exception ex) {
	    System.out.println(ex);
	}
    }

}
