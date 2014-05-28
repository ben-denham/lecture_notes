import java.util.Vector;

class Originator {

    private String state;

    public String getState() {
	return state;
    }
    public void setState(String state) {
	this.state = state;
    }

    public Memento saveState() {
	return new Memento(state);
    }
    public void restoreState(Memento memento) {
	state = memento.getState();
    }

}

class Memento {

    private String state;

    public Memento(String state) {
	this.state = state;
    }

    public String getState() {
	return state;
    }

}

class Caretaker {

    private Vector<Memento> mementos;

    public Caretaker() {
	mementos = new Vector<Memento>();
    }

    public void addMemento(Memento memento) {
	mementos.add(memento);
    }

    public Memento getMemento(int index) {
	return mementos.get(index);
    }

}

class Tester {

    public static void main(String[] args) {
	Originator o = new Originator();
	Caretaker c = new Caretaker();

	o.setState("A");
	c.addMemento(o.saveState());
	o.setState("B");
	o.restoreState(c.getMemento(0));
	System.out.println(o.getState());
    }

}
