package Apr09_2;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Driver me = new Driver();
		me.doIt();
	}
	
	public void doIt() {
		Chained table = new Chained();
		System.out.println(table);
		table.Add("Vic", "978-555-1212");
		table.Add("Fred", "978-555-1212");
		table.Add("Barney", "978-555-1212");
		table.Add("Wilma", "978-555-1212");
		table.Add("Betty", "978-555-1212");
		table.Add("Vhd", "978-555-1212");
		table.Add("uid", "978-555-1212");
		System.out.println(table);
		System.out.println(table.search("Betty"));
		table.delete("fred");
		System.out.println(table);
		table.delete("vhd");
		System.out.println(table);
	}

}
