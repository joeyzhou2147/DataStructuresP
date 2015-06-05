package Feb05_1;

public class LList {
	
	private Node head;
	private int size;

	
	public LList() {
		head = null;
		size = 0;
	}
	
	public void addHead(Integer data) {
		
		Node newGuy = new Node();
		
		newGuy.setData(data);
		newGuy.setNext(head);
		
		head = newGuy;
		size++;
		
	}
	
	public Integer removeHead() {
		
		if (size == 0) {
			return null;
		}

		Integer rtn = head.getData();
				
		head = head.getNext();
		
		size--;
		
		return rtn;
	}
	
	// Add the value valToAdd after the first instance of x
	public boolean addAfter(Integer x, Integer valToAdd) {
		
		// If the list is empty it is impossible to add after anything
		if (size == 0) {
			return false;
		}
		
		// Find the node containing x
		Node n = head;
		while (n != null) {
			if (n.getData().equals(x)) {
				break;
			}
			n = n.getNext();
		}
		
		// If n is null we could not find a node in the list that had data = to x
		if (n == null) {
			return false;
		}
 		
		// Getting here we need to add a node with valToAdd in it to the list
		
		Node a = new Node();
		a.setData(valToAdd);
		
		a.setNext(n.getNext());
		n.setNext(a);
		size++;
		
		return true;
	}
	
	// Add the value valToAdd before the first instance of x
	public boolean addBefore(Integer x, Integer valToAdd) {
		
		// If the list is empty it is impossible to add after anything
		if (size == 0) {
			return false;
		}
		
		// Find the node before the node containing x
		Node prev = null;
		Node cur = head;
		while (cur != null) {
			if (cur.getData().equals(x)) {
				break;
			}
			
			// Move over one, set previous to current, and move the current
			prev = cur;
			cur = cur.getNext();
		}
		
		// If n is null we could not find a node in the list that had data = to x
		if (cur == null) {
			return false;  // fail
		}
		
		if (prev == null) {
			// cur is valid, prev is null, insert at head
			this.addHead(valToAdd);
			return true;  // succeed
		}
 		
		// Getting here we need to add a node with valToAdd in after prev
		
		Node a = new Node();
		a.setData(valToAdd);
		
		a.setNext(prev.getNext());
		prev.setNext(a);
		size++;
		
		return true;	
	}
	
	// remove the node containing x
	public Integer remove(Integer x) {
		
		// If the list is empty it is impossible to add after anything
		if (size == 0) {
			return null;
		}
		
		// Find the node before the node containing x
		Node prev = null;
		Node cur = head;
		while (cur != null) {
			if (cur.getData().equals(x)) {
				break;
			}
			
			// Move over one, set previous to current, and move the current
			prev = cur;
			cur = cur.getNext();
		}
		
		// If n is null we could not find a node in the list that had data = to x
		if (cur == null) {
			return null;  // fail
		}
		
		if (prev == null) {
			// cur is valid, prev is null, delete at head
			return this.removeHead();
		}
 		
		// Getting here we need to remove the node after prev
		
		Integer rtn = cur.getData();
		// Skip over current in the chain.  Current contains the data we
		// want to delete
		prev.setNext(cur.getNext());
		size--;
		
		return rtn;
	}

	public String toString() {
		String rtn = "";
		
		if (size == 0) {
			return "<Empty>";
		}
		
		rtn += "Size: " + size + "\n";
		Node n = head;
		
		while (n != null) {
			rtn += "<" + n.getData() + "> ";
			n = n.getNext();
		}
		rtn += "\n";
		
		return rtn;
	}
}
