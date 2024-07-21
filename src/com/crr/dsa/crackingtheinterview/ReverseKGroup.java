package com.crr.dsa.crackingtheinterview;

import com.crr.dsa.leetcode.ListNode;

public class ReverseKGroup {
	public static void main(String[] args) {
		  ListNode head = new ListNode(1);
	        head.next = new ListNode(2);
	        head.next.next = new ListNode(3);
	        head.next.next.next = new ListNode(4);
	        head.next.next.next.next = new ListNode(5);
	        print(new ReverseKGroup().reverseKGroupApproach1(head, 2));
	       
	}
public ListNode reverseLinkedList(ListNode head, int k) {
        
        // Reverse k nodes of the given linked list.
        // This function assumes that the list contains 
        // atleast k nodes.
        ListNode new_head = null;
        ListNode ptr = head;
        
        while (k > 0) {
            
            // Keep track of the next node to process in the
            // original list
            ListNode next_node = ptr.next;
            
            // Insert the node pointed to by "ptr"
            // at the beginning of the reversed list
            ptr.next = new_head;
            new_head = ptr;
            
            // Move on to the next node
            ptr = next_node;
            
            // Decrement the count of nodes to be reversed by 1
            k--;
        }
            
            
        // Return the head of the reversed list
        return new_head;
    
    }
            
    public ListNode reverseKGroupApproach1(ListNode head, int k) {
        
        ListNode ptr = head;
        ListNode ktail = null;
        
        // Head of the final, moified linked list
        ListNode new_head = null;
        
        // Keep going until there are nodes in the list
        while (ptr != null) {
            
            int count = 0;
            
            // Start counting nodes from the head
            ptr = head;
            
            // Find the head of the next k nodes
            while (count < k && ptr != null) {
                ptr = ptr.next;
                count += 1;
            }

            // If we counted k nodes, reverse them        
            if (count == k) {
                
                // Reverse k nodes and get the new head
                ListNode revHead = this.reverseLinkedList(head, k);
                
                // new_head is the head of the final linked list
                if (new_head == null)
                    new_head = revHead;
                
                // ktail is the tail of the previous block of 
                // reversed k nodes
                if (ktail != null)
                    ktail.next = revHead;
                    
                ktail = head; 
                head = ptr;
            }
        }
            
         // attach the final, possibly un-reversed portion
        if (ktail != null)
            ktail.next = head;
        
        return new_head == null ? head : new_head;
    }
	public ListNode reverseKGroup(ListNode head, int k) 
    {
        if(head==null ||  head.next==null)
            return head;
        ListNode current =  head;
        int totalIteration =totalNodes(head)/k;
        return reverse(current, k, totalIteration);


    }
    public ListNode reverse(ListNode node,int k,int iteration)
    {
        if(iteration<=0)
        {
            return node;
        }
        ListNode prev=null;;
        ListNode current =  node;
        ListNode newNode=null;
        int temp=k;
        while(current!=null && temp>0)
        {
            newNode =  current.next;
            current.next = prev;
            prev =  current;
            current=newNode;
            temp--;
        }
        iteration--;
        if(prev!=null){
        node.next =  newNode;
     //   prev.next = node;
        print(prev);
        node.next= reverse(node.next,k,iteration);
        }
        return prev;

    }
    public static void print(ListNode node)
    {
        ListNode current = node;
        while(current!=null)
        {
            System.out.print(current.val+ "  ");
            current =  current.next;
        }
         System.out.println("  ");
    }
    public int totalNodes(ListNode head)
    {
        ListNode current = head;
        int total =0;
        while(current!=null)
        {
            total++;
            current= current.next;
        }
        return total;
    }
}
