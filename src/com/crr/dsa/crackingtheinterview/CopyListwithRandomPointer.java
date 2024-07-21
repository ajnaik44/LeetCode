package com.crr.dsa.crackingtheinterview;

import java.util.HashMap;

public class CopyListwithRandomPointer {
	  public Node copyRandomListRecusion(Node head) {

		    if (head == null) {
		      return null;
		    }

		    // If we have already processed the current node, then we simply return the cloned version of
		    // it.
		    if (this.visitedHash.containsKey(head)) {
		      return this.visitedHash.get(head);
		    }

		    // Create a new node with the value same as old node. (i.e. copy the node)
		    Node node = new Node(head.val);

		    // Save this value in the hash map. This is needed since there might be
		    // loops during traversal due to randomness of random pointers and this would help us avoid
		    // them.
		    this.visitedHash.put(head, node);

		    // Recursively copy the remaining linked list starting once from the next pointer and then from
		    // the random pointer.
		    // Thus we have two independent recursive calls.
		    // Finally we update the next and random pointers for the new node created.
		    node.next = this.copyRandomList(head.next);
		    node.random = this.copyRandomList(head.random);

		    return node;
		  }
	// Definition for a Node.
	static class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}
	HashMap<Node, Node> visitedHash = new HashMap<>();
	HashMap<Node, Node> map = new HashMap<>();

	public Node copyRandom(Node head) {
		if (head != null) {
			if (this.map.containsKey(head))
				return this.map.get(head);
			else {
				Node newNode = new Node(head.val);
				this.map.put(head, newNode);
				return newNode;
			}
		}
		return null;
	}

	public Node copyRandomList(Node head) {
		if (head == null)
			return head;
		Node oldNode = head;
		Node newNode = new Node(oldNode.val);
		map.put(oldNode, newNode);
		while (oldNode != null) {
			newNode.random = copyRandom(oldNode.random);
			newNode.next = copyRandom(oldNode.next);
			newNode = newNode.next;
			oldNode = oldNode.next;
		}
		return this.map.get(head);
	}

	public static void main(String[] args) {
		// Example usage
		CopyListwithRandomPointer solution = new CopyListwithRandomPointer();

		// Creating the original linked list
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.random = head.next.next;
		head.next.random = head;

		// Copying the linked list
		Node copiedHead = solution.copyRandomList(head);

		// Printing the copied linked list
		while (copiedHead != null) {
			System.out.print("Value: " + copiedHead.val);
			if (copiedHead.random != null)
				System.out.print(", Random Value: " + copiedHead.random.val);
			else
				System.out.print(", Random: null");
			System.out.println();
			copiedHead = copiedHead.next;
		}
	}

}
