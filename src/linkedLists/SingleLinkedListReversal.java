package linkedLists;

public class SingleLinkedListReversal {
	public static void main(String[] args) {
		SingleLinkedList list1 = new SingleLinkedList();
		list1.addNode(1);
		list1.addNode(2);
		list1.addNode(3);
		list1.addNode(4);

		reverse(list1);

		list1.printList();
	}

	public static void reverse(SingleLinkedList list) {
		SingleLinkedListNode head = list.getHead();
		SingleLinkedListNode prev = null;
		SingleLinkedListNode node = head;
		SingleLinkedListNode tmp;

		while (node!=null) {
			tmp = node.getNext();
			node.setNext(prev);
			prev = node;
			node = tmp;
		}
		list.setHead(prev);
	}
}
