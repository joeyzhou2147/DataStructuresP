package Apr16_1;


public class SortDriver {
	
	int [] unsorted = {23,12,11,2,56,19,5,1,88,55,13,18,22};
	//int [] unsorted;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortDriver me = new SortDriver();
		me.doIt();
	}
	
	public void doIt() {
		
		/*unsorted = new int[100000];
		
		int num = unsorted.length;
		for (int i = 0; i < unsorted.length; i++) {
			unsorted[i] = num--;
		}
*/
		
		int [] ar = unsorted.clone();
		selectionSort(ar);
		System.out.println(pa(ar));
	

		int [] ab = unsorted.clone();
		System.out.println("sorting");
		bubbleSort(ab);
		System.out.println("done");
		System.out.println(pa(ab));

		
		int [] ac = unsorted.clone();
		insertionSort(ac);
		System.out.println(pa(ac));
		
	}
	
	public void selectionSort(int[] data) {
		int i, j;
		int big;
		int temp;
		int count = 0;
		int first = 0;

		for (i = data.length-1; i > 0; i--) {
			big = first;
			for (j = first + 1; j <= first + i; j++) {
				count++;

				if (data[big] < data[j]) 
					big = j;
			}
			
			temp = data[first+i];
			data[first+i] = data[big];
			data[big] = temp;
		}
		System.out.println("Checked " + count + " times");

	}
	
	public void bubbleSort(int [] data) {
		int temp;
		int count = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length-1; j++) {
				count++;
				if (data[i] < data[j]) {
					temp = data[i];
					data[i] = data[j];
					data[j] = temp;

				}
			}
		} 
		System.out.println("Checked " + count + " times");
	}
	
	public void insertionSort(int [] data) {
		int [] newArray = new int[data.length];
		int big;
		
		for (int i = newArray.length-1; i >= 0; i--) {
			big = 0;
			for (int j = 0; j < data.length; j++) {
				
					if (data[j] > data[big]) {
						big = j;
					}
				
			}
			newArray[i] = data[big];
			data[big] = -1;
		}
		//data = newArray;
		
		for (int a = 0; a < newArray.length; a++) {
			data[a] = newArray[a];
			//System.out.println(data[a]);
		}
		
	}
	
	private String pa(int[] array) {
		String rtn = "";
		
		for (int i = 0; i < array.length; i++) {
			rtn += "[" + i + "] = " + array[i] + ", ";
 		}
		rtn += "\n";
		return rtn;
	}

}
