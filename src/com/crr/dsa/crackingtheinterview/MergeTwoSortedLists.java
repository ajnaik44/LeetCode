package com.crr.dsa.crackingtheinterview;

public class MergeTwoSortedLists {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
	    // Handle edge cases where one of the lists is null
	    if (list1 == null)
	        return list2;
	    if (list2 == null)
	        return list1;
	    
	    ListNode dummy = new ListNode(0); // Dummy node to simplify code
	    ListNode current = dummy; // Pointer to current node in the merged list
	    
	    ListNode l1 = list1;
	    ListNode l2 = list2;
	    
	    // Traverse both lists and merge them
	    while (l1 != null && l2 != null) {
	        if (l1.val < l2.val) {
	            current.next = l1;
	            l1 = l1.next;
	        } else {
	            current.next = l2;
	            l2 = l2.next;
	        }
	        current = current.next;
	    }
	    
	    // Attach remaining nodes of list1 or list2, if any
	    if (l1 != null) {
	        current.next = l1;
	    } else {
	        current.next = l2;
	    }
	    
	    return dummy.next; // Return the merged list starting from the next of dummy node
	}

	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(2);
		list1.next.next = new ListNode(4);
		
		
		ListNode list2 = new ListNode(1); 
		list2.next = new ListNode(3);
		list2.next.next = new ListNode(4);
		
		ListNode res =  mergeTwoLists(list1,list2);
		while(res!=null)
		{
			System.out.print(res.val + "  ");
			res = res.next;
		}
		
	}
}
