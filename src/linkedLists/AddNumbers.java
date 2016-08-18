package linkedLists;

public class AddNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SingleLinkedList list1 = new SingleLinkedList();
		list1.addNode(9);
//		list1.addNode(9);
//		list1.addNode(9);

		list1.printList();

		SingleLinkedList list2 = new SingleLinkedList();
		list2.addNode(9);
		list2.addNode(9);
		list2.addNode(9);

		list2.printList();

		SingleLinkedList sumList = addNumbers(list1, list2);
		sumList.printList();
	}

	private static SingleLinkedList addNumbers(SingleLinkedList list1, SingleLinkedList list2) {
		SingleLinkedListNode node1 = list1.getHead();
		SingleLinkedListNode node2 = list2.getHead();
		SingleLinkedList list3 = new SingleLinkedList();
		int carry = 0;
		int sum =0;
		int data1 = node1.getData(), data2 = node2.getData();
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
				node1 = node1.getNext();
				data1 = 0;
			} else {
				node1 = node1.getNext();
				data1 = node1.getData();
			}

			if (node2 == null) {
				data2 = 0;
			} else if (node2.getNext() == null) {
				node2 = node2.getNext();
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

}
