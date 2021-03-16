package linkedLists;

public class AddNumbers {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        SingleLinkedList list1 = new SingleLinkedList();
        list1.addNode(2);
        list1.addNode(4);
        list1.addNode(3);

        list1.printList();

        SingleLinkedList list2 = new SingleLinkedList();
        list2.addNode(5);
        list2.addNode(6);
        list2.addNode(4);

        list2.printList();

        SingleLinkedList sumList = add(list1, list2);
        sumList.printList();
    }

    private static SingleLinkedList addNumbers(SingleLinkedList list1, SingleLinkedList list2) {
        SingleLinkedListNode node1 = list1.getHead();
        SingleLinkedListNode node2 = list2.getHead();
        SingleLinkedList list3 = new SingleLinkedList();
        int carry = 0;
        int sum = 0;
        int data1 = node1 != null ? node1.getData() : 0;
        int data2 = node2 != null ? node2.getData() : 0;
        while (node1 != null || node2 != null) {
            sum = data1 + data2 + carry;
            if (sum >= 10) {
                carry = 1;
                list3.addNode(sum % 10);
            } else {
                carry = 0;
                list3.addNode(sum);
            }

            if (node1 == null) {
                data1 = 0;
            } else if (node1.getNext() == null) {
                node1 = null;
                data1 = 0;
            } else {
                node1 = node1.getNext();
                data1 = node1.getData();
            }

            if (node2 == null) {
                data2 = 0;
            } else if (node2.getNext() == null) {
                node2 = null;
                data2 = 0;
            } else {
                node2 = node2.getNext();
                data2 = node2.getData();
            }
        }
        if (carry == 1) {
            list3.addNode(carry);
        }
        return list3;
    }

    private static SingleLinkedList add(SingleLinkedList l1, SingleLinkedList l2) {
        if ((l1 == null || l1.getHead() == null) && (l2 == null || l2.getHead() == null)) {
            return null;
        }
        if (l2 == null) {
            return l1;
        }
        SingleLinkedListNode node1 = l1.getHead();
        SingleLinkedListNode node2 = l2.getHead();
        SingleLinkedList l3 = new SingleLinkedList();
        int sum = 0;
        int carry = 0;

        while (node1 != null || node2 != null) {
            if (node1 != null) {
                sum = sum + node1.getData();
            }
            if (node2 != null) {
                sum = sum + node2.getData();
            }
            sum = sum + carry;
            carry = sum / 10;
            int rem = sum % 10;
            l3.addNode(rem);

            if (node1 != null) {
                node1 = node1.getNext();
            }
            if (node2 != null) {
                node2 = node2.getNext();
            }
            sum = 0;
        }
        if (carry != 0) {
            l3.addNode(carry);
        }
        return l3;
    }
}
