package Mar05_1;

public interface MyQueue {

	public abstract void add(Integer item);

	public abstract Integer remove();

	public abstract int size();

	public abstract void clear();

	public abstract boolean isEmpty();

	public abstract boolean isFull();

}