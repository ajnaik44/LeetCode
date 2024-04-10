package com.crr.dsa.ll;

import java.util.ArrayList;

public class GetJosephusPosition {
	public static CIrcularSLL.Node getJosephusPotition(int N, int M) {
		CIrcularSLL cIrcularSLL = new CIrcularSLL();

		cIrcularSLL.add(1);
		for (int i = 2; i <= N; i++) {
			cIrcularSLL.add(i);
		}
		CIrcularSLL.Node p = cIrcularSLL.head;
		for (int count = N; count > 1; --count) {
			for (int i = 0; i < M - 1; i++)
				p = p.next;
			p.next = p.next.next;
		}
		return p;
	}
	
	public static ListNode rotateListbyKPlaces(ListNode head, int k) {
	    if (head == null || k <= 0) {
	        return head;
	    }
	    
	    ListNode slowPtr = head;
	    ListNode fastPtr = head;
	    ListNode previousPtr = slowPtr;
	    int i = k;
	    
	    while (fastPtr != null && fastPtr.next != null) {
	        previousPtr = slowPtr;
	        slowPtr = slowPtr.next;
	        while (fastPtr.next != null && i > 0) {
	            fastPtr = fastPtr.next;
	            i--;
	        }
	        i = k;
	    }
	    
	    if (slowPtr == fastPtr) {
	        return head;  // No need to rotate, k is a multiple of list length
	    }
	    
	    previousPtr.next = null;
	    fastPtr.next = head;
	    
	    return slowPtr;
	}
public static ListNode removeDuplicates(ListNode head) {
		
		ListNode temphead =  head;
		while(temphead!=null)
		{
			ListNode tempprev = temphead;
			ListNode tempNext =  temphead.next;
			
			while(tempNext!=null)
			{
				if(tempprev.value ==  tempNext.value)
				{
					tempprev.next =  tempNext.next;
				}
				 tempNext =  tempNext.next;
				 tempprev = tempNext;
			}
			temphead =temphead.next;
		}
		System.out.println(head.value);
		return head;
	}

	public static void main(String[] args) {
		
		// Test Case 1
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(6);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(3);

		ListNode node7 = new ListNode(3);
		ListNode listA = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		LLIntersection.printIntersectionList(listA);
		LLIntersection.printIntersectionList(removeDuplicates(listA));
		
		
		
		/*
		 * // TODO Auto-generated method stub System.out.println(getJosephusPotition(5,
		 * 2).data);
		 * 
		 * ArrayList<Integer> list = new ArrayList<>(); for(int i=0;i<10;i++)
		 * list.add(i,i); for(int j=0;j<10;j++) list.remove(10-j-1);
		 */
		
	}

}
