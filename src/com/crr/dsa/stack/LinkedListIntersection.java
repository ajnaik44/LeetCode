package com.crr.dsa.stack;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListIntersection {

    public static ListNode findIntersection(ListNode head1, ListNode head2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        // Push nodes from list1 onto stack1
        ListNode current1 = head1;
        while (current1 != null) {
            stack1.push(current1);
            current1 = current1.next;
        }

        // Push nodes from list2 onto stack2
        ListNode current2 = head2;
        while (current2 != null) {
            stack2.push(current2);
            current2 = current2.next;
        }

        ListNode intersection = null;

        // Pop nodes from stacks and find the intersection point
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            ListNode node1 = stack1.pop();
            ListNode node2 = stack2.pop();

            if (node1 == node2) {
                intersection = node1; // Update the intersection point
            } else {
                break; // Stop when the nodes are different
            }
        }

        return intersection;
    }

    public static void main(String[] args) {
        // Create sample linked lists with an intersection
        ListNode commonNode = new ListNode(7);
        commonNode.next = new ListNode(8);

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = commonNode;

        ListNode head2 = new ListNode(3);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(5);
        head2.next.next.next = commonNode;

        ListNode intersection = findIntersection(head1, head2);

        if (intersection != null) {
            System.out.println("Intersection point: " + intersection.val);
        } else {
            System.out.println("No intersection found.");
        }
    }
}

