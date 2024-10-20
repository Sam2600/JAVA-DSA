public class SinglyLinkedList {

	public ListNode head;

	public static void main(String[] args) {

		SinglyLinkedList list = new SinglyLinkedList();

		list.insertFirstNode(list, 9);
		list.insertFirstNode(list, 7);
		list.insertFirstNode(list, 5);
		list.insertFirstNode(list, 3);
		list.insertFirstNode(list, 1);

		SinglyLinkedList list_2 = new SinglyLinkedList();

		list_2.insertFirstNode(list_2, 10);
		list_2.insertFirstNode(list_2, 8);
		list_2.insertFirstNode(list_2, 6);
		list_2.insertFirstNode(list_2, 4);
		list_2.insertFirstNode(list_2, 2);

		/**
		 * @todo Call the functions that you want to test
		 * @date 2024/10/20
		 * @author Kaung Htet San
		 */
	}


	public static SinglyLinkedList mergeTwoSortedLinkedList(ListNode a, ListNode b) {

		ListNode dummy = new ListNode(0);
		
		ListNode tail = dummy;

		while (a != null && b != null) {

			if (a.value > b.value) {

				tail.next = b;
				b = b.next;

			} else {

				tail.next = a;
				a = a.next;
			}
			
			tail = tail.next;
		}

		if (a != null) {
			tail.next = a;
		} else {
			tail.next = b;
		}

		SinglyLinkedList mergedLL = new SinglyLinkedList();
		mergedLL.head = dummy.next;
		
		return mergedLL;
	}

	public void detectAndRemoveStartingLoopNode(SinglyLinkedList list) {

		ListNode fastPtr = list.head;
		ListNode slowPtr = list.head;

		while (fastPtr != null && fastPtr.next != null) {

			slowPtr = slowPtr.next;

			fastPtr = fastPtr.next.next;

			if (slowPtr == fastPtr) {

				ListNode current = list.head;

				while (current.next != slowPtr.next) {
					current = current.next;
					slowPtr = slowPtr.next;
				}

				slowPtr.next = null;

			}
		}

	}

	public SinglyLinkedList createLoopingLinkedList(SinglyLinkedList list) {
		
		list.head = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		ListNode fifth = new ListNode(5);

		list.head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = fourth;

		return list;
	}

	public boolean isLooping(SinglyLinkedList list) {

		ListNode fastPtr = list.head;
		ListNode slowPtr = list.head;

		while (fastPtr != null && fastPtr.next != null) {

			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;

			if (slowPtr == fastPtr) {
				return true;
			}
		}

		return false;
	}

	public void insertNewNodeInSortedLinkedList(SinglyLinkedList list, int nodeVal) {

		ListNode current = list.head;
		ListNode previous = null;

		while (current != null) {

			if (nodeVal < current.value) {
				ListNode new_node = new ListNode(nodeVal);
				new_node.next = current;
				previous.next = new_node;
			}

			previous = current;
			current = current.next;
		}
	}

	public void removeDuplicateNodes(SinglyLinkedList list) {

		ListNode current = list.head;

		while (current != null && current.next != null) {

			if (current.value == current.next.value) {
				current.next = current.next.next;
			}

			current = current.next;
		}

	}

	public int findNthNodeFromEnd(SinglyLinkedList list, int position) {

		ListNode current = list.head;
		ListNode pawn = list.head;

		int count = 1;

		while (count < position) {
			pawn = pawn.next;
			count++;
		}

		while (pawn.next != null) {
			current = current.next;
			pawn = pawn.next;
		}

		return current.value;

	}

	public void reverseLinkedList(SinglyLinkedList list) {

		ListNode current = list.head;
		ListNode previous = null;
		ListNode next = null;

		while (current != null) {

			next = current.next;

			current.next = previous;

			previous = current;

			current = next;
		}

	}

	public boolean searchNode(SinglyLinkedList list, int searchKey) {

		ListNode current = list.head;

		while (current != null) {

			if (current.value == searchKey) {
				return true;
			}

			current = current.next;
		}

		return false;
	}

	public void removeFirstNode(SinglyLinkedList list) {

		if (list.head == null) {
			return;
		}

		ListNode temp = list.head;
		list.head = list.head.next;
		temp.next = null;

	}

	public void removeLastNode(SinglyLinkedList list) {

		ListNode current = list.head;
		ListNode previous = null;

		while (current.next != null) {
			previous = current;
			current = current.next;
		}

		previous.next = null;
	}

	public void removeNodeAt(SinglyLinkedList list, int position) {

		if (position == 1) {

			ListNode remove_node = list.head;
			list.head = list.head.next;
			remove_node.next = null;

		} else {

			ListNode current = list.head;

			int count = 1;

			while (count < position - 1) {
				current = current.next;
				count++;
			}

			ListNode remove_node = current.next;
			current.next = remove_node.next;
			remove_node.next = null;
		}

	}

	public void insertFirstNode(SinglyLinkedList list, int nodeValue) {

		ListNode new_node = new ListNode(nodeValue);
		new_node.next = list.head;
		list.head = new_node;

	}

	public ListNode insertLastNode(SinglyLinkedList list, int nodeValue) {

		if (list.head == null) {
			list.head = new ListNode(nodeValue);
			return list.head;
		}

		ListNode current = list.head;

		while (current.next != null) {
			current = current.next;
		}

		ListNode new_node = new ListNode(nodeValue);
		current.next = new_node;

		return new_node;
	}

	public void insertNodeAt(SinglyLinkedList list, int nodeValue, int position) {

		ListNode new_node = new ListNode(nodeValue);

		if (position == 1) {
			new_node.next = list.head;
			list.head = new_node;
		}

		int count = 1;

		ListNode current = list.head;

		while (count < position - 1) {
			current = current.next;
			count++;
		}

		new_node.next = current.next;

		current.next = new_node;
	}

	public int getListCount(SinglyLinkedList list) {

		int count = 0;

		ListNode current = list.head;

		while (current != null) {
			current = current.next;
			count++;
		}

		return count;
	}

	public static void printAllListNodes(SinglyLinkedList list) {

		ListNode current = list.head;

		while (current != null) {
			System.out.print(current.value + " -> ");
			current = current.next;
		}

		System.out.println("null");
	}

}

class ListNode {

	public int value;
	public ListNode next;

	public ListNode(int value) {
		this.value = value;
		this.next = null;
	}

}
