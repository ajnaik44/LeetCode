package com.crr.dsa.crackingtheinterview;

public class InsertintoaSortedCircularLinkedList {
	
	public static void main(String[] args) {
		Node node = new Node(1);
		node.next = new Node(3);
		node.next.next = new Node(5,node);
		Node result =  new InsertintoaSortedCircularLinkedList().insert(node, 0);
		Node.printList(result);
		if (result instanceof Node) {
		    System.out.println("result is an instance of Node");
		} else {
		    System.out.println("result is not an instance of Node");
		}
	}
	
	
	 public Node insert(Node head, int insertVal) {
	        if(head==null)
	        {
	            Node node = new Node(insertVal);
	            node.next =node;
	            return node;
	        }
	       
	        Node prev =  head;
	        Node current =  head.next;

	 boolean insert = false;
	        do{
	           
	            if(prev.data <=  insertVal && insertVal <= current.data )
	                insert = true;
	            else if(prev.data>  current.data )
	              {
	                if(insertVal>=  prev.data ||  insertVal <=  current.data)
	                    insert=true;
	              }
	            if(insert)
	            {
	            	prev.next = new Node(insertVal,current);
	               
	                return head;
	            }
	            prev =  prev.next;
	            current =  current.next;
	        }
	        while(prev != head );

	        prev.next = new Node(insertVal,current);
	        return head;

	    }
	   
}
