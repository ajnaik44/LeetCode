package com.crr.dsa.crackingtheinterview;

public class IntersectionLinkedList {
	public static class Intersection {
		Node result;
		Node p1;
		Node p2;
		boolean allNodesAreEqual;

		public Intersection(Node result, Node p1, Node p2,boolean allNodesAreEqualValue) {
			super();
			this.result = result;
			this.p1 = p1;
			this.p2 = p2;
			this.allNodesAreEqual =  allNodesAreEqualValue;
		}

	}

	public static int findSize(Node node) {
		int size = 0;
		Node p1 = node;
		while (p1 != null) {
			size++;
			p1 = p1.next;
		}
		return size;
	}

	public static Node findIntersection(Node p1, Node p2) {
		int p1Size = findSize(p1);
		int p2Size = findSize(p2);
		if (p1Size > p2Size) {
			for (int i = 0; i <= (p1Size - p2Size); i++) {
				p1 = p1.next;
			}
		} else if (p2Size > p1Size) {
			for (int i = 0; i <= (p2Size - p1Size); i++) {
				p2 = p2.next;
			}
		}
		
		while( p1!=null || p2!=null)
		{
			Intersection intersection = checkIntersection(p1, p2);
			if (intersection.result == null)
				return null;
			p1 = intersection.p1;
			p2 = intersection.p2;
			Intersection allNodes  = checkAllNodesAreEqual(p1, p2);
			System.out.println(allNodes.allNodesAreEqual);
			 if(allNodes.allNodesAreEqual)
				 return intersection.result;
			p1 = allNodes.p1;
			p2 = allNodes.p2;
	
			
		}
		

		return  null;

	}

	public static Intersection checkAllNodesAreEqual(Node p1, Node p2) {
		while (p1 != null && p2 != null) {
			if (p1.data != p2.data)
				return new Intersection(null, p1, p2,false);
			p1 = p1.next;
			p2 = p2.next;
		}
		return new Intersection(null, p1, p2,true);
	}

	public static Intersection checkIntersection(Node p1, Node p2) {
		while (p1 != null && p2 != null) {
			if (p1.data == p2.data) {
				return new Intersection(p1, p1, p2,false);
			}
			p1 = p1.next;
			p2 = p2.next;
		}
		return new Intersection(null, p1, p2,false);
	}

	public static void main(String[] args) {
		// Create linked lists for testing
		Node commonNode = new Node(7);
		commonNode.next = new Node(2);
		commonNode.next.next = new Node(1);

		Node p1 = new Node(3);
		p1.next = new Node(1);
		p1.next.next = new Node(5);
		p1.next.next.next = commonNode;

		Node p2 = new Node(5);
		p2.next = new Node(1);
		p2.next.next = new Node(2);
		p2.next.next.next = commonNode;

		Node intersection = findIntersection(p1, p2);

		if (intersection != null) {
			System.out.println("Intersection Node Data: " + intersection.data);
		} else {
			System.out.println("No Intersection Found");
		}
	}
}
