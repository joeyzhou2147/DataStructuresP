package Feb12_3;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyIterator<T> implements Iterator<T> {

	Node<T> currentNode;
	public MyIterator(LinkedList<T> list) {
		currentNode = list.head;
	}
	
	@Override
	public boolean hasNext() {
		return (currentNode != null);
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		T rtn;
		
		if (!hasNext()) {
			throw new NoSuchElementException("no next element");
		}
		
		rtn = currentNode.getData();
		currentNode = currentNode.getNext();
		return rtn;
	}


}
