package Mar26_1;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Driver me = new Driver();
		me.doIt();
	}
	
	public void doIt() {
		//System.out.println(fact(6));
		recurse(false, 1);
		
	}
	
	public int fact(int val) {
		System.out.println("We're here " + val);
		// BASE CASE
		if ((val == 0) || (val == 1))
			return 1;
		
		return val * fact(val-1);
	}
	
	
	public void recurse(boolean val1, int val2) {
		
		int val3;
		if (val2 == 20) {
			val1 = true;
		}
		if (val1 == true) {
			System.out.println("Base Case");
			return;
		}
		val3 = val2;
		System.out.println("val2 before " + val2 + " " + val3);
		recurse(val1, val2+1); 
		System.out.println("val2 after " + val2 + " " + val3);
			
	}

}
