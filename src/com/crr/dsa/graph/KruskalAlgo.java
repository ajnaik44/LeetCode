package com.crr.dsa.graph;

import java.util.*;

class Edge_K implements Comparable<Edge_K> {
	int source, destination, weight;

	Edge_K() {

	}

	public Edge_K(int source, int destination, int weight) {
		// TODO Auto-generated constructor stub
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	public int compareTo(Edge_K other) {
		return this.weight - other.weight;
	}
}

class Graph_K {
	private int V, E;
	private ArrayList<Edge_K> edges;

	Graph_K(int V, int E) {
		this.V = V;
		this.E = E;
		edges = new ArrayList<>(E);
	}

	void addEdge(int source, int destination, int weight) {
		Edge_K edge = new Edge_K();
		edge.source = source;
		edge.destination = destination;
		edge.weight = weight;
		edges.add(edge);
	}

	int find(int[] parent, int i) {
		if (parent[i] == -1)
			return i;
		return find(parent, parent[i]);
	}

	void union(int[] parent, int x, int y) {
		int xSet = find(parent, x);
		int ySet = find(parent, y);
		parent[xSet] = ySet;
	}

	void kruskalMST() {
		Edge_K[] result = new Edge_K[V];
		int e = 0;
		int i = 0;

		Collections.sort(edges);

		int[] parent = new int[V];
		Arrays.fill(parent, -1);

		while (e < V - 1) {
			Edge_K nextEdge = edges.get(i++);
			int x = find(parent, nextEdge.source);
			int y = find(parent, nextEdge.destination);

			if (x != y) {
				result[e++] = nextEdge;
				union(parent, x, y);
			}
		}

		System.out.println("Minimum Spanning Tree using Kruskal's Algorithm:");
		for (i = 0; i < e; ++i) {
			System.out.println(result[i].source + " - " + result[i].destination + " : " + result[i].weight);
		}
	}
}

public class KruskalAlgo {
	public static void main(String[] args) {
		int V = 4;
		int E = 5;

		Graph_K graph = new Graph_K(V, E);

		// Add edges with weights
		graph.addEdge(0, 1, 10);
		graph.addEdge(0, 2, 6);
		graph.addEdge(0, 3, 5);
		graph.addEdge(1, 3, 15);
		graph.addEdge(2, 3, 4);

		graph.kruskalMST();
	}
}
