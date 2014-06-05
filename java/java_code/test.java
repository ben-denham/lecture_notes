interface Beast {
    public void bite();
}

abstract class Animal implements Beast {

    String name;

    public Animal() {
	name = "Brumbie";
    }

    public abstract void eat();

    public void sleep() {
	System.out.println("Animal..sleep");
    }
    public void prt() {
	System.out.println(name);
    }

}

class Cow extends Animal {

    public Cow() {
	name = "butterCup";
    }

    public void eat() {
	System.out.println("Cow..eat");
    }

    public void bite() {
	System.out.println("Cow..bite");
    }

}

class Tester {

    public static void main(String[] args) {
	Animal a = new Cow();
	a.eat();
	a.sleep();
	a.bite();
	a.prt();
    }

}
