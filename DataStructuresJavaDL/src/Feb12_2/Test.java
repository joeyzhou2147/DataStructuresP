package Feb12_2;

public class Test<T> {

	


	public T addEm(T ... a) {
		
		T total = 0;
		for ( T foo:a) {
			total += foo;
		}
		return total;
	}

	public double addEm(double ... a) {
		
		double total = 0;
		for ( double foo:a) {
			total += foo;
		}
		return total;
	}

	public void test() {
		int[] array = new int[32];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = i * 2;
		}
		
		for (int j:array) {
			System.out.println(j);
			j = 23;
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.println(array[i]);
		}
	}
}
