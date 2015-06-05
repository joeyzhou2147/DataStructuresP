package Apr23_1;

public interface MyGraph {

	public abstract void addEdge(int source, int target, int cost);

	public abstract boolean isEdge(int source, int target);

	public abstract int edgeCost(int source, int target);

	public abstract void removeEdge(int source, int target);

	public abstract String getLabel(int vertex);

	public abstract void setLabel(int vertex, String label);

	public abstract boolean[] neighbors(int vertex);

	public abstract int[] neighborsCost(int vertex);

}