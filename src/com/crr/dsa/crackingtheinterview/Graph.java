package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class Graph {
	static class Node {
	    public int val;
	    public List<Node> neighbors;

	    public Node() {
	        val = 0;
	        neighbors = new ArrayList<>();
	    }

	    public Node(int _val) {
	        val = _val;
	        neighbors = new ArrayList<>();
	    }

	    public Node(int _val, ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        if (visited.containsKey(node))
            return visited.get(node);

        Node newNode = new Node(node.val);
        visited.put(node, newNode);

        for (Node neighbor : node.neighbors)
            newNode.neighbors.add(cloneGraph(neighbor));

        return newNode;
    }

    public static void main(String[] args) {
        // Create a sample graph
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node3);
        node3.neighbors.add(node1);
        node3.neighbors.add(node4);

        // Clone the graph
        Graph graphClone = new Graph();
        Node clonedNode = graphClone.cloneGraph(node1);

        // Print the original and cloned graph
        System.out.println("Original Graph: ");
        Set<Node> visited = new HashSet<>();
        printGraph(node1, visited);
     
       visited = new HashSet<>();
        System.out.println("\nCloned Graph: ");
        printGraph(clonedNode, visited);
        
        
        
        
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(2);
        
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        
        arr.add(4);
      
        arr.add(5);
      
        
        int key = 3;

        int lowIndex = findLowIndexTemp(arr, key);
        int highIndex = findHighIndexTemp(arr, key);

        System.out.println("Lowest index of " + key + ": " + lowIndex);
        System.out.println("Highest index of " + key + ": " + highIndex);
        
    }
    
    
    static int findHighIndexTemp(List<Integer> arr, int key) {
        int low = 0;
        int high = arr.size() - 1;
        int mid = high / 2;

        while (low <= high) {
      
          int mid_elem = arr.get(mid);
      
          if (mid_elem <= key) {
            low = mid + 1;
          }
          else {
            high = mid - 1;
          }

          mid = low + (high - low) / 2;
        }
        
        if(high == -1){
          return high;
        }
        
        if (high < arr.size() && arr.get(high) == key) {
          return high;
        }

        return -1;
      }
    static int findLowIndexTemp (List<Integer> arr, int key) {
        int low = 0;
        int high = arr.size() - 1;
        int mid = high / 2;
      
        while (low <= high) {

          int mid_elem = arr.get(mid);

          if (mid_elem < key) {
            low = mid + 1;
          }
          else {
          high = mid - 1;
          }
      
          mid = low + (high - low) / 2;
        }

        if (low < arr.size() && arr.get(low) == key) {
          return low;
        }

        return -1;
      }
    private static void printGraph(Node node, Set<Node> visited) {
        if (node == null || visited.contains(node))
            return;

        visited.add(node);
        System.out.print("Node " + node.val + " Neighbors: ");
        for (Node neighbor : node.neighbors)
            System.out.print(neighbor.val + " ");
        System.out.println();

        for (Node neighbor : node.neighbors)
            printGraph(neighbor, visited);
    }
    
    static int findKey(List<Integer> arr, int key,int low,int high )
    {
      if(low>high)
        return -1;
      int mid = (low+high)/2;
      if(arr.get(mid)==key)
        return mid;
      else if(key > arr.get(mid)  )
          return findKey(arr,key,mid+1,high);
      else
         return findKey(arr,key,low,mid-1);   
    }

    static int findLowIndex(List<Integer> arr, int key) {
      System.out.println(arr.size());
      int keyIndex =  findKey(arr,key,0,arr.size());
      System.out.println(keyIndex);
      if(keyIndex==-1)
      return keyIndex;
      
      int i=keyIndex;
      for(;i>=0 && arr.get(i)==key  ;i--)
    	  continue;
      if(keyIndex==1)
    	  return keyIndex;
      return i+1;
    }

    static int findHighIndex(List<Integer> arr, int key) {
    
      int keyIndex =  findKey(arr,key,0,arr.size());
       if(keyIndex==-1)
      return keyIndex;
     
      int i=keyIndex;
      for(; i< arr.size() && arr.get(i)==key   ;i++)
    	  continue;
      if(keyIndex==1)
    	  return keyIndex;
      return i-1;
    }
}
