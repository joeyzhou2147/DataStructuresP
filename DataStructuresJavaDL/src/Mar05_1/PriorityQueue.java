package Mar05_1;


public class PriorityQueue {
	// Priorities should be 1 based!!!!!
	private static final int QUEUE_NUM = 5;
	private LinkedQueue []queues;

	
	public PriorityQueue() {
		queues = new LinkedQueue[QUEUE_NUM];
		
		for (int i = 0; i < QUEUE_NUM; i++) {
			queues[i] = new LinkedQueue();
		}
	}
	
	public void add(int priority, Integer item) {
		if ((priority < 1) || (priority > QUEUE_NUM)) {
			// ERROR
		}
 		queues[priority-1].add(item);
	}
	
	public Integer remove(int priority) {
		return queues[priority-1].remove();
	}
}
