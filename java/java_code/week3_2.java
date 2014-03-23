import java.util.*;

class M {
    private int id;

    public M(int id) {
	this.id = id;
    }

    public int getId() {
	return id;
    }

    public String m1() {
	return "M .. m1 .. " + getId();
    }
}

class Invoice extends M {

    private static int nextId = 1;

    public Invoice() {
	super(nextId++);
    }

    public String m1() {
	return "Invoice .. m1 .. " + getId();
    }

}

class Employee extends M {
    private static int nextId = 1;

    public Employee() {
	super(nextId++);
    }

    public String m1() {
	return "Employee .. m1 .. " + getId();
    }

}

class Other extends M {
    private static int nextId = 1;

    public Other() {
	super(nextId++);
    }

    public String m1() {
	return "Other .. m1 .. " + getId();
    }

}

class Tester {

    public static void main(String[] args) {
	Vector<M> v = new Vector<M>();
	v.add(new Employee());
	v.add(new Employee());
	v.add(new Invoice());
	v.add(new Other());
	v.add(new Other());
	v.add(new Invoice());
	v.add(new Employee());

	/*
	int length = v.size();
	for (int i = 0; i < length; i++) {
	    M m = v.get(i);
	    System.out.println(m.m1());
	}
	*/

	for (M m : v) {
	    System.out.println(m.m1());
	}
    }

}
