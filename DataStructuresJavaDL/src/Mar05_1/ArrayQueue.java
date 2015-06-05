package Mar05_1;

public class ArrayQueue implements MyQueue {

	private static final int QUEUE_SIZE = 32;

	private int qSize;
	private Integer []queue;
	private int size;
	private int head;
	private int tail;


	public ArrayQueue() {
		queue = new Integer[QUEUE_SIZE];
		qSize = QUEUE_SIZE;
	}

	public ArrayQueue(int qSize) {
		queue = new Integer[qSize];
		this.qSize = qSize;
	}

	@Override
	public void add(Integer item)  {

		if (isFull()) {
			// Resize the queue
			Integer []newQueue = new Integer[qSize+QUEUE_SIZE];
			
			int readLoc = head;
			
			for (int i = 0; i < qSize; i++) {
				newQueue[i] = queue[readLoc];
				readLoc++;
				if (readLoc == qSize) {
					readLoc = 0;
				}
			}
			
			head = 0;
			tail = qSize;
			queue = newQueue;
		}

		queue[tail++] = item;
		// cure wrap
		if (tail == qSize) {
			tail = 0;
		}
		size++;
	}

	@Override
	public Integer remove() {

		if (size == 0) {
			return null;
		} else {
			Integer rtn = queue[head];
			head++;
			// Handle wrap
			if (head == qSize) {
				head = 0;
			}
			size--;
			return rtn;
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		while (size() != 0) {
			remove();
		}

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size == 0);
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return (size == qSize);
	}

	public String toString() {
		String rtn = "";

		if (size == 0) {
			rtn = "<Empty>";
		} else {
			int n = head;
			for (int i = 0; i < size; i++) {
				rtn += queue[n] + "-> ";
				n++;
				// handle wrap
				if (n == qSize) {
					n = 0;
				}
			}
			rtn += "null";

		}

		return rtn;
	}
}
