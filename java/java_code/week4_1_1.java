import java.util.*;

abstract class Person {

    abstract public void prt();

}

class Customer extends Person {

    String id;
    String name;

    public Customer(String id, String name) {
	this.id = "C" + id;
	this.name = name;
    }

    public void prt() {
	System.out.println("Customer: " + id + " - " + name);
    }

}

class Employee extends Person {

    String id;

    public Employee(String id) {
	this.id = "E" + id;
    }

    public void prt() {
	System.out.println("Employee: " + id);
    }

}

class Tester {

    public static void main(String[] args) {
	String[] ccode = {"1001", "1002", "1003"};
	String[] cname = {"Sam", "Mona", "Mark"};

	Customer c = null;
	Hashtable h = new Hashtable();
	// Hashtable<String, Person> h = new Hashtable<String, Person>();
	
	// Store customers in the Hashtable.
	for (int i=0; i < ccode.length; i++) {
	    c = new Customer(ccode[i], cname[i]);
	    h.put(ccode[i], c);
	}

	// Retrieve customers from the Hashtable.
	for (int i=0; i < ccode.length; i++) {
	    c = (Customer) h.get(ccode[i]);
	    c.prt();
	}

	System.out.println("-----------------------------");

	Enumeration en = h.keys();
	String code;
	while (en.hasMoreElements()) {
	    code = (String) en.nextElement();
	    c = (Customer) h.get(code);
	    c.prt();
	}

	System.out.println("-----------------------------");

	en = h.elements();
	while (en.hasMoreElements()) {
	    c = (Customer) en.nextElement();
	    c.prt();
	}
    }

}
