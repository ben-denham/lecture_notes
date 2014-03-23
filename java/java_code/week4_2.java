import java.util.*;

class Customer {

    String ccode;
    String name;
    Employee employee;

    public Customer(String ccode, String name, Employee employee) {
	this.ccode = ccode;
	this.name = name;
	this.employee = employee;
    }

    public void print() {
	System.out.println("Customer: " + ccode + " - " + name);
    }

}

class Employee {

    String ecode;
    String firstName;
    String lastName;
    Hashtable<String, Customer> customers;
    //Vector<Customer> customers;

    public Employee(String ecode, String firstName, String lastName) {
	this.ecode = ecode;
	this.firstName = firstName;
	this.lastName = lastName;
	customers = new Hashtable<String, Customer>();
	//customers = new Vector<Customer>();
    }

    public void createCustomer(String ccode, String name) {
	customers.put(ccode, new Customer(ccode, name, this));
	//customers.add(new Customer(ccode, name, this));
    }

    public void listCustomers() {
	/*
	// Collection is slower than Enumeration, but safer when multithreading.
	for (Customer customer : customers.values()) {
	    customer.print();
	}
	*/
	Customer customer;
	Enumeration<Customer> customersEnum = customers.elements();
	while (customersEnum.hasMoreElements()) {
	    customer = customersEnum.nextElement();
	    customer.print();
	}
	/*
	// Alternative approach, so that we have access to each key.
	String ccode;
	Enumeration<String> ccodes = customers.keys();
	while (ccodes.hasMoreElements()) {
	    ccode = ccodes.nextElement();
	    customer = customers.get(ccode);
	    customer.print();
	}
	*/
	/*
	// For a Vector.
	int size = customers.size();
	for (int i = 0; i < size; i++) {
	    customer = customers[i];
	    customer.print();
	}
	 */
    }

    public void print() {
	System.out.println("Employee: " + ecode + " - " + firstName + " " + lastName);
    }

}

class Customers extends Hashtable<String, Customer> {

}

class Tester {

    public static void main(String[] args) {
	// Use of arrays.
	String[] ecode = {"E1001", "E1002", "E1003"};
	String[] firstName = {"John", "Eric", "Michael"};
	String[] lastName = {"Cleese", "Idle", "Palin"};

	Employee[] employees = new Employee[3];
	for(int i = 0; i < employees.length; i++) {
	    employees[i] = new Employee(ecode[i], firstName[i], lastName[i]);
	}

	for(int i = 0; i < employees.length; i++) {
	    employees[i].print();
	}

	// Demonstrate customers in employee.
	Employee e = new Employee("E1001", "Ben", "Denham");
	e.print();
	e.createCustomer("C1001", "Datacom");
	e.createCustomer("C1002", "Telecom");
	e.listCustomers();

	// Demonstrate extended Hashtable with set generics.
	Customers test = new Customers();
	test.put("abc", new Customer("123", "a", e));
	Customer c = test.get("abc");
	c.print();
    }

}
