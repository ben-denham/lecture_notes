import java.util.Vector;

class VectorPrinter {

    public static void print(Object[] a) {
	for (Object e : a) {
	    try {
		Object[] ea = (Object[]) e;
		print(ea);
	    }
	    catch (Exception ex) {
		System.out.println(e);
	    }
	}
    }

    public static void main(String[] args) {
	Object[] inner_inner_array = { 4 };
	Object[] inner_array = { 3, inner_inner_array, 5 };
	Object[] array = { 1, 2, inner_array, 6 };
	print(array);
    }

}
