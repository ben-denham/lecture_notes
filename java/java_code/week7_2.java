class Employee {
    
    // Instance-level inner class.
    // Can't store an instance outside of the class.
    private class Job {
	
	public void m1() {
	    System.out.println("Inner class of Employee - Job .. m1");
	}

    }

    // Public Instance-level inner class.
    // Can't create an instance outside of the class.
    class Car {
	
	public void m6() {
	    System.out.println("Inner class of Employee - Car .. m6");
	}

    }

    // Public, static instance-level inner class (can be created from outside).
    // Can create and store instance outside of the class.
    static class Food {
	
	public void m5() {
	    System.out.println("Inner class of Employee - Food .. m5");
	}

    }

    public void m2() {
	Job j = new Job();
	j.m1();
    }

    public void m3() {
	Job j = new Job();
	j.m1();
    }

    public Car m4() {
	return new Car();
    }

    public void m7() {
	// Note, Pencil mut be declared in the method before creating an instance.
	// Otherwise, the operations are out of sequence.
	// Can't be accessed at all from outside the method.
	class Pencil {

	    public void m8() {
		System.out.println("Inner class of Employee m7 - Pencil .. m8");
	    }

	}
	Pencil p1 = new Pencil();
	p1.m8();
    }

}

class Tester {

    public static void main(String[] args) {
	Employee e1 = new Employee();
	e1.m2();
	e1.m3();
	e1.m7();
	Employee.Car c1 = e1.m4();
	c1.m6();
	Employee.Food f1 = new Employee.Food();
	f1.m5();
    }

}
