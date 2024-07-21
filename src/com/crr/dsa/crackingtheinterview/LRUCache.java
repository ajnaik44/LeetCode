package com.crr.dsa.crackingtheinterview;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
   class Node{
	   int key;
	   int value;
	   public Node(int key, int value) {
		// TODO Auto-generated constructor stub
		   this.key =  key;
		   this.value= value;
	}
	   Node next;
	   Node prev;
	   
   }
   
   Map<Integer,Node> cache =  new HashMap<Integer,Node>();
   Node head;
   Node tail;
   int capacity=2;
   public LRUCache(int capacity) {
	// TODO Auto-generated constructor stub
	   this.capacity = capacity;
	   head = new Node(-1,-1);
	   tail =  new Node(-1,-1);
	   head.next = tail;
	   tail.prev = head;
   }
   
   public void put(int key, int value)
   {
	   if(this.cache.containsKey(key))
	   {
		   remove(key);   
	   }
	   if(this.cache.size()==this.capacity)
	   {
		   remove(this.tail.prev.key);
	   }
	   Node node = new Node(key,value);
	   this.cache.put(key, node);
	   add(node);
   }
   public void add(Node node)
   {
	   node.next =  head.next;
	   node.next.prev =  node;
	   head.next =  node;
	   node.prev =  head;
   }
   public void  remove(int key)
   {
	   if(this.cache.containsKey(key))
	   {
		   Node delete =  this.cache.get(key);
		   Node prev =  delete.prev;
		   Node next =  delete.next;
		   prev.next =  next;
		   next.prev = prev;
		   this.cache.remove(key);
		   
	   }
   }
   public int get(int i)
   {
	   if(this.cache.containsKey(i))
	   {
		   remove(i);
		   put(i, i);
		   return i;
	   }
	   return -1;
   }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        
        lruCache.put(1, 1); // Cache: {1=1}
        lruCache.put(2, 2); // Cache: {1=1, 2=2}
        System.out.println(lruCache.get(1)); // returns 1
        lruCache.put(3, 3); // Evicts key 2, Cache: {1=1, 3=3}
        System.out.println(lruCache.get(2)); // returns -1 (not found)
        lruCache.put(4, 4); // Evicts key 1, Cache: {3=3, 4=4}
        System.out.println(lruCache.get(1)); // returns -1 (not found)
        System.out.println(lruCache.get(3)); // returns 3
        System.out.println(lruCache.get(4)); // returns 4
    }
}

