package Apr09_2;


public class Chained {
	static final int TABLE_SIZE = 31;
	static final DataRecord NEVER_USED = null;
	private DataRecord []table = new DataRecord[TABLE_SIZE];
	
	public Chained() {
		for (int i = 0; i < TABLE_SIZE; i++) {
			table[i] = NEVER_USED;
		}
	}
	
	private int hashFunction(String name) {
		int result = 0;
		for (int i = 0; i < name.length(); i++) {
			result = result + (int) name.toUpperCase().charAt(i);
		}
		
		return result % TABLE_SIZE;
	}
	
	
	public DataRecord search(String name) {
		int bucket = hashFunction(name);
		
		DataRecord b = table[bucket];

		while (b != null) {
			if (b.getName().equalsIgnoreCase(name)) {
				// This is it
				return b;
			}
			
			b = b.getNext();
		}
		
		return null;
	}

	private int searchForAdd(String name) {
		return hashFunction(name);
	}

	public void Add(String name, String number) {
		if (search(name) != null) {
			// Just return, its already there.
			return;
		}
		
		// So find a bucket
		int bucket = searchForAdd(name);
		
		DataRecord d = new DataRecord();
		d.setName(name);
		d.setPhoneNumber(number);
		d.setNext(table[bucket]);
		table[bucket] = d;
	}
	
	public void delete(String name) {
		if (search(name) == null) {
			// Not found
			System.out.println("Record for name '" + name + "' not found");
			return;
		}
		
		int bucket = hashFunction(name);
		DataRecord n = table[bucket];
		// Search through the list locating the element.
		// Keep track of the previous node so we can perform the delete
		DataRecord cur = n;
		DataRecord prev = null;
		while (cur != null) {
			if (cur.getName().equalsIgnoreCase(name)) {
				// This is the one we want, time to figure out what to delete
				if (prev == null) {
					// Entry was the head of the list
					// simply move the head down one entry
					table[bucket] = cur.getNext();
					return;
				} else {
					// Make prev point at the record after cur
					prev.setNext(cur.getNext());
					return;
				}
			}
			
			// Move to the next record
			prev = cur;
			cur = cur.getNext();
			
		}
		
		// Getting here means the record was not in the list.
		// This should not happen, but it is harmless.
		return;
	}
	
	public String toString() {
		String rtn = "";
		
		for (int i = 0; i < TABLE_SIZE; i++) {
			rtn += "table[" + i + "] = ";
			if (table[i] == NEVER_USED) {
				rtn += "NEVER_USED\n";
			} else {
				DataRecord n = table[i];
				rtn += "[ ";
				while (n != null) {
					rtn += n + " ";
					n = n.getNext();
				}
				rtn += "]\n";
			}
		}
		
		return rtn;
	}

}
