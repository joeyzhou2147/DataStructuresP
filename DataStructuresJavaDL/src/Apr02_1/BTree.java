package Apr02_1;


public class BTree {

	private Node root;

	public void add(String data) {
		if (root == null) {
			// Empty Tree
			root = new Node();
			root.setData(data);
		} else {
			recursiveAdd(root, data);
		}
	}

	private void recursiveAdd(Node root, String data) {

		if (root == null) {
			//is this the base case?
			System.out.println("root was null, recursiveAdd");
			return;
		}

		if (root.getData().toUpperCase().equalsIgnoreCase(data)) {
			return;
		}

		if (root.getData().toUpperCase().compareTo(data.toUpperCase()) < 0) {
			// put data to the right
			if (root.getRchild() == null) {
				Node n = new Node();
				n.setData(data);
				root.setRchild(n);
				return;
			} else {
				recursiveAdd(root.getRchild(), data);
			}
		} else {
			// put data to the left
			if (root.getLchild() == null) {
				Node n = new Node();
				n.setData(data);
				root.setLchild(n);
				return;
			} else {
				recursiveAdd(root.getLchild(), data);
			}
		}

	}

	// Pre-Order Traversal
	//Root - Left - Right

	public void preOrderTraversal() {
		preOrder(root);
	}

	private void preOrder(Node root) {
		// Base Case
		if (root == null) {
			return;
		}

		System.out.println(root.getData());
		preOrder(root.getLchild());
		preOrder(root.getRchild());

	}

	// In Order Traversal
	//Left - Root - Right
	public void inOrderTraversal() {
		inOrder(root);
	}

	private void inOrder(Node root) {
		// Base Case
		if (root == null) {
			return;
		}

		inOrder(root.getLchild());
		System.out.println(root.getData());
		inOrder(root.getRchild());

	}

	//Post-Order Traversal
	//Left - Right - Root
	public void postOrderTraversal() {
		postOrder(root);
	}

	private void postOrder(Node root) {
		// Base Case
		if (root == null) {
			return;
		}

		postOrder(root.getLchild());
		postOrder(root.getRchild());
		System.out.println(root.getData());

	}

	
	public int getDepth() {
		return getDepth(root, 0, 0);
	}
	
	private int getDepth(Node root, int level, int maxLevel) {
		if (root == null) {
			return maxLevel+1;
		}
		
		if (level > maxLevel) {
			maxLevel = level;
		}
		
		int x = getDepth(root.getLchild(), level+1, maxLevel);
		int y = getDepth(root.getRchild(), level+1, maxLevel);
		return x > y ? x : y;
	}
	
	private void printLevel(int level) {
		printLevel(root, level, 0);
	}

	private String printLevel(Node root, int level, int currentLevel) {
		if (root == null) {
			if (currentLevel == level) {
				return "null  ";
			}
			return "";
		}

		if (level == currentLevel) {
			return root.getData() + "  ";
		}

		
		String l = printLevel(root.getLchild(), level, currentLevel+1);
		String r = printLevel(root.getRchild(), level, currentLevel+1);
		return l + r;
	}
	
	public String toString() {
		String rtn = "";
		if (root == null) {
			return "<Empty Tree>";
		}
		
		int depth = this.getDepth();
		
		for (int i = 0; i < depth; i++) {
			rtn += printLevel(root, i, 0) + "\n";
		}
		
		return rtn;
	}
}
