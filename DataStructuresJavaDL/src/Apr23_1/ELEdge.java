package Apr23_1;


public class ELEdge {
	
	private int cost;
	
	// If we want an index of the vertex in the array
	private int vertex;
	private ELEdge next;
	
	

	@Override
	public String toString() {
		return "ELEdge [cost=" + cost + ", vertex=" + vertex + "]";
	}

	public ELEdge getNext() {
		return next;
	}

	public void setNext(ELEdge next) {
		this.next = next;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getVertex() {
		return vertex;
	}

	public void setVertex(int vertex) {
		this.vertex = vertex;
	}
	
	// If we want a reference to the vertex
	//private ELVertex vertex;
}
