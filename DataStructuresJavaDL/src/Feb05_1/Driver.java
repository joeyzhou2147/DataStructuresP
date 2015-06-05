package Feb05_1;
public class Driver {

	public static void main(String[] args) {
		
		Driver me = new Driver();
		me.doIt();

	}
	
	private void doIt() {
		
		LList list = new LList();
		
		list.addHead(12);
		list.addHead(13);
		System.out.println(list);
		
		System.out.println(list.removeHead());
		System.out.println(list);
		
		list.addHead(23);
		list.addHead(33);
		System.out.println(list);
		
		System.out.println(list.addAfter(23, 55));
		System.out.println(list);
		
		System.out.println(list.addAfter(44, 66));
		System.out.println(list);
		
		System.out.println(list.addBefore(33, 99));
		System.out.println(list);
		
		System.out.println(list.addBefore(12, 88));
		System.out.println(list);
		
		// test head, middle and end remove
		System.out.println(list.remove(99));
		System.out.println(list);
		
		System.out.println(list.remove(55));
		System.out.println(list);
		
		System.out.println(list.remove(12));
		System.out.println(list);
		
		System.out.println(list.remove(1234));
		System.out.println(list);
	}

}
