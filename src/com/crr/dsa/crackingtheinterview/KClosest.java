package com.crr.dsa.crackingtheinterview;

import java.util.Arrays;

public class KClosest {

	    public static int[][] kClosest(int[][] points, int K) {
	        int N = points.length;
	        int[] dists = new int[N];
	        for (int i = 0; i < N; ++i)
	            dists[i] = dist(points[i]);

	        Arrays.sort(dists);
	        int distK = dists[K-1];

	        int[][] ans = new int[K][2];
	        int t = 0;
	        for (int i = 0; i < N; ++i)
	            if (dist(points[i]) <= distK)
	                ans[t++] = points[i];
	        return ans;
	    }
	    public static double calculateDistance(int x1, int y1, int x2, int y2) {
	        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	    }
	    public static int dist(int[] point) {
	        return point[0] * point[0] + point[1] * point[1];
	    }

	    public static void main(String[] args) {
	        int[][] points = {{3, 3}, {5, -1},{-2,4}};
	        int K = 2;
	       // int[] point1 = {1, 3};
	       // int[] point2 = {-2, 2};


	       // double distance = calculateDistance(point1[0], point1[1], point2[0], point2[1]);
	        //System.out.println("Distance between the points: " + distance);
	        int[][] result = kClosest(points, K);

	        System.out.println("K closest points:");
	        for (int[] point : result) {
	            System.out.println(Arrays.toString(point));
	        }
	    }
}
