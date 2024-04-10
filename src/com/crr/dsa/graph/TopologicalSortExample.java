package com.crr.dsa.graph;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Stack;

class Graph_Topo {
	private int V; // Number of vertices
	private ArrayList<ArrayList<Integer>> adj;

	Graph_Topo(int v) {
		V = v;
		adj = new ArrayList<>(v);
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<>());
		}
	}

	void addEdge(int v, int w) {
		adj.get(v).add(w);
	}

	void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
		visited[v] = true;
		for (Integer neighbor : adj.get(v)) {
			if (!visited[neighbor]) {
				topologicalSortUtil(neighbor, visited, stack);
			}
		}
		stack.push(v);
	}

	void topologicalSort() {
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				topologicalSortUtil(i, visited, stack);
			}
		}

		System.out.println("Topological Sort:");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}

public class TopologicalSortExample {
	public static void main(String[] args) {
		int numVertices = 6;
		Graph_Topo graph = new Graph_Topo(numVertices);

		graph.addEdge(5, 2);
		graph.addEdge(5, 0);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);

		graph.topologicalSort();
	//	BigInteger fact = factorial(19);
	//	System.out.println(countFactZeros(fact));
	}
	public static BigInteger countFactZeros(BigInteger num) {
        if (num.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }

        BigInteger count = BigInteger.ZERO;
        BigInteger divisor = BigInteger.valueOf(5);

        while (num.divide(divisor).compareTo(BigInteger.ZERO) > 0) {
        	 if (num.divide(divisor).compareTo(BigInteger.ZERO) > 0) {
        		 count = count.add(BigInteger.ONE);
        	 }
           num =  num.divide(divisor);
            divisor = divisor.multiply(BigInteger.valueOf(5));
        }

        return count;
    }


 public static BigInteger factorial(int n) {
    if (n < 0) {
        throw new IllegalArgumentException("Factorial is not defined for negative numbers");
    }
    BigInteger result = BigInteger.ONE;
    for (int i = 2; i <= n; i++) {
        result = result.multiply(BigInteger.valueOf(i));
    }
    return result;
}

}
