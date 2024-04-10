package com.crr.dsa.priorityqueue;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
    private Map<Integer, Integer> parent;
    private Map<Integer, Integer> rank;

    public DisjointSet() {
        parent = new HashMap<>();
        rank = new HashMap<>();
    }

    // Create a set with a single element
    public void makeSet(int element) {
        parent.put(element, element);
        rank.put(element, 0);
    }

    // Find the representative (root) of the set to which element belongs
    public int find(int element) {
        if (parent.get(element) != element) {
            parent.put(element, find(parent.get(element))); // Path compression
        }
        return parent.get(element);
    }

    // Union two sets by rank (shorter tree is attached to the root of the taller tree)
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank.get(rootX) < rank.get(rootY)) {
                parent.put(rootX, rootY);
            } else if (rank.get(rootX) > rank.get(rootY)) {
                parent.put(rootY, rootX);
            } else {
                parent.put(rootY, rootX);
                rank.put(rootX, rank.get(rootX) + 1);
            }
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet();

        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(3, 4);
        ds.union(4, 5);

        System.out.println("Are 1 and 3 in the same set? " + (ds.find(1) == ds.find(3)));
        System.out.println("Are 2 and 4 in the same set? " + (ds.find(2) == ds.find(4)));
    }
}
