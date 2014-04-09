import java.util.*;

class Supervisor implements Observer {

    public void update(Observable observable, Object object) {
	System.out.println(String.format("Observer Supervisor .. update - %s", observable));
    }

}

class Worker extends Observable {

    public void call() {
	setChanged();
	notifyObservers();
    }

}

class Tester {

    public static void main (String[] args) {
	Supervisor s = new Supervisor();
	Worker w = new Worker();
	w.addObserver(s);
	w.call();
    }

}
