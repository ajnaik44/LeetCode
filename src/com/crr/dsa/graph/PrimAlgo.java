package com.crr.dsa.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Edge_New {
	int source, destination, weight;

	public Edge_New(int source, int destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}
}

public class PrimAlgo {
	int V;
	List<List<Edge_New>> graph;
	public PrimAlgo(int V) {
		// TODO Auto-generated constructor stub
		this.V=V;
		graph = new ArrayList<>();
		for(int i=0;i<V;i++)
		{
			graph.add(new ArrayList<>());
		}
	}
	public void addEdge(int source,int destination,int weight)
	{
		Edge_New edge = new Edge_New(source, destination, weight) ;
		graph.get(source).add(edge);
		edge = new Edge_New( destination,source, weight);
		graph.get(destination).add(edge);
	}
	public void primMST() {
        boolean[] inMST = new boolean[V];
        int[] key = new int[V];
        int[] parent = new int[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            inMST[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        PriorityQueue<Edge_New> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));

        priorityQueue.add(new Edge_New(0, 0, 0));

        while (!priorityQueue.isEmpty()) {
            int u = priorityQueue.poll().destination;
            inMST[u] = true;

            for (Edge_New edge : graph.get(u)) {
                int v = edge.destination;
                int weight = edge.weight;

                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    parent[v] = u;
                    priorityQueue.add(new Edge_New(v, v, key[v]));
                }
            }
        }

        // Print the MST
        for (int i = 1; i < V; i++) {
            System.out.println("Edge: " + parent[i] + " - " + i + " Weight: " + key[i]);
        }
    }
	public static void main(String[] args) {
        int V = 5;
        PrimAlgo graph = new PrimAlgo(V);

        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        graph.primMST();
    }
}
