package Apr02_1;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Driver me = new Driver();
		me.doIt();
	}
	
	public void doIt( ) {
		BTree tree = new BTree();
		
		tree.add("String Car");
		tree.add("String Boat");
		tree.add("String Tractor");
		tree.add("String Airplane");
		tree.add("String Cape");
		tree.add("String Capstone");
		System.out.println("Pre Order Traversal");
		tree.preOrderTraversal();
		System.out.println("In Order Traversal");
		tree.inOrderTraversal();
		System.out.println("Post Order Traversal");
		tree.postOrderTraversal();
		
		System.out.println("tree Print");
		System.out.println(tree); 
		System.out.println();
		System.out.println("Depth is " + tree.getDepth());
	}

}
