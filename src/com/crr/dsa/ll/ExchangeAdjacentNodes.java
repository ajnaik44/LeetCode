package com.crr.dsa.ll;

public class ExchangeAdjacentNodes {
	public static ListNode middleNode(ListNode listNode)
	{
		ListNode sigleStep,doubleStep =  listNode;
		sigleStep = listNode;
		int i=0;
		while(listNode!=null&&doubleStep.next!=null)
		{
			if(i==0) {
				doubleStep =  doubleStep.next;
				i=1;
			}else if(i==1) {
				doubleStep =doubleStep.next;
				sigleStep = sigleStep.next;
				i=0;
				
				
			}
		}
		return sigleStep;
	}
	
	public static ListNode exchangeAdjacentNodesbyMe(ListNode head)
	{	
		ListNode  temp =  new ListNode(0);
		temp.next=head;
		ListNode current=head;
		ListNode prev= temp;
		while(current!=null && current.next!=null)
		{
			ListNode tmp = current.next.next;
			current.next.next= prev.next;
			prev.next =  current.next;
			current.next = tmp;
			prev =  current;
			current = current.next;
		}
		return temp.next;
	}
	
public static void main(String[] args) {
	 // Test Case 1
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
   
  

    ListNode listA = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next =  node4;
   LLIntersection.printIntersectionList(listA);
   LLIntersection.printIntersectionList(exchangeAdjacentNodesbyMe(listA));
}
public static ListNode exchangeAdjacentNodes(ListNode head)
{
	ListNode  temp = new ListNode(0);
	temp.next =  head;
	ListNode prev = temp, curr = head;
	while(curr!=null && curr.next!=null)
	{
		ListNode tmp =  curr.next.next;
		curr.next.next = prev.next;
		prev.next =  curr.next;
		curr.next = tmp;
		prev=curr;
		curr =  curr.next;
		
	}
	return temp.next;
}
}
