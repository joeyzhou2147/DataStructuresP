package Mar05_1;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Driver me = new Driver();
		me.doIt();
	}

	private void doIt() {
		MyQueue q = new ArrayQueue();
		
		System.out.println(q);
		q.add(12);
		System.out.println(q);
		q.add(13);
		System.out.println(q);
		q.add(14);
		System.out.println(q);
		
		System.out.println(q.remove());
		System.out.println(q);

		System.out.println(q.remove());
		System.out.println(q);

		System.out.println(q.remove());
		System.out.println(q);

		System.out.println(q.remove());
		System.out.println(q);

		q.add(14);
		System.out.println(q);

	}	
}
