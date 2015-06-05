package Feb12_1;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Driver me = new Driver();
		me.doIt();
	}
	
	public void doIt() {
		
		Test t = new Test();
		System.out.println(t.addEm(1, 2, 3, 4));
		System.out.println(t.addEm(1, 2, 3, 4, 5));
	}

}
