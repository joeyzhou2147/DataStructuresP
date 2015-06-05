package Jan29_01;

public class TestDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestDriver me = new TestDriver();
		me.doIt();
	}

	public void doIt() {

		Class cs342 = new Class();
		cs342.add("Joe", 22, "Boston");
		System.out.println(cs342);
		cs342.add("Fred", 28, "Arlington");
		System.out.println(cs342);
		cs342.add("Jane", 25, "Sandwich");
		System.out.println(cs342);
		cs342.add("Beth", 21, "Natick");
		System.out.println(cs342);

		System.out.println("\nNow delete some people\n");

		Person deletee = cs342.remove();
		System.out.println("Deleted: " + deletee + "\n");
		System.out.println(cs342);

		deletee = cs342.remove();
		System.out.println("Deleted: " + deletee + "\n");
		System.out.println(cs342);
		
		cs342.emptyBag();
		System.out.println(cs342);
	}
	
	

}
