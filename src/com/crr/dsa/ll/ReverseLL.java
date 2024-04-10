package com.crr.dsa.ll;

 class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }
}

public class ReverseLL {
    public static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode nextNode;

        while (current != null) {
            nextNode = current.next; // Save the next node
            current.next = prev; // Reverse the next pointer
            prev = current; // Move prev to current node
            current = nextNode; // Move current to next node
        }

        // 'prev' will be the new head of the reversed list
        return prev;
    }
    public static ListNode reverseLinkedListUsingRecursion(ListNode head) {
        if (head == null || head.next == null) {
            // Base case: If the list is empty or has only one node, return head as is.
            return head;
        }

        // Reverse the rest of the linked list from the next node.
        ListNode reversedRest = reverseLinkedListUsingRecursion(head.next);

        // Reverse the next pointer of the current node to point to the previous node.
        head.next.next = head;
        head.next = null; // Set the next pointer of the current node to null to avoid cycles.

        return reversedRest;
    }


    // Helper method to print the linked list
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage:
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original Linked List:");
        printLinkedList(head);

        head = reverseLinkedList(head);

        System.out.println("Reversed Linked List:");
        printLinkedList(head);
    }
}
