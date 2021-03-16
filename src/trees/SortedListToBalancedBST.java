package trees;

import linkedLists.AddListNumbers.ListNode;

public class SortedListToBalancedBST {

    private static ListNode list;
    public static void main(String[] args) {
        int[] arr = {9,12,14,17,19,23,50,54,67,72,76};
        ListNode head = new ListNode(9);
        ListNode tmp = head;
        for (int i = 1; i < arr.length; i++) {
            tmp.next = new ListNode(arr[i]);
            tmp = tmp.next;
        }

        tmp = head;
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }

        Node node = sortedListToBST(head);
        System.out.println(node.getData());
    }

    private static Node sortedListToBST(int start, int end) {
        if (start > end) return null;
        int mid = (start + end)/2;
        Node leftChild = sortedListToBST(start, mid-1);
        Node parent = new Node(list.val);
        parent.setLeft(leftChild);
        list = list.next;
        Node rightChild = sortedListToBST(mid+1, end);
        parent.setRight(rightChild);
        return parent;
    }

    private static Node sortedListToBST(ListNode head) {
        int n = 0;
        ListNode p = head;
        while(p != null) {
            p = p.next;
            n++;
        }
        list = head;
        return sortedListToBST(0, n-1);
    }
}
