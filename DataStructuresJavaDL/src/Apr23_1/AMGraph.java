package Apr23_1;


public class AMGraph implements MyGraph {

	private AMEdge[][] graph;
	private String[] label;

	public AMGraph(int size) {
		graph = new AMEdge[size][size];
		label = new String[size];
	}

	/* (non-Javadoc)
	 * @see MyGraph#addEdge(int, int, int)
	 */
	@Override
	public void addEdge(int source, int target, int cost) {
		graph[source][target] = new AMEdge();
		graph[source][target].setCost(cost);
	}

	/* (non-Javadoc)
	 * @see MyGraph#isEdge(int, int)
	 */
	@Override
	public boolean isEdge(int source, int target) {
		return (graph[source][target] != null);
	}

	/* (non-Javadoc)
	 * @see MyGraph#edgeCost(int, int)
	 */
	@Override
	public int edgeCost(int source, int target) {
		if (!isEdge(source, target) ) {
			return Integer.MIN_VALUE;
		} else {
			return graph[source][target].getCost();
		}
	}

	/* (non-Javadoc)
	 * @see MyGraph#removeEdge(int, int)
	 */
	@Override
	public void removeEdge(int source, int target) {

		// If you care about whether an edge exists before you delete it
		// You should probably do something here.


		graph[source][target] = null;
	}

	/* (non-Javadoc)
	 * @see MyGraph#getLabel(int)
	 */
	@Override
	public String getLabel(int vertex) {
		return label[vertex];
	}

	/* (non-Javadoc)
	 * @see MyGraph#setLabel(int, java.lang.String)
	 */
	@Override
	public void setLabel(int vertex, String label) {
		this.label[vertex] = label;
	}

	/* (non-Javadoc)
	 * @see MyGraph#neighbors(int)
	 */
	@Override
	public boolean[] neighbors(int vertex) {
		boolean[] rtn = new boolean[graph.length];
		for (int i = 0; i < graph.length; i++) {
			if (graph[vertex][i] != null) {
				rtn[i] = true;
			} else {
				rtn[i] = false;
			}
		}

		return rtn;
	}

	/* (non-Javadoc)
	 * @see MyGraph#neighborsCost(int)
	 */
	@Override
	public int[] neighborsCost(int vertex) {
		int[] rtn = new int[graph.length];
		for (int i = 0; i < graph.length; i++) {
			rtn[i] = edgeCost(vertex, i);
		}

		return rtn;
	}


}
