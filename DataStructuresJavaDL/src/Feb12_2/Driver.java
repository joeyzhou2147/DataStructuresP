package Feb12_2;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt();
	}
	
	public void doIt() {
		Test<Integer> t = new Test<Integer>();
		
		Test<Driver> d = new Test<Driver>();
		
		t.test();
	}

}
