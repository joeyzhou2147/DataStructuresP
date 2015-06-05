package Mar05_1;

public class LinkedQueue implements MyQueue {

	private Node head;
	private Node tail;
	private int size;

	public LinkedQueue() {
		head = tail = null;
		size = 0;
	}

	/* (non-Javadoc)
	 * @see MyQueue#add(java.lang.Integer)
	 */
	@Override
	public void add(Integer item) {
		Node n = new Node();

		n.setData(item);

		// If the list is empty
		if (size == 0) {
			tail = head = n;
		} else {
			// One or more items in list
			tail.setNext(n);
			tail = n;
		}
		size++;
	}
	
	/* (non-Javadoc)
	 * @see MyQueue#remove()
	 */
	@Override
	public Integer remove() {
		if (size == 0) {
			// Queue is empty
			return null;
		} else {
			Node n = head;
			head = head.getNext();
			size--;
			
			// If deleting this node empties the queue make head and tail both null
			if (size == 0) {
				head = tail = null;
			}
			return n.getData();
		}
	}
	
	/* (non-Javadoc)
	 * @see MyQueue#size()
	 */
	@Override
	public int size() {
		return size;
	}
	
	/* (non-Javadoc)
	 * @see MyQueue#clear()
	 */
	@Override
	public void clear() {
		while (size() != 0) {
			remove();
		}
	}
	
	/* (non-Javadoc)
	 * @see MyQueue#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return (size == 0);
	}
	
	/* (non-Javadoc)
	 * @see MyQueue#isFull()
	 */
	@Override
	public boolean isFull() {
		return false;
	}
	
	public String toString() {
		String rtn = "";
		
		if (size == 0) {
			rtn += "<Empty>";
		} else {
			Node n = head;
			while (n != null) {
				rtn += n.getData() + "-> ";
				n = n.getNext();
			}
			rtn += "null";
		}
		
		return rtn;
	}
}
