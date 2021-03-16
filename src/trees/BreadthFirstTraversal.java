package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstTraversal {

    public static void main(String[] args) {
        BST bst = new BST(100);
        Node root = bst.getRoot();
        bst.addNode(50);
        bst.addNode(150);
        bst.addNode(160);
        bst.addNode(25);
        bst.getRoot().getLeft().setRight(new Node(60));
        bst.getRoot().getLeft().getLeft().setRight(new Node(35));
        bst.getRoot().getLeft().getLeft().setLeft(new Node(15));
        bst.getRoot().getRight().setLeft(new Node(90));
        breadthFirstTraversal(root);
    }

    public static void breadthFirstTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node n = q.poll();
            if (null != n.getLeft()) {
                q.add(n.getLeft());
            }
            if (null != n.getRight()) {
                q.add(n.getRight());
            }
            System.out.println(n.getData());
        }
    }
}
