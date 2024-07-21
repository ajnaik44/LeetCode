package com.crr.dsa.crackingtheinterview;

import com.crr.dsa.leetcode.ListNode;

public class ListMerge {
	private static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }
	 // Helper method to print a linked list
    private static void printLinkedList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
	public static void main(String[] args) {
        // Create sample linked lists
        ListNode[] lists = new ListNode[3];
        lists[0] = createLinkedList(new int[]{1, 4, 5});
        lists[1] = createLinkedList(new int[]{1, 3, 4});
        lists[2] = createLinkedList(new int[]{2, 6});

        // Merge the lists
        ListMerge solution = new ListMerge();
        ListNode mergedList = solution.mergeKLists(lists);

        // Print the merged list
        printLinkedList(mergedList);
    }

	public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKListsHelper(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start + 1 == end) {
            return merge(lists[start], lists[end]);
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeKListsHelper(lists, start, mid);
        ListNode right = mergeKListsHelper(lists, mid + 1, end);
        return merge(left, right);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        curr.next = (l1 != null) ? l1 : l2;
        
        return dummy.next;
    }
}
