package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentSkipListMap;

public class DepthFirstTraversal {

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
        depthFirstTraversal(root);
    }

    public static void depthFirstTraversal(Node root) {
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.empty()) {
            Node n = s.pop();
            if (null != n.getRight()) {
                s.push(n.getRight());
            }
            if (null != n.getLeft()) {
                s.push(n.getLeft());
            }
            System.out.println(n.getData());
        }
        new ConcurrentSkipListMap<>();
    }
}
