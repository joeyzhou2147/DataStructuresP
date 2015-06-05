package Jan22_01;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		System.out.println("in main");

		for (int i = 0; i < 25; i++) {
			Test me = new Test();
			me.doIt();
		}
		
		System.out.println("Locker Count = " + lockerCount);
	}


	public Test() {
		lockerCount = 100;
		System.out.println("in constructor");
	}

	private int data;
	private static int lockerCount;

	public void doIt() {
		data = 34;
		lockerCount--;

	}

}
