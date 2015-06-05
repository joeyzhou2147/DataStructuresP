package Apr23_1;


public class ELVertex {
	private String label;
	ELEdge edges;
	
	
	@Override
	public String toString() {
		return "ELVertex [label=" + label + "]";
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public ELEdge getEdges() {
		return edges;
	}
	public void setEdges(ELEdge edges) {
		this.edges = edges;
	}

}
