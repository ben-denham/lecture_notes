import java.rmi.*;

class Client {

    public static void main(String[] args) {
	try {
	    Remote remote = Naming.lookup("rmi://127.0.0.1/PlayerApp");
	    PlayerAppIntf playerApp = (PlayerAppIntf) remote;
	    playerApp.hello();
	}
	catch (Exception ex) {
	    System.out.println(ex);
	}
    }

}
