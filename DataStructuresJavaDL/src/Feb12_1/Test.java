package Feb12_1;


public class Test {

	public int addEm(int ... a) {
		int total = 0;
		System.out.println(a.length + " Arguments passed");
		System.out.println("Variable args");
		for (int foo:a) {
			total += foo;
		}
		return total;
	}
	
	public int addEm(int a, int b, int c, int d) {
		System.out.println("four args");
		return a + b + c + d;
	}
	
	
}
