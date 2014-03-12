import java.util.*;

abstract class Person {

    abstract public void prt();

}

class Customer extends Person {

    String id;

    public Customer(String id) {
	this.id = "C" + id;
    }

    public void prt() {
	System.out.println("Customer: " + id);
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
	Vector v = new Vector();
	//Vector<Person> v = new Vector<Person>();

	Employee e = new Employee("1001");
	v.add(e);
	e = new Employee("1002");
	v.add(e);

	Customer c = new Customer("1001");
	v.add(c);

	System.out.println("Number of elements: " + v.size());

	int si = v.size();
	for (int i = 0; i < si; i++) {
	    /*
	    Object obj = v.elementAt(i);
	    if (obj instanceof Employee) {
		e = (Employee) obj;
		e.prt();
	    }
	    else if (obj instanceof Customer) {
		c = (Customer) obj;
		c.prt();
	    }
	    */

	    Person p = (Person) v.elementAt(i);

	    //Person p = v.elementAt(i);

	    p.prt();
	} 
    }

}
