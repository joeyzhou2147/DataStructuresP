package Apr23_1;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Driver me = new Driver();
		me.doIt();
	}
	
	public void doIt() {
		
		MyGraph graph = new ELGraph(8);
		
		graph.setLabel(0, "S0");
		graph.addEdge(0, 5, 15);
		graph.addEdge(1, 5, 15);
		graph.addEdge(2, 5, 15);
		graph.addEdge(3, 5, 15);
		graph.addEdge(0, 3, 15);
		graph.addEdge(0, 4, 15);
		graph.addEdge(5, 0, 15);
		System.out.println(graph);
		graph.removeEdge(0, 3);
		System.out.println(graph);
		
	}

}
