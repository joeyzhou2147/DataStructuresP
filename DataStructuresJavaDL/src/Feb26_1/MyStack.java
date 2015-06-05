package Feb26_1;
public interface MyStack {

	public abstract void push(Integer item);

	public abstract Integer pop();

	public abstract boolean isFull();

	public abstract boolean isEmpty();

	public abstract Integer stackTop();

	public abstract void clear();
	
	public abstract int stackDepth();


}