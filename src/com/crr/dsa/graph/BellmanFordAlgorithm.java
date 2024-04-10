package com.crr.dsa.graph;

import java.util.Arrays;

class Edge {
    int source, destination, weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

public class BellmanFordAlgorithm {
    private int V, E; // Number of vertices and edges
    private Edge[] edges;
    private int[] distance;

    public BellmanFordAlgorithm(int V, int E) {
        this.V = V;
        this.E = E;
        edges = new Edge[E];
        distance = new int[V];
    }

    public void addEdge(int source, int destination, int weight, int edgeCount) {
        edges[edgeCount] = new Edge(source, destination, weight);
    }

    public void bellmanFord(int source) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        for (int i = 1; i < V; i++) {
            for (int j = 0; j < E; j++) {
                int u = edges[j].source;
                int v = edges[j].destination;
                int w = edges[j].weight;

                if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;
                }
            }
        }

        // Check for negative weight cycles
        for (int i = 0; i < E; i++) {
            int u = edges[i].source;
            int v = edges[i].destination;
            int w = edges[i].weight;

            if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        // Print the shortest distances from the source
        for (int i = 0; i < V; i++) {
            System.out.println("Shortest distance from source to vertex " + i + " is " + distance[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int E = 8; // Number of edges

        BellmanFordAlgorithm graph = new BellmanFordAlgorithm(V, E);

        graph.addEdge(0, 1, -1, 0);
        graph.addEdge(0, 2, 4, 1);
        graph.addEdge(1, 2, 3, 2);
        graph.addEdge(1, 3, 2, 3);
        graph.addEdge(1, 4, 2, 4);
        graph.addEdge(3, 2, 5, 5);
        graph.addEdge(3, 1, 1, 6);
        graph.addEdge(4, 3, -3, 7);

        int source = 0;
        graph.bellmanFord(source);
    }
}
