
package com.crr.dsa.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

class Node_New implements Comparable<Node_New> {
    int vertex;
    int weight;

    public Node_New(int v, int w) {
        this.vertex = v;
        this.weight = w;
    }

    public Node_New() {}

    @Override
    public int compareTo(Node_New other) {
        if (this.weight < other.weight) {
            return -1;
        } else if (this.weight > other.weight) {
            return 1;
        }
        return 0;
    }
}
public class DijkstraAlgorithm_New {
	int V;
	PriorityQueue<Node_New> pq = new PriorityQueue<>();
	Set<Integer> seattled = new HashSet<>();
	
	List<List<Node_New>> adj = new ArrayList<List<Node_New>>();
	int [] distance ;
	public DijkstraAlgorithm_New(int V) {
		// TODO Auto-generated constructor stub
		this.V=V;
		distance = new int[V];
		for(int i=0;i<V;i++)
		{
			adj.add(new ArrayList<>());
		}
		for(int i=0;i<V;i++)
		{
			distance[i]= Integer.MAX_VALUE;
		}
	}
	public void dijstra(List<List<Node_New>> adj) {
		this.adj =  adj;
		pq.add(new Node_New(0, 0));
		distance[0]=0;
		while(!(seattled.size()==this.V)) {
			if(pq.isEmpty())
				return;
			int data =pq.poll().vertex;
			if(!seattled.contains(data))
			{
				List<Node_New> nodes = adj.get(data);
				for(int i=0;i<nodes.size();i++)
				{
					pq.add(nodes.get(i));
					neighbours(nodes.get(i), data);
				}
				seattled.add(data);
			}
			
		}
		
	}
	public void neighbours(Node_New nodes, int data)
	{
		if(!seattled.contains(nodes.vertex))
		{
			int new_distance =  distance[data] +  nodes.weight;
			if(new_distance<distance[nodes.vertex])
				distance[nodes.vertex] =  new_distance;
		}
	}
public static void main(String[] args) {
	 int V = 5;
     int source = 0;

     // Adjacency list representation of the
     // connected edges by declaring List class object
     // Declaring object of type List<Node>
     List<List<Node_New> > adj
         = new ArrayList<List<Node_New> >();

     // Initialize list for every node
     for (int i = 0; i < V; i++) {
         List<Node_New> item = new ArrayList<Node_New>();
         adj.add(item);
     }

     // Inputs for the GFG(dpq) graph
     adj.get(0).add(new Node_New(1, 9));
     adj.get(0).add(new Node_New(2, 6));
     adj.get(0).add(new Node_New(3, 5));
     adj.get(0).add(new Node_New(4, 3));

     adj.get(2).add(new Node_New(1, 2));
     adj.get(2).add(new Node_New(3, 4));

     // Calculating the single source shortest path
     DijkstraAlgorithm_New dpq = new DijkstraAlgorithm_New(V);
     dpq.dijstra(adj);

     // Printing the shortest path to all the nodes
     // from the source node
     System.out.println("The shorted path from node :");

     for (int i = 0; i < dpq.distance.length; i++)
         System.out.println(source + " to " + i + " is "
                            + dpq.distance[i]);
 }

}
