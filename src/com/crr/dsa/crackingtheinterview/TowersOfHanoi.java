package com.crr.dsa.crackingtheinterview;

import java.util.Stack;

public class TowersOfHanoi {
	public static void main(String[] args) {
		int n = 3; // Number of disks
		Tower[] towers = new Tower[3];
		for (int i = 0; i < 3; i++) {
			towers[i] = new Tower(i,"Tower " +  i);
		}

		// Add disks to the first tower
		for (int i = n - 1; i >= 0; i--) {
			towers[0].add(i);
		}

		// Move disks from the first tower to the last tower
		towers[0].moveDisks(n, towers[2], towers[1]);
	}

	static class Tower {
		private Stack<Integer> disks;
		private int index;
		private String name ;

		public Tower(int i,String name ) {
			disks = new Stack<>();
			index = i;
			this.name =  name;
		}

		public void add(int d) {
			if (!disks.isEmpty() && disks.peek() <= d) {
				System.out.println("Error placing disk " + d);
			} else {
				disks.push(d);
			}
		}

		public void moveTopTo(Tower t) {
			int top = disks.pop();
			t.add(top);
			System.out.println("Move disk " + top + " from Tower " + index() + " to Tower " + t.index());
		}

		public void moveDisks(int n, Tower destination, Tower buffer) {
			if (n > 0) {
				moveDisks(n - 1, buffer, destination);
				moveTopTo(destination);
				buffer.moveDisks(n - 1, destination, this);
			}
		}

		public int index() {
			return index;
		}
	}
}
