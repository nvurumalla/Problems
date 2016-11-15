package stacksAndQueues;

import linkedLists.SingleLinkedListChar;

public class Stack {
	private SingleLinkedListChar list = new SingleLinkedListChar();

	public void push(char data) {
		if (list.getHead() == null) {
			list.addNode(data);
		} else {
			list.insertNode(data, 1);
		}
	}

	public char pop() {
		if (list.getHead() == null) {
			return '$';
		}
		char data = list.getHead().getData();
		list.deleteFirstNode();
		return data;
	}
}
