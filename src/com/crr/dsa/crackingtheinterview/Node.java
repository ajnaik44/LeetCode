package com.crr.dsa.crackingtheinterview;

public class Node {
    Node next = null;
    int data;

    public Node(int d) {
        data = d;
    }
    public static void printList(Node node) {
        Node current = node;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

}
