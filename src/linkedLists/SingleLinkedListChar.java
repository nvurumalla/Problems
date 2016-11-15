package linkedLists;

public class SingleLinkedListChar {
	private SingleLinkedListCharNode head;

	public SingleLinkedListCharNode getHead() {
		return this.head;
	}

	public void setHead(SingleLinkedListCharNode head) {
		this.head = head;
	}

	public void addNode(char data) {
		SingleLinkedListCharNode newNode = new SingleLinkedListCharNode(data);
		SingleLinkedListCharNode node = this.head;
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

	public SingleLinkedListCharNode insertNode(char data, int position) {
		SingleLinkedListCharNode newNode = new SingleLinkedListCharNode(data);
		SingleLinkedListCharNode node;
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

	public SingleLinkedListCharNode deleteNode(SingleLinkedListCharNode deleteNode) {
		SingleLinkedListCharNode tmpNode = null;
		SingleLinkedListCharNode prevNode;
		SingleLinkedListCharNode node;

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

	public SingleLinkedListCharNode deleteNode(int position) {
		SingleLinkedListCharNode tmpNode;
		SingleLinkedListCharNode node;
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

	public SingleLinkedListCharNode deleteFirstNode() {
		SingleLinkedListCharNode tmpNode;
		tmpNode = this.head;
		this.head = this.head.getNext();
		return tmpNode;
	}

	public void printList() {
		SingleLinkedListCharNode node = this.head;
		while (node.getNext() != null) {
			System.out.print(node.getData() + "->");
			node = node.getNext();
		}
		System.out.println(node.getData());
	}
}
