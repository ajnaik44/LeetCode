package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.List;

import com.crr.dsa.leetcode.ListNode;


public class ReorderList {
	static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode() {}
		      TreeNode(int val) { this.val = val; }
		      TreeNode(int val, TreeNode left, TreeNode right) {
		          this.val = val;
		          this.left = left;
		          this.right = right;
		      }
		  }
	public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList();
        StringBuilder sb = new StringBuilder();
        binaryTreePaths( root, result, sb);
        return result;
    }
	private static void binaryTreePaths(TreeNode root, List<String> result, StringBuilder sb) {
        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            result.add(sb.toString());
        } else {
            sb.append("->");
            if (root.left != null)
                binaryTreePaths(root.left, result, sb);
            if (root.right != null)
                binaryTreePaths(root.right, result, sb);
        }
        sb.setLength(len);
    }
	public static void main(String[] args) {
		
		
		
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.right =  new TreeNode(5);
		root.right = new TreeNode(3);
		System.out.println(binaryTreePaths(root));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        
        StringBuilder sb = new StringBuilder();


        reorderList(head);

        // Printing the reordered list
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
		  public static void reorderList(ListNode head) {
		    if (head == null) return;

		    // find the middle of linked list [Problem 876]
		    // in 1->2->3->4->5->6 find 4 
		    ListNode slow = head, fast = head;
		    while (fast != null && fast.next != null) {
		      slow = slow.next;
		      fast = fast.next.next;
		    }

		    // reverse the second part of the list [Problem 206]
		    // convert 1->2->3->4->5->6 into 1->2->3->4 and 6->5->4
		    // reverse the second half in-place
		    ListNode prev = null, curr = slow, tmp;
		    while (curr != null) {
		      tmp = curr.next;

		      curr.next = prev;
		      prev = curr;
		      curr = tmp;
		    }

		    // merge two sorted linked lists [Problem 21]
		    // merge 1->2->3->4 and 6->5->4 into 1->6->2->5->3->4
		    ListNode first = head, second = prev;
		    while (second.next != null) {
		      tmp = first.next;
		      first.next = second;
		      first = tmp;

		      tmp = second.next;
		      second.next = first;
		      second = tmp;
		    }
		  }
		
}
