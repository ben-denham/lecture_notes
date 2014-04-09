class Mathematics {

    // The value of a final attribute cannot be changed.
    public final float pi = 3.14f;

    public void m1() {
	// Final value cannot be changed.
	// pi = 5f;
    }

    // Final method cannot be overridden.
    public final int sum(int x, int y) {
	return x + y;
    }

}

// A final class cannot be extended.
final class Calculus extends Mathematics {

    public void m2() {
	// Final value cannot be changed.
	// pi = 7f;
    }

    // Final method cannot be overridden.
    /*
    public int sum(int x, int y) {
	return x + y + 1;
    }
    */

}


// A final class cannot be extended.
/*
class Algebra extends Calculus {

}
*/

class Tester {

    public static void main(String[] args) {
	Calculus c = new Calculus();

	// Final value cannot be changed.
	// c.pi = 4;

	System.out.println(c.pi);
	System.out.println(c.sum(2, 2));
    }

}
