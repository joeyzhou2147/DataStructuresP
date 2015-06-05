package Feb26_1;
public class ArrayStack implements MyStack {
	private static final int STACK_SIZE = 32;
	private Integer []stack;
	private int top;
	
	public ArrayStack() {
		stack = new Integer[STACK_SIZE];
		top = 0;
	}
	
	/* (non-Javadoc)
	 * @see MyStack#push(java.lang.String)
	 */
	@Override
	public void push(Integer item) {
		// Check for overflow
		if (isFull()) {
			return;
		}
		
		stack[top++] = item;
	}
	
	/* (non-Javadoc)
	 * @see MyStack#pop()
	 */
	@Override
	public Integer pop() {
		// Check for underflow
		if (isEmpty()) {
			return null;
		}
		
		Integer rtn = stack[top-1];
		top--;
		return rtn;
	}
	
	/* (non-Javadoc)
	 * @see MyStack#isFull()
	 */
	@Override
	public boolean isFull() {
		return (top >= STACK_SIZE);
	}
	
	/* (non-Javadoc)
	 * @see MyStack#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return (top == 0);
	}
	
	/* (non-Javadoc)
	 * @see MyStack#stackTop()
	 */
	@Override
	public Integer stackTop() {
		if (isEmpty()) {
			return null;
		}
		return stack[top-1];
	}
	
	/* (non-Javadoc)
	 * @see MyStack#clear()
	 */
	@Override
	public void clear() {
		while (!isEmpty()) {
			pop();
		}
	}
	
	public int stackDepth() {
		return top;
	}
	
	public String toString() {
		String rtn = "";
		
		if (top == 0) {
			return "<Empty>";
		}
		
		for (int i = top-1; i >= 0; i--) {
			if (i == top-1) {
				rtn += "top -> ";
			} else 
				rtn += "       ";
			rtn += stack[i] + "\n";
		}
		
		return rtn;
	}
}
