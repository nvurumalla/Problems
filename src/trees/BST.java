package trees;

public class BST {

	private Node root;

	public BST(int data) {
		root = new Node(data);
	}

	public Node getRoot() {
		return root;
	}

	public void addNode(int data) {
		Node node = new Node(data);
		Node temp = root;
		while (temp != null) {
			if (data < temp.getData()) {
				if (temp.getLeft() != null) {
					temp = root.getLeft();
				} else {
					break;
				}
			} else {
				if (temp.getRight() != null) {
					temp = root.getRight();
				} else {
					break;
				}
			}
		}
		if (data < temp.getData()) {
			temp.setLeft(node);
		} else {
			temp.setRight(node);
		}
	}
}
