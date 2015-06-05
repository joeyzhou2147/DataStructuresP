package Apr16_3;

public class HeapSort
{
	public final static int UNUSED = -1;
	private final static String BLANKS = "  "; // A String of two blanks

	public static void main(String[ ] args)
	{
		HeapSort me = new HeapSort();
		me.doIt();
	}

	public void doIt() {
		int i;                      // Array index

		int[ ] data = { 80, 10, 50, 70, 60, 90, 20, 30, 40};

		// Print the array before sorting:
		System.out.print("Here is the entire original array: ");
		for (i = 0; i < data.length; i++)
			System.out.print(data[i] + BLANKS);
		System.out.println( );

		// Sort the numbers, and print the result with two blanks after each number.
		heapSort(data);
		System.out.print("After sorting, the numbers are: ");
		for (i = 0; i < data.length; i++)
			System.out.print(data[i] + BLANKS);
		System.out.println( );

	}

	public void heapSort(int[] a){
		int count = a.length;
	 
		//first place a in max-heap order
		makeHeap(a, count);
	 
		int end = count - 1;
		while(end > 0){
			//swap the root(maximum value) of the heap with the
			//last element of the heap
			int tmp = a[end];
			a[end] = a[0];
			a[0] = tmp;
			//put the heap back in max-heap order
			heapifyDown(a, 0, end - 1);
			//decrement the size of the heap so that the previous
			//max value will stay in its proper place
			end--;
		}
	}
	 
	public void makeHeap(int[] a, int count){
		//start is assigned the index in a of the last parent node
		int start = (count - 2) / 2; //binary heap
	 
		while(start >= 0){
			//sift down the node at index start to the proper place
			//such that all nodes below the start index are in heap
			//order
			heapifyDown(a, start, count - 1);
			start--;
		}
		//after sifting down the root all nodes/elements are in heap order
	}
	
    private void swap(int[] data, int a, int b) {
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;

    }

	public  void heapifyDown(int[] data, int start, int end){
		//end represents the limit of how far down the heap to sift
		int root = start;
	 
		while((root * 2 + 1) <= end){      //While the root has at least one child
			int child = root * 2 + 1;           //root*2+1 points to the left child
			//if the child has a sibling and the child's value is less than its sibling's...
			if(child + 1 <= end && data[child] < data[child + 1])
				child = child + 1;           //... then point to the right child instead
			if(data[root] < data[child]){     //out of max-heap order
				swap(data, root, child);
				root = child;                //repeat to continue sifting down the child now
			}else
				return;
		}
	}
	
	
}


