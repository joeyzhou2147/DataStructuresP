package Feb12_3;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt();
	}
	
	public void doIt() {
		LinkedList<Integer> l = new LinkedList<Integer>();
		
		l.addHead(23);
		l.addHead(34);
		System.out.println(l);
		
		LinkedList<String> s = new LinkedList<String>();
		
		s.addHead("Add 1");
		s.addHead("Add 2");
		
		System.out.println(s);
		
		MyIterator<String> it = new MyIterator<String>(s);
		
		System.out.println("Iterator");
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("Iterator done");
		
	
		LinkedList<AddressRecord> a = new LinkedList<AddressRecord>();
		
		AddressRecord ar = new AddressRecord();
		ar.setName("Vic");
		ar.setAddress("100 Main Street");
		ar.setCity("Mitaddeningunparte");
		ar.setState("MA");
		ar.setZipCode("11111");
		ar.setPhoneNumber("978-555-3333");
		a.addHead(ar);
		
		System.out.println(a);
		
		ar.setName("No longer Vic");
		
		System.out.println(a);
	}

}
