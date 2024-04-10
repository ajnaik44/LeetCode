package com.crr.dsa.crackingtheinterview;

import com.crr.dsa.leetcode.ListNode;

public class LLValidPalindrome {
	public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        LLValidPalindrome solution = new LLValidPalindrome();
        boolean isPalindrome = solution.isPalindrome(head);
        System.out.println("Is the list a palindrome? " + isPalindrome);
    }
	 public boolean isPalindrome(ListNode head) {

	        if (head == null) return true;

	        // Find the end of first half and reverse second half.
	        ListNode firstHalfEnd = getMiddleNode(head);
	        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

	        // Check whether or not there is a palindrome.
	        ListNode p1 = head;
	        ListNode p2 = secondHalfStart;
	        boolean result = true;
	        while (result && p2 != null) {
	            if (p1.val != p2.val) result = false;
	            p1 = p1.next;
	            p2 = p2.next;
	        }        

	        // Restore the list and return the result.
	        firstHalfEnd.next = reverseList(secondHalfStart);
	        return result;
	    }
	 ListNode getMiddleNode(ListNode head){
	        ListNode slow =head;
	        ListNode fast =  head;
	        while(fast!=null &&  fast.next!=null &&  fast.next.next!=null)
	        {
	            slow = slow.next;
	            fast =  fast.next.next;
	        }
	        return slow;
	    }
	    ListNode reverseList(ListNode node)
	    {
	        ListNode prev = null;
	        ListNode current =  node;
	        while(current!=null)
	        {
	            ListNode nextNode =  current.next;
	            current.next = prev;
	            prev =  current;
	            current =  nextNode; 
	        }
	        return prev;
	    }
}
