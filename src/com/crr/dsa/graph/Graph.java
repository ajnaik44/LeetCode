package com.crr.dsa.graph;

import java.util.Stack;

class Vertex {
	public char label;
	public boolean visited;

	public Vertex(char lab) {
		this.label = lab;

	}

}

public class Graph {
	private int maxVertices =6;
	private Vertex vertexList[];
	private int adjMatrix[][];
	private int vertexCount;
	private Stack<Integer> theStack;
	public Graph()
	{
		vertexList = new Vertex[maxVertices];
		adjMatrix =  new int[maxVertices][maxVertices];
		for(int y=0;y<maxVertices;y++)
		{
			for(int x=0;x<maxVertices;x++)
			{
				adjMatrix[x][y]=0;
			}
		}
		theStack = new Stack<>();
	}
	
	public void addVertex(char lab)
	{
		vertexList[vertexCount++] =  new Vertex(lab);
	}
	public void addEdge(int start,int end)
	{
		adjMatrix[start][end]=1;
		adjMatrix[end][start]=1;
	}
	public void dfs()
	{
		vertexList[0].visited = true;
		theStack.push(0);
		while(!theStack.isEmpty())
		{
			
			int v =  getAdjUnvisitedVertex(theStack.peek());
			if(v==-1)
				theStack.pop();
			else {
				vertexList[v].visited=true;
				theStack.push(v);
				System.out.println("Visiting vertex: " + v);
			}
			
		}
	}
	public int getAdjUnvisitedVertex(int v)
	{
		for(int j=0;j<vertexCount;j++)
		{
			if(adjMatrix[v][j]==1 && vertexList[j].visited==false)
				return j;
		}
		return -1;
	}
	
	
	 public static void main(String[] args) {
	        Graph graph = new Graph();

	        // Adding vertices
	        graph.addVertex('A');
	        graph.addVertex('B');
	        graph.addVertex('C');
	        graph.addVertex('D');
	        graph.addVertex('E');

	        // Adding edges
	        graph.addEdge(0, 1); // A - B
	        graph.addEdge(0, 2); // A - C
	        graph.addEdge(1, 3); // B - D
	        graph.addEdge(2, 4); // C - E
	        System.out.println("Depth-First Search (DFS) starting from vertex A:");
	        graph.dfs();

	        // Print the visited vertices
	        for (int i = 0; i < graph.vertexCount; i++) {
	            if (graph.vertexList[i].visited) {
	                System.out.print(graph.vertexList[i].label + " ");
	            }
	        }
	    }
}
