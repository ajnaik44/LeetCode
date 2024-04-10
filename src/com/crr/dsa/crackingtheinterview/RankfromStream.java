package com.crr.dsa.crackingtheinterview;

public class RankfromStream {
	static class RankNode {
		public int left_size = 0;
		public RankNode left, right;
		public int data = 0;

		public RankNode(int d) {
			data = d;
		}

		public void insert(int d) {
			if (d <= data) {
				if (left != null)
					left.insert(d);
				else
					left = new RankNode(d);
				left_size++;
			} else {
				if (right != null)
					right.insert(d);
				else
					right = new RankNode(d);
			}
		}

		public int getRank(int d) {
			if (d == data) {
				return left_size;
			} else if (d < data) {
				if (left == null)
					return -1;
				else
					return left.getRank(d);
			} else {
				int right_rank = right == null ? -1 : right.getRank(d);
				if (right_rank == -1)
					return -1;
				else
					return left_size + 1 + right_rank;
			}
		}
	}

	public static void main(String[] args) {
		// Create a new RankNode object
		RankNode root = new RankNode(5);

		// Insert elements into the RankNode
		root.insert(3);
		root.insert(9);
		root.insert(2);
		root.insert(4);
		root.insert(6);
		root.insert(7);

		// Test the getRank method
		int rankOf5 = 0;//root.getRank(5); // Expecting 4
		int rankOf3 = 0;//root.getRank(3); // Expecting 2
		int rankOf8 = root.getRank(7); // Expecting 6

		// Print the results
		System.out.println("Rank of 5: " + rankOf5);
		System.out.println("Rank of 3: " + rankOf3);
		System.out.println("Rank of 8: " + rankOf8);
	}

}
