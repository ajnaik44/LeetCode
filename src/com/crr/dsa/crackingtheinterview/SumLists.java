package com.crr.dsa.crackingtheinterview;

public class SumLists {
	public static Node sumListByAjay(Node node1, Node node2) {
		if (node1 == null)
			return null;
		Node result = null;

		Node temp = new Node(node1.data + node2.data);
		System.out.println(temp.data);
		result = temp;
		Node resul1 = result;
		node1 = node1.next;
		node2 = node2.next;
		while (node1 != null) {
			if (result.data > 10) {
				int remainder = result.data / 10;
				if (remainder != 0) {
					result.data = result.data % 10;
					if (node1.data + remainder < 10)
						node1.data = node1.data + remainder;
					else if (node2.data + remainder < 10)
						node2.data = node2.data + remainder;

				}

			}
			temp = new Node(node1.data + node2.data);
			System.out.println(temp.data);
			result.next = temp;
			result = result.next;
			node1 = node1.next;
			node2 = node2.next;

		}
		return resul1;
	}

	static Node addLists(Node l1, Node l2, int carry, Node res) {
		if (l1 != null && l2 != null) {
			int remainder = l1.data + l2.data + carry;
			if (res == null) {

				res = new Node(remainder % 10);
			} else {

				res.next = new Node(remainder % 10);
				
			}
			System.out.println(res.data);
			res.next = addLists(l1.next, l2.next, remainder / 10, res.next);
		}
		return res;

	}

	public static void main(String[] args) {
		Node head1 = new Node(7);
		head1.next = new Node(1);
		head1.next.next = new Node(6);

		Node head2 = new Node(5);
		head2.next = new Node(9);
		head2.next.next = new Node(2);
		
		Node res = null;
		
		Node result = addLists(head1, head2, 0, res);
		Node.printList(result);

	}

}
