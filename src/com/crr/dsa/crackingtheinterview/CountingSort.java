package com.crr.dsa.crackingtheinterview;

public class CountingSort {
	public int arrayPairSum(int[] nums) {

		int max = Integer.MIN_VALUE;
		for (int i : nums)
			max = Math.max(max, i);

		int counts[] = new int[max + 1];
		for (int i : nums)
			counts[i]++;

		int start = 0;

		for (int i = 0; i < max + 1; i++) {
			int count = counts[i];
			counts[i] = start;
			start += count;
		}
		int sorted[] = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			sorted[counts[nums[i]]] = nums[i];
			counts[nums[i]]++;
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = sorted[i];

		}

		int answer = 0;
		for (int i = 0; i < nums.length; i += 2) {
			answer += nums[i];
		}
		return answer;
	}

	public void countingSort(int[] arr) {
		// Sorts an array of integers where minimum value is 0 and maximum value is K
		int max = Integer.MIN_VALUE;

		for (int i : arr)
			max = Math.max(max, i);

		int counts[] = new int[max + 1];

		for (int i : arr) {
			counts[i]++;
		}

		int start = 0;

		for (int i = 0; i < max + 1; i++) {
			int count = counts[i];
			counts[i] = start;
			start += count;
		}

		int result[] = new int[arr.length];

		for (int i : arr) {
			result[counts[i]] = i;
			counts[i]++;
		}

		for (int i : result) {
			System.out.print(i + " ");
		}

	}
	  public int heightChecker(int[] heights) {
	        
	       int max = heights[0];
	       for(int i:heights)
	            max = Math.max(max,i);
	        
	        int counts[] = new int[max+1];

	        for(int i:heights)
	        {
	            counts[i]++;
	           
	        }
	        int start=0;
	        for(int i=0;i<max+1;i++)
	        {
	            int count =  counts[i];
	            counts[i] =  start;
	            start+=count;
	        }

	        int sorted[] = new int[heights.length];

	        for(int i=0;i<heights.length;i++)
	        {
	            sorted[ counts[heights[i]] ] = heights[i];
	             counts[heights[i]]++;
	        }




	        int answer=0;
	        for(int i=0;i<heights.length;i++)
	        {
	            if(sorted[i]!= heights[i])
	            {
	            answer++;
	            } 
	        }
	return answer;
	    }
	public static void main(String[] args) {
		int[] seats = { 3, 1, 5 };
		int[] students = { 2,1,2,1,1,2,2,1 };
		CountingSort countingSort = new CountingSort();
		countingSort.countingSort(seats);
		System.out.println(countingSort.minMovesToSeat(seats, students));
	}

	public int minMovesToSeat(int[] seats, int[] students) {
		// Find the maximum position in the arrays
		int maxPosition = Math.max(findMax(seats), findMax(students));

		// Stores difference between number of seats and students at each position
		int[] differences = new int[maxPosition];

		// Count the available seats at each position
		for (int position : seats) {
			differences[position - 1]++;
		}

		// Remove a seat for each student at that position
		for (int position : students) {
			differences[position - 1]--;
		}

		// Calculate the number of moves needed to seat the students
		int moves = 0;
		int unmatched = 0;
		for (int difference : differences) {
			moves += Math.abs(unmatched);
			unmatched += difference;
		}

		return moves;
	}

	private int findMax(int[] array) {
		int maximum = 0;
		for (int num : array) {
			if (num > maximum) {
				maximum = num;
			}
		}
		return maximum;
	}

}
