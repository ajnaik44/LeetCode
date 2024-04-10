package com.crr.dsa.ll;

import java.util.HashMap;

public class LLIntersection {

    public static ListNode findIntersectionUsingHashMap(ListNode listA, ListNode listB) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    ListNode  temp =  listA;
    while(temp!=null   )
    {
    	if(hashMap.get(temp.value)==null)
    	{
    		hashMap.put(temp.value,1);
    		temp=  temp.next;
    	}
    	else {
    		hashMap.put(temp.value,hashMap.get(temp.value)+1);
    	}
    }
    temp = listB;
    while(temp!=null   )
    {
    	if(hashMap. get(temp.value)==null)
    	{
    		hashMap.put(temp.value,1);
    		temp=  temp.next;
    	}
    	else if(hashMap.containsKey(temp.value)){
    		
    			return temp;
    		
    	}
    }
    return null;
    }
    public static void printIntersectionList(ListNode intersectionNode) {
		/*
		 * if (intersectionNode == null) { System.out.println("No intersection");
		 * return; }
		 */
        ListNode current = intersectionNode;
        System.out.print(" List: ");
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static ListNode findIntersection(ListNode listA, ListNode listB) {
        int lengthA = getLinkedListLength(listA);
        int lengthB = getLinkedListLength(listB);
        int diff = Math.abs(lengthA - lengthB);

        ListNode tempA = listA;
        ListNode tempB = listB;

        // Traverse the longer list by the difference in lengths
        if (lengthA > lengthB) {
            for (int i = 0; i < diff; i++) {
                tempA = tempA.next;
            }
        } else if (lengthB > lengthA) {
            for (int i = 0; i < diff; i++) {
                tempB = tempB.next;
            }
        }

        // Traverse both lists simultaneously to find the intersection node
        while (tempA != null && tempB != null) {
            if (tempA == tempB) {
                return tempA; // Found the intersection node
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return null; // No intersection found
    }

    private static int getLinkedListLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public static void main(String[] args) {
        // Test Case 1
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(1);

        ListNode listA = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);

        ListNode listB = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node5;
        printIntersectionList(listA);
        printIntersectionList(listB);
        ListNode intersection1 = findIntersection(listA, listB);
        System.out.println("Intersection Point: Node with value " + intersection1.value);

        // Test Case 2
        ListNode node10 = new ListNode(10);
        ListNode node20 = new ListNode(20);
        ListNode node30 = new ListNode(30);
        ListNode node40 = new ListNode(40);
        ListNode node50 = new ListNode(50);
        ListNode node60 = new ListNode(60);

        ListNode listC = node10;
        node10.next = node20;
        node20.next = node30;
        node30.next = node40;
        node40.next = node50;
        node50.next = node60;

        ListNode node70 = new ListNode(70);
        ListNode node80 = new ListNode(80);

        ListNode listD = node70;
        node70.next = node80;
        node80.next = node50;
        node50.next = node60;
        printIntersectionList(listC);
        printIntersectionList(listD);
        ListNode intersection2 = findIntersection(listC, listD);
        System.out.println("Intersection Point: Node with value " + intersection2.value);

        // Test Case 3
        ListNode node3_1 = new ListNode(3);
        ListNode node7_1 = new ListNode(7);
        ListNode node10_1 = new ListNode(10);
        ListNode node15 = new ListNode(15);

        ListNode listE = node3_1;
        node3_1.next = node7_1;
        node7_1.next = node10_1;
        node10_1.next = node15;

        ListNode node99 = new ListNode(99);
        ListNode node1_1 = new ListNode(1);
        ListNode node5_1 = new ListNode(5);

        ListNode listF = node99;
        node99.next = node1_1;
        node1_1.next = node5_1;
        node5_1.next = node10_1;
        node10_1.next = node15;
        printIntersectionList(listE);
        printIntersectionList(listF);
        ListNode intersection3 = findIntersection(listE, listF);
        System.out.println("Intersection Point: Node with value " + intersection3.value);

        // Test Case 4
        ListNode node4_1 = new ListNode(4);
        ListNode node8_1 = new ListNode(8);
        ListNode node15_1 = new ListNode(15);
        ListNode node25 = new ListNode(25);

        ListNode listG = node4_1;
        node4_1.next = node8_1;
        node8_1.next = node15_1;
        node15_1.next = node25;

        ListNode node9 = new ListNode(9);

        ListNode listH = node9;
        node9.next = node15_1;
        node15_1.next = node25;
        printIntersectionList(listG);
        printIntersectionList(listH);
        ListNode intersection4 = findIntersection(listG, listH);
        System.out.println("Intersection Point: Node with value " + intersection4.value);

            }
}
