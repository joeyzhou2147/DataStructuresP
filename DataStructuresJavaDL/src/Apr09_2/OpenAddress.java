package Apr09_2;

public class OpenAddress {
	static final int TABLE_SIZE = 31;
	static final DataRecord NEVER_USED = null;
	private DataRecord []table = new DataRecord[TABLE_SIZE];
	private int numEntries;
	
	public OpenAddress() {
		for (int i = 0; i < TABLE_SIZE; i++) {
			table[i] = NEVER_USED;
		}
		numEntries = 0;
	}
	
	private int hashFunction(String name) {
		int result = 0;
		for (int i = 0; i < name.length(); i++) {
			result = result + (int) name.toUpperCase().charAt(i);
		}
		
		return result % TABLE_SIZE;
	}
	
	private int probe(int loc, int sequenceNum) {
		return (loc+sequenceNum*sequenceNum) % TABLE_SIZE;
	}
	
	public DataRecord search(String name) {
		int originalBucket = hashFunction(name);
		int bucket = originalBucket;
		int sequence = 1;
		while (table[bucket] != NEVER_USED) {
			if (table[bucket].getUsed() == DataRecord.PREVIOUSLY_USED) {
				// DO NOTHING
			} else if (table[bucket].getName().equalsIgnoreCase(name)) {
				// This is it
				return table[bucket];
			}
			
			bucket = probe(originalBucket, sequence++);
		}
		
		return null;
	}

	private int searchForAdd(String name) {
		// Check for table full
		if (numEntries == TABLE_SIZE) {
			return -1;
		}
		int originalBucket = hashFunction(name);
		int bucket = originalBucket;
		int sequence = 1;
		boolean done = false;
		while (!done) {
			if (table[bucket] == NEVER_USED) {
				return bucket;
			} else if (table[bucket].getUsed() == DataRecord.PREVIOUSLY_USED) {
				return bucket;
			}
			
			System.out.println("Collision during add");
			// Something in this bucket, move on
			bucket = probe(originalBucket, sequence++);
			
		}
		
		return -1;
	}

	public void Add(String name, String number) {
		if (search(name) != null) {
			// Just return its already there.
			return;
		}
		
		// So find a bucket
		int bucket = searchForAdd(name);
		if (bucket == -1) {
			// ouch we are full
			return;
		}
		
		DataRecord d = new DataRecord();
		d.setName(name);
		d.setPhoneNumber(number);
		table[bucket] = d;
		numEntries++;
	}
	
	public int searchForDelete(String name) {
		int originalBucket = hashFunction(name);
		int bucket = originalBucket;
		int sequence = 1;
		while (table[bucket] != NEVER_USED) {
			if (table[bucket].getUsed() == DataRecord.PREVIOUSLY_USED) {
				// DO NOTHING
			} else if (table[bucket].getName().equalsIgnoreCase(name)) {
				// This is it
				return bucket;
			}
			
			bucket = probe(originalBucket, sequence++);
		}
		
		return -1;
	}
	public void delete(String name) {
		if (search(name) == null) {
			// Not found
			System.out.println("Record for name '" + name + "' not found");
			return;
		}
		
		int bucket = searchForDelete(name);
		if (bucket != -1) {
			table[bucket].setUsed(DataRecord.PREVIOUSLY_USED);
		}
	}
	
	public String toString() {
		String rtn = "";
		
		for (int i = 0; i < TABLE_SIZE; i++) {
			rtn += "table[" + i + "] = ";
			if (table[i] == NEVER_USED) {
				rtn += "NEVER_USED\n";
			} else if (table[i].getUsed() == DataRecord.PREVIOUSLY_USED) {
					rtn += "PREVIOUSLY_USED\n";
			} else {
				rtn += table[i] + "\n";
			}
		}
		
		return rtn;
	}
}
