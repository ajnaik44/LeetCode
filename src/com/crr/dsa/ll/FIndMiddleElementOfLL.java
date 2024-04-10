package com.crr.dsa.ll;

public class FIndMiddleElementOfLL {
public static void main(String[] args) {
	
	
	
	
	
	int r,sum=0,temp;    
	  int n=454;//It is the number variable to be checked for palindrome  
	  
	  temp=n;    
	  while(n>0){    
	   r=n%10;  //getting remainder 
	   System.out.println("palindrome  "+r);    
	   sum=(sum*10)+r;  
	   System.out.println("palindrome  "+sum);    
	   n=n/10;   
	   System.out.println("palindrome  "+n);    
	  }    
	  if(temp==sum)    
	   System.out.println("palindrome number ");    
	  else    
	   System.out.println("not palindrome");  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 // Test Case 1
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(9);
  

    ListNode listA = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    
    ListNode node5 = new ListNode(4);
    ListNode node6 = new ListNode(7);
    ListNode node7 = new ListNode(8);
    ListNode node8 = new ListNode(11);
    ListNode node9 = new ListNode(12);
    
    ListNode listb = node5;
    listb.next = node6;
    node6.next = node7;
    node7.next = node8;
    node8.next=node9;
   
    
    LLIntersection.printIntersectionList(reverseLLInPairs(listb));
    
 
    //System.out.println(listevenorodd(listA));
}

public static ListNode reverseLLInPairs(ListNode head) {
	if(head==null ||  head.next==null)
		return head;
	else {
		ListNode temp =  head.next;
		head.next =  temp.next;
		temp.next =head;
		head =temp;
		head.next.next =  reverseLLInPairs(head.next.next);
		return head;
	}
}

public static ListNode mergeListUsingRecursion(ListNode head1,ListNode head2) {
	if(head1==null)
		return head2;
	if(head2==null)
		return head1;
	
	ListNode  head =  new ListNode(0);
	if(head1.value<=head2.value)
	{
		head = head1;
		head.next =  mergeListUsingRecursion(head1.next, head2);
	}else {
		head = head2;
		head.next=mergeListUsingRecursion(head2.next, head1);
	}
	return head;
}

public static ListNode mergeList(ListNode listA,ListNode listb)
{
	 ListNode mergeSorted=null;
	    
	    ListNode temp1=listA;
	    ListNode temp2=listb;
	    
	    LLIntersection.printIntersectionList(temp1);
	    LLIntersection.printIntersectionList(temp2);
	    if(temp1.value>temp2.value)
		{
			
				mergeSorted =  new ListNode(temp2.value);
				temp2 =temp2.next;
		}else {
			mergeSorted =  new ListNode(temp1.value);
			temp1 =temp1.next;
		}
	   ListNode result =mergeSorted;
	    while(temp1!=null&& temp2!=null)
	    {
	    	if(temp1.value>temp2.value)
	    	{
	    			
	    				System.out.println(temp2.value);
	    				mergeSorted.next = new ListNode(temp2.value);
	    				temp2 =temp2.next;
	    			
	    	}else{
	    		System.out.println(temp1.value);
	    		mergeSorted.next =  new ListNode(temp1.value);
	    		temp1=temp1.next;
	    	}
	    	mergeSorted =mergeSorted.next;
	    }
	    System.out.println("====================================");
	    if(temp1!=null)
	    {
	    	while(temp1!=null)
	    	{
	    		System.out.println(temp1.value);
	    		mergeSorted.next=  new ListNode(temp1.value);
	    		temp1= temp1.next;
	    		mergeSorted =mergeSorted.next;
	    	}
	    }
	    if(temp2!=null)
	    {
	    	while(temp2!=null)
	    	{
	    		mergeSorted.next=  new ListNode(temp2.value);
	    		
	    		temp2= temp2.next;
	    		mergeSorted =mergeSorted.next;
	    	}
	    }
	    return result;
}
public static int listevenorodd(ListNode head) {
	int counter=0;
	ListNode temp=head;
	while(temp!=null&&temp.next!=null)
	{
		temp=temp.next.next;
		
	}
	if(temp==null)
		return 0;
	return 1;
}
public static void printLLFromEndt(ListNode listNode) {
	if(listNode==null)
	{
		
		return;
	}
	printLLFromEndt(listNode.next);
	System.out.println(listNode.value);
}
public static ListNode findMiddleElement(ListNode listNode)
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
}
