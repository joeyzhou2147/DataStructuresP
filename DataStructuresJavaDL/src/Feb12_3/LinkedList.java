package Feb12_3;


public class LinkedList<T> {

	protected Node<T> head;
	private int size;
	
	public void addHead(T data) {

		Node<T> n = new Node<T>();
		n.setData(data);
		
		n.setNext(head);
		head = n;
		size++;
	}
	
	public String toString() {
		if (size == 0) {
			return "<Empty>";
		}
		
		String rtn = "";
		Node<T> n = head;
		
		while (n != null) {
			rtn += "<" + n.getData() + ">\n";
			n = n.getNext();
		}
		
		return rtn;
	}

}
