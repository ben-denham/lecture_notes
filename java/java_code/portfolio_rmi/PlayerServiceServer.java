import java.rmi.*;

class PlayerServiceServer {

    public static void main(String[] args) {
	try {
	    PlayerRemote playerService = new PlayerService();
	    Naming.rebind("PlayerService", playerService);
	} catch (Exception e) {}
    }

}
