package Apr23_1;


public class ELGraph implements MyGraph {

	private ELVertex[] graph; 
	
	public ELGraph(int size) {
		graph = new ELVertex[size];
		for (int i = 0; i < size; i++) {
			graph[i] = new ELVertex();
		}
	}

	@Override
	public void addEdge(int source, int target, int cost) {
		ELEdge edge = new ELEdge();
		edge.setVertex(target);
		edge.setCost(cost);
	
		edge.setNext(graph[source].getEdges());
		graph[source].setEdges(edge);
	}

	@Override
	public boolean isEdge(int source, int target) {
		ELEdge edge = graph[source].getEdges();
		
		while (edge != null) {
			if (edge.getVertex() == target) {
				return true;
			}
			edge = edge.getNext();
		}
		
		return false;
	}

	@Override
	public int edgeCost(int source, int target) {
		ELEdge edge = graph[source].getEdges();
		
		while (edge != null) {
			if (edge.getVertex() == target) {
				return edge.getCost();
			}
			edge = edge.getNext();
		}
		
		return Integer.MIN_VALUE;
	}

	@Override
	public void removeEdge(int source, int target) {
		// TODO Auto-generated method stub
		ELEdge cur = graph[source].getEdges();
		ELEdge prev = null;
		
		while (cur != null) {
			if (cur.getVertex() == target) {
				// Found it
				if (prev == null) {
					// First entry in list
					graph[source].setEdges(graph[source].getEdges().getNext());
					return;
				} else {
					// Second or later
					prev.setNext(cur.getNext());
					return;
				}
			}
			prev = cur;
			cur = cur.getNext();
		}
	}

	@Override
	public String getLabel(int vertex) {
		return graph[vertex].getLabel();
	}

	@Override
	public void setLabel(int vertex, String label) {
		graph[vertex].setLabel(label);
		
	}

	@Override
	public boolean[] neighbors(int vertex) {
		boolean[] rtn = new boolean[graph.length];
		
		for (int i = 0; i < graph.length; i++) {
			rtn[i] = false;
		}
		
		ELEdge edge = graph[vertex].getEdges();
		
		while (edge != null) {
			rtn[edge.getVertex()] = true;
			edge = edge.getNext();
		}
		
		return rtn;
	}

	@Override
	public int[] neighborsCost(int vertex) {
		int[] rtn = new int[graph.length];
		
		for (int i = 0; i < graph.length; i++) {
			rtn[i] = Integer.MIN_VALUE;
		}
		
		ELEdge edge = graph[vertex].getEdges();
		
		while (edge != null) {
			rtn[edge.getVertex()] = edge.getCost();
			edge = edge.getNext();
		}
		
		return rtn;
	}
	
	public String toString() {
		String rtn = "";
		for (int i = 0; i < graph.length; i++) {
			rtn += "vertex[" + i + "] = " + graph[i];
			ELEdge edge = graph[i].getEdges();
			while (edge != null) {
				rtn += edge + " ";
				edge = edge.getNext();
			}
			rtn += "\n";
		}
		
		return rtn;
	}

}
