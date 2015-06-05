package Apr09_1;


public class Driver {

	private int []array = {2, 4, 6, 7, 8, 9, 11, 13, 15, 18, 23, 24, 36, 45, 57, 78};
	public static void main(String[] args) {
		Driver me = new Driver();
		me.doIt();

	}
	private int []array2;
	
	public void doIt() {
		
		array2 = new int[100000000];
		for (int i = 0; i < array2.length; i++) {
			array2[i] = i*2;
		}
		long start = System.currentTimeMillis();
		System.out.println(binSearch(array2, 0, array2.length-1, (array2.length-1) * 2));
		long stop = System.currentTimeMillis();
		System.out.println("Binary search took " + (stop-start) + " milliseconds");

		start = System.currentTimeMillis();
		System.out.println(serialSearch(array2, (array2.length-1) * 2));
		stop = System.currentTimeMillis();
		System.out.println("Serial search took " + (stop-start) + " milliseconds");
		//System.out.println(binSearch(array, 0, array.length-1, 78));
		//System.out.println(recBinSearch(array, 0, array.length-1, 78));
	}
	
	
	public int serialSearch(int array[], int www) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == www) {
				return i;
			}
		}
		return -1;
	}
	
	// returns index if found, otherwise -1
	public int binSearch(int array[], int lo, int hi, int www) {
		int mid;
		
		while (lo <= hi) {
			mid = (lo + hi) / 2;
			if (array[mid] == www) {
				return mid;
			}
			
			if (www < array[mid]) {
				hi = mid -1;
			} else {
				lo = mid + 1;
			}
		}
		
		return -1;
	}

	// returns index if found, otherwise -1
	public int recBinSearch(int array[], int lo, int hi, int www) {
		
			int mid = (lo + hi) / 2;
			
			// BASE CASE: Not found
			if (lo > hi) {
				return -1;
			}
			
			// BASE CASE: Found
			if (array[mid] == www) {
				return mid;
			}
			
			if (www < array[mid]) {
				return recBinSearch(array, lo, mid-1, www);
			} else {
				return recBinSearch(array, mid+1, hi, www);
			}
		
	}

}
