package linkedLists;

public class GroupReversal {
	public static void main(String[] args) {
		SingleLinkedList list1 = new SingleLinkedList();
		list1.addNode(1);
		list1.addNode(2);
		list1.addNode(3);
		list1.addNode(4);
		list1.addNode(5);
		list1.addNode(6);

		reverse(list1, 3);

		list1.printList();
	}

	public static void reverse(SingleLinkedList list, int n) {
		SingleLinkedListNode head = list.getHead();
		SingleLinkedListNode tmpHead = head;
		SingleLinkedListNode prev = null;
		SingleLinkedListNode node = head;
		SingleLinkedListNode tmp;
		int i = 0;

		while (node!=null) {
			tmp = node.getNext();
			node.setNext(prev);
			i++;
			if (i==n) {
				i = 0;
				tmpHead.setNext(tmp);
//				if (tmp!=null) {
					prev = null;
//				}
				tmpHead = tmp;
			} else {
				prev = node;
			}
			node = tmp;
		}
		list.setHead(prev);
	}
}

/*
 * 1->2->3->4->5->6
 * 3->2->1->4->5->6
 * prev=3
 *
 * 1<-2<-3
 * tmp=4, node=3, prev=2
 *
 */
