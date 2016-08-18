package linkedLists;

public class TestSingleLinkedList {

	public static void main(String[] args) {
		TestSingleLinkedList test = new TestSingleLinkedList();

		SingleLinkedListNode head = new SingleLinkedListNode(1);
		head.setNext(null);

		SingleLinkedListNode sll = new SingleLinkedListNode(2);
		test.addNode(head, sll);

		SingleLinkedListNode sll1 = new SingleLinkedListNode(4);
		test.addNode(head, sll1);

		System.out.println("Initial list");
		for (SingleLinkedListNode node = head; node != null; node = node.getNext()) {
			System.out.println(node.getData());
		}

		SingleLinkedListNode sll2 = new SingleLinkedListNode(3);
		head = test.insertNode(head, sll2, 1);

		SingleLinkedListNode sll3 = new SingleLinkedListNode(5);
		test.addNode(head, sll3);

		SingleLinkedListNode sll4 = new SingleLinkedListNode(6);
		test.addNode(head, sll4);

		System.out.println("List after inserting new node");
		for (SingleLinkedListNode node = head; node != null; node = node.getNext()) {
			System.out.println(node.getData());
		}

		head = test.deleteNode(head, head);
		System.out.println("List after deleting second node");
		for (SingleLinkedListNode node = head; node != null; node = node.getNext()) {
			System.out.println(node.getData());
		}

		head = test.deleteNode(head, 1);
		System.out.println("List after deleting second node");
		for (SingleLinkedListNode node = head; node != null; node = node.getNext()) {
			System.out.println(node.getData());
		}
	}

	public void addNode(SingleLinkedListNode head, SingleLinkedListNode newNode) {
		SingleLinkedListNode node = head;
		while (node.getNext() != null) {
			node = node.getNext();
		}
		node.setNext(newNode);
		newNode.setNext(null);
	}

	public SingleLinkedListNode insertNode(SingleLinkedListNode head, SingleLinkedListNode newNode, int position) {
		SingleLinkedListNode node;
		if (position == 1) {
			newNode.setNext(head);
			head = newNode;
		} else {
			node = head;
			for (int i = 1; i<position-1; i++) {
				node = node.getNext();
			}
			newNode.setNext(node.getNext());
			node.setNext(newNode);
		}
		return head;
	}

	public SingleLinkedListNode deleteNode(SingleLinkedListNode head, SingleLinkedListNode deleteNode) {
		SingleLinkedListNode tmpNode = null;
		SingleLinkedListNode prevNode;
		SingleLinkedListNode node;

		if (head.getData() == deleteNode.getData()) {
			tmpNode = head;
			head = head.getNext();
			tmpNode = null;
		} else {
			prevNode = head;
			node = head.getNext();
			while (node != null) {
				if (node.getData() == deleteNode.getData()) {
					tmpNode = node;
					break;
				}
				prevNode = node;
				node = node.getNext();
			}
			if (tmpNode == null) {
				System.out.println("Node to be deleted not found");
			} else {
				prevNode.setNext(node.getNext());
				node = null;
			}
		}
		return head;
	}

	public SingleLinkedListNode deleteNode(SingleLinkedListNode head, int position) {
		SingleLinkedListNode tmpNode;
		SingleLinkedListNode node;
		if (position == 1) {
			tmpNode = head;
			head = head.getNext();
			tmpNode = null;
			return head;
		} else {
			node = head;
			for (int i=1; i<position-1 && node != null; i++) {
				node = node.getNext();
			}
			if (node == null) {
				System.out.println("Position is out of boundary");
			} else {
				tmpNode = node.getNext();
				node.setNext(tmpNode.getNext());
				tmpNode = null;
			}
			return head;
		}
	}
}
