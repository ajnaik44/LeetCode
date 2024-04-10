package com.crr.dsa.crackingtheinterview;

public class NumberOfProvince {
	private int[] parent;

    private int find(int x) {
        return parent[x] == x ? x : find(parent[x]);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++)
            parent[i] = i;

        int[] res = new int[2];
        for (int i = 0; i < n; i++) {
            int x = find(edges[i][0]);
            int y = find(edges[i][1]);
            if (x != y)
                parent[y] = x;
            else {
                res[0] = edges[i][0];
                res[1] = edges[i][1];
            }
        }

        return res;
    }
}
