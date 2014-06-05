import java.util.Vector;

interface Observer {
    void notifyObserver();
}

abstract class Observable {

    private Vector<Observer> observers;

    public Observable() {
	observers = new Vector<Observer>();
    }

    public void addObserver(Observer o) {
	observers.add(o);
    }

    public void removeObserver(Observer o) {
	if (observers.contains(o)) {
	    observers.remove(o);
	}
    }

    public void notifyObservers() {
	for (Observer o : observers) {
	    o.notifyObserver();
	}
    }

}

class ConcreteObservable extends Observable {

}

class ConcreteObserver implements Observer {

    public void notifyObserver() {
	System.out.println("Observation successful!");
    }

}

class Tester {

    public static void main(String[] args) {
	Observable o1 = new ConcreteObservable();
	Observer o2 = new ConcreteObserver();
	o1.addObserver(o2);
	o1.notifyObservers();
	o1.removeObserver(o2);
    }

}
