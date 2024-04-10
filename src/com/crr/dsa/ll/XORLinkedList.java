package com.crr.dsa.ll;
class Node {
    int val;
    Node both; // XOR of prev and next nodes

    Node(int val) {
        this.val = val;
        this.both = null;
    }
}

public class XORLinkedList {
    private Node head;

    public XORLinkedList() {
        head = null;
    }

    // Helper method to calculate the XOR of two node addresses
    private Node xor(Node a, Node b) {
        return new Node(a.val ^ b.val);
    }

    // Insert a new node at the beginning of the list
    public void insert(int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
        } else {
            newNode.both = head;
            head.both = xor(newNode, head.both);
            head = newNode;
        }
    }

    // Traverse the linked list
    public void traverse() {
        Node current = head;
        Node prev = null;
        Node next;
        
        while (current != null) {
            System.out.print(current.val + " ");
            next = xor(prev, current.both);
            prev = current;
            current = next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        XORLinkedList list = new XORLinkedList();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        System.out.println("Linked List contents:");
        list.traverse(); // Output: 4 3 2 1
    }
}

