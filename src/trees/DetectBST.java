package trees;

import java.util.ArrayList;
import java.util.List;

public class DetectBST {

	public static void main(String[] args) {
		BST bst = new BST(100);
		Node root = bst.getRoot();
		bst.addNode(50);
		bst.addNode(150);
		bst.addNode(160);
		bst.addNode(25);
		bst.getRoot().getLeft().setRight(new Node(60));
		bst.getRoot().getRight().setLeft(new Node(90));

//		System.out.println("Is BST ????? " + isBST(root));
		System.out.println("Is BST ????? " + isBSTInOrder(root));
	}

	private static boolean isBST(Node root) {
		if (root==null) {
			return true;
		}
		return isValidBST(root, null, null);
	}

	private static boolean isValidBST(Node root, Integer l, Integer h) {
		if (root==null) {
			return true;
		}
		System.out.println("Root : " + root.getData() +", Low : " + l +", High : " + h);
		boolean b1 = (l == null || root.getData() > l) && (h == null || root.getData() < h);
		boolean b2 = isValidBST(root.getLeft(), l, root.getData());
		boolean b3 = isValidBST(root.getRight(), root.getData(), h);
		return (b1&&b2&&b3);
	}

	private static boolean isBSTInOrder(Node root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return true;
		}
		if (!iSValidBSTInOrder(root.getLeft(), list)) {
			return false;
		}
		System.out.println(root.getData());
		if (!list.isEmpty() && root.getData() < ((Integer) list.get(list.size()-1))) {
			return false;
		}
		list.add(root.getData());
		if (!iSValidBSTInOrder(root.getRight(), list)) {
			return false;
		}
		return true;
	}

	private static boolean iSValidBSTInOrder(Node root, List<Integer> list) {
		if (root == null) {
			return true;
		}
		if (!iSValidBSTInOrder(root.getLeft(), list)) {
			return false;
		}
		System.out.println(root.getData());
		if (!list.isEmpty() && root.getData() < ((Integer) list.get(list.size()-1))) {
			return false;
		}
		list.add(root.getData());
		if (!iSValidBSTInOrder(root.getRight(), list)) {
			return false;
		}
		return true;
	}
}
