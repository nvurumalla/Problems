package linkedLists;

public class AddListNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(8);

        ListNode l3 = addTwoNumbers(l1, l2);
        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode l3 = null;
        ListNode currentNode = null;
        int sum = 0;
        int carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum = sum + l1.val;
            }
            if (l2 != null) {
                sum = sum + l2.val;
            }
            sum = sum + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode tmp = new ListNode(sum);
            if (currentNode == null) {
                currentNode = tmp;
                l3 = currentNode;
            } else {
                currentNode.next = tmp;
                currentNode = tmp;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            sum = 0;
        }
        if (carry != 0) {
            ListNode tmp = new ListNode(carry);
            currentNode.next = tmp;
        }
        return l3;
    }

    /**
     * Definition for singly-linked list.
     **/
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }

    }
}
