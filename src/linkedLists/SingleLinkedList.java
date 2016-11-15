package linkedLists;

public class SingleLinkedList {

	private SingleLinkedListNode head;

	public SingleLinkedListNode getHead() {
		return this.head;
	}

	public void setHead(SingleLinkedListNode head) {
		this.head = head;
	}

	public void addNode(int data) {
		SingleLinkedListNode newNode = new SingleLinkedListNode(data);
		SingleLinkedListNode node = this.head;
		if (this.head == null) {
			this.head = newNode;
			this.head.setNext(null);
		} else {
			while (node.getNext() != null) {
				node = node.getNext();
			}
			node.setNext(newNode);
			newNode.setNext(null);
		}
	}

	public SingleLinkedListNode insertNode(int data, int position) {
		SingleLinkedListNode newNode = new SingleLinkedListNode(data);
		SingleLinkedListNode node;
		if (position == 1) {
			newNode.setNext(this.head);
			this.head = newNode;
		} else {
			node = this.head;
			for (int i = 1; i<position-1; i++) {
				node = node.getNext();
			}
			newNode.setNext(node.getNext());
			node.setNext(newNode);
		}
		return this.head;
	}

	public SingleLinkedListNode deleteNode(SingleLinkedListNode deleteNode) {
		SingleLinkedListNode tmpNode = null;
		SingleLinkedListNode prevNode;
		SingleLinkedListNode node;

		if (this.head.getData() == deleteNode.getData()) {
			tmpNode = this.head;
			this.head = this.head.getNext();
			tmpNode = null;
		} else {
			prevNode = this.head;
			node = this.head.getNext();
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
		return this.head;
	}

	public SingleLinkedListNode deleteNode(int position) {
		SingleLinkedListNode tmpNode;
		SingleLinkedListNode node;
		if (position == 1) {
			tmpNode = this.head;
			this.head = this.head.getNext();
			tmpNode = null;
			return this.head;
		} else {
			node = this.head;
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
			return this.head;
		}
	}

	public SingleLinkedListNode deleteFirstNode() {
		SingleLinkedListNode tmpNode;
		tmpNode = this.head;
		this.head = this.head.getNext();
		return tmpNode;
	}

	public void printList() {
		SingleLinkedListNode node = this.head;
		while (node.getNext() != null) {
			System.out.print(node.getData() + "->");
			node = node.getNext();
		}
		System.out.println(node.getData());
	}
}
