class Tester {
    public static void main(String[] args) {
	Employee emp1 = new Manager();
	// Employee .. work
	emp1.work();
	// Employee .. pay
	emp1.pay();

	Employee emp2 = new Staff();
	// Employee .. pay
	emp2.pay();
	// Staff .. work
	emp2.work();

	// Causes compilation error (Private member not visible outside of class).
	//emp1.eat();

	// Causes compilation error (Not visible from superclass ref).
	//emp2.jobWork();

	// Causes compilation error (Subclass ref cannot point to superclass obj).
	// Staff emp3 = Employee();
    }
}

class Employee {
    public void work() {
	System.out.println("Employee .. work");
    }

    public void pay() {
	System.out.println("Employee .. pay");
    }

    private void eat() {
	System.out.println("Employee .. eat");
    }

    public void workPay() {
	System.out.println("Employee .. workPay");
	work();
	pay();
    }
}

class Staff extends Employee {
    public void work() {
	System.out.println("Staff .. work");
    }

    public void jobWork() {
	System.out.println("Staff .. jobWork");
    }
}

class Manager extends Employee {

}
