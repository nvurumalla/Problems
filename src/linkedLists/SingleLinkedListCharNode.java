package linkedLists;

public class SingleLinkedListCharNode {
	private char data;
	private SingleLinkedListCharNode next;

	public SingleLinkedListCharNode(char data) {
		this.data = data;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public SingleLinkedListCharNode getNext() {
		return next;
	}

	public void setNext(SingleLinkedListCharNode next) {
		this.next = next;
	}
}
