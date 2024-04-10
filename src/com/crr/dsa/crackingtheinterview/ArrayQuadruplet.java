package com.crr.dsa.crackingtheinterview;

import java.util.Arrays;

public class ArrayQuadruplet {
	// arr hash :: all elements
	// hashset

	static int[] findArrayQuadruplet(int[] arr, int s) {
		// your code goes here
		// boolean [] arr = new
		// int remaining element = 20-2 = 18 -7 =
		// if remaining element is zero and number of boolean index is value which is
		// true length

		boolean arrayIndex[] = new boolean[arr.length];
		boolean resultFlag = backtracking(arr, arrayIndex, s, 0);
		int result[] = null;
		if(resultFlag) {	
			result =	new int[4];
		int counter = 0;
		for (int i = 0; i < arrayIndex.length; i++) {
			if (arrayIndex[i]) {
				result[counter] = arr[i];
				counter++;
			}
		}
		Arrays.sort(result);
		}else {
			result = new int[0];
		}
		
		return result ;

	}

	public static boolean backtracking(int arr[], boolean[] arrayIndex, int remainingelement, int totalElement) {
		if (remainingelement == 0 && totalElement == 4) {
			return true;
		}
		if (totalElement > 4)
			return false;
		for (int i = 0; i < arrayIndex.length; i++) {
			if (!arrayIndex[i] && totalElement < 4) {

				arrayIndex[i] = true;
				if (backtracking(arr, arrayIndex, remainingelement - arr[i], totalElement + 1))
					return true;
				arrayIndex[i] = false;
			}

		}
		return false;
	}
	public static int[] findArrayQuadrupletOptimize(int[] arr, int s) {
        int n = arr.length;
        if (n < 4) return new int[0]; // Not enough elements to form a quadruplet

        Arrays.sort(arr); // Sort the array to make the search easier

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int target = s - (arr[i] + arr[j]);
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    int sum = arr[left] + arr[right];
                    if (sum == target) {
                        return new int[]{arr[i], arr[j], arr[left], arr[right]};
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return new int[0]; // No quadruplet found
    }


	public static void main(String[] args) {
		int arr[] = { 2, 7, 4, 0, 9, 5, 1, 3 };
		int s = 20;
		System.out.println(findArrayQuadrupletOptimize(arr, s));
	}
}
