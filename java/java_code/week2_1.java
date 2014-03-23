class Employee {

    public int ecode;
    public String fname;
    public String lname;
    public double salary;

    public Employee(int ecode, String fname, String lname, double salary) {
	System.out.println("Employee .. constructor");
	this.ecode = ecode;
	this.fname = fname;
	this.lname = lname;
	this.salary = salary;
    }

    public void pay() {
	System.out.println("Employee .. pay");
    }

    public String work() {
	System.out.println("Employee .. work");
	return ecode + ": " + fname + " " + lname + "\nSalary: $" + salary;
    }

}

class Staff extends Employee {

    public Staff(int ecode, String fname, String lname, double salary) {
	super(ecode, fname, lname, salary);
	System.out.println("Staff .. constructor");
    }

    // Note how this method overrides work() in Employee for Staff objects.
    public String work() {
	System.out.println("Staff .. work");
	return ecode + ": " + lname + ", " + fname + "\nSalary: $" + salary;
    }

}

class Manager extends Employee {

    public Manager(int ecode, String fname, String lname, double salary) {
	super(ecode, fname, lname, salary);
	System.out.println("Manager .. constructor");
    }

}

class Tester {
    public static void main(String[] args) {
	// Prints "Employee .. constructor" and "Staff .. constructor", as the constructor
	// is fired.
	Employee emp = new Staff(1001, "Ben", "Denham", 120000);
	testEmp(emp);

	// Prints "Employee .. constructor" and "Manager .. constructor", as the constructor
	// is fired.
	Employee mgr = new Manager(1001, "Ben", "Denham", 120000);
	testEmp(mgr);
    }

    public static void testEmp(Employee emp) {
	// Prints "{Class} .. work" as work() is fired. Also returns the employee
	// description, which we store in our local String variable: fullName.
	String description = emp.work();
	// Prints the description that we stored in the last line.
	System.out.println(description);
    }
}
