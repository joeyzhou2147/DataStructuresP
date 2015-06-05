package Feb26_1;
public class LinkedStack implements MyStack {

	private Node top;
	private int depth;
	
	public LinkedStack() {
		top = null;
		depth = 0;
	}
	
	@Override
	public void push(Integer item) {
		Node n = new Node();
		n.setData(item);
		n.setNext(top);
		top = n;
		depth++;
	}

	@Override
	public Integer pop() {
		if (isEmpty()) {
			return null;
		}
		
		Integer rtn = top.getData();
		top = top.getNext();
		depth--;
		return rtn;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return (top == null);
	}

	@Override
	public Integer stackTop() {
		if (!isEmpty()) {
			return top.getData();
		}
		return null;
	}

	@Override
	public void clear() {
		while (!isEmpty()) {
			pop();
		}
	}
	
	public void printHi() {
		System.out.println("Hi");
	}
	
	public int stackDepth() {
		return depth;
	}


	public String toString() {
		String rtn = "";
		
		if (top == null) {
			return "<Empty>";
		}
		
		Node n = top;
		rtn += "top -> " + n.getData() + "\n";
		n = n.getNext();
		
		while (n != null) {
			rtn += "       " + n.getData() + "\n";
			n = n.getNext();
		}
		return rtn;
	}
}
