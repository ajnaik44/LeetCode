package com.crr.dsa.crackingtheinterview;

import java.util.Arrays;

public class EarliestAcq {
	class UnionFind {
	    int[] root;
	    int[] rank;
	    int count; // To track the number of connected components

	    public UnionFind(int size) {
	        root = new int[size];
	        rank = new int[size];
	        count = size;
	        for (int i = 0; i < size; i++) {
	            root[i] = i;
	            rank[i] = 1;
	        }
	    }

	    public int find(int x) {
	        if (x == root[x]) {
	            return x;
	        }
	        return root[x] = find(root[x]); // Path compression
	    }

	    public boolean union(int x, int y) {
	        int rootX = find(x);
	        int rootY = find(y);

	        if (rootX != rootY) {
	            if (rank[rootX] > rank[rootY]) {
	                root[rootY] = rootX;
	            } else if (rank[rootX] < rank[rootY]) {
	                root[rootX] = rootY;
	            } else {
	                root[rootY] = rootX;
	                rank[rootX] += 1; // Only increment rank if ranks are equal
	            }
	            count--;
	            return count == 1; // All elements are connected if only one component remains
	        }
	        return false;
	    }
	}

	public static void main(String[] args) {
		EarliestAcq acq = new EarliestAcq();
		int [] [] logs = {{20190101,0,1},{20190104,3,4},{20190107,2,3},{20190211,1,5},
				{20190224,2,4},{20190301,0,3},{20190312,1,2},{20190322,4,5}};
		int n=6;
		System.out.println(acq.earliestAcq(logs, n));
	}
	    public int earliestAcq(int[][] logs, int n) {
	     Arrays.sort(logs,(a,b) ->  (a[0]-  b[0]));
	    UnionFind uf = new UnionFind(n);
	    for(int log[] :  logs)
	     {
	        if(uf.union(log[1],log[2]))
	            return log[0];
	         
	     }
	        return -1;
	        
	    }
	
}
