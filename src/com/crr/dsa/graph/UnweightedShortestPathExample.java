package com.crr.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class GraphShortestPath {
    private int V;
    private ArrayList<ArrayList<Integer>> adj;

    GraphShortestPath(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    void unweightedShortestPath(int start) {
        boolean[] visited = new boolean[V];
        int[] distance = new int[V];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.println("Shortest distance from " + start + " to " + currentVertex + " is " + distance[currentVertex]);

            for (int neighbor : adj.get(currentVertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[currentVertex] + 1;
                    queue.add(neighbor);
                }
            }
        }
    }
}

public class UnweightedShortestPathExample {
    public static void main(String[] args) {
        int numVertices = 7;
        GraphShortestPath graph = new GraphShortestPath(numVertices);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);

        int startVertex = 0;
        graph.unweightedShortestPath(startVertex);
    }
}
