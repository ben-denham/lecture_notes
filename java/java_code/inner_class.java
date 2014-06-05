class Outer {

    public class Inner {

	private String name;

	public Inner(String name) {
	    this.name = name;
	}

	public void name() {
	    System.out.println(name);
	}

    }

}

class Tester {

    public static void main(String[] args) {
	Outer outer = new Outer();
	Outer.Inner inner = outer.new Inner("Ben");
	inner.name();

	/*
	public class Test {

	}
	*/
    }

}
