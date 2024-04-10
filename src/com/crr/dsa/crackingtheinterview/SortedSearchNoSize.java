package com.crr.dsa.crackingtheinterview;

public class SortedSearchNoSize {
	static class Listy {
		private int[] array;

		public Listy(int[] arr) {
			this.array = arr.clone(); // Cloning to avoid external modification
		}

		public int elementAt(int i) {
			if (i < 0 || i >= array.length) {
				return -1; // Return -1 if index is out of bounds
			}
			return array[i];
		}

		public int findElement(int searchelement) {
			int length=1;
			while(elementAt(length)!=-1 &&  elementAt(length) <  searchelement)
			{
				length*=2;
				
			}
			 // Perform binary search to find the exact index of the searchElement
		    int low = length / 2;
		    int high = length;
		    while (low <= high) {
		        int mid = low + (high - low) / 2;
		        int midElement = elementAt(mid);
		        if (midElement == searchelement) {
		            return mid; // Element found
		        } else if (midElement == -1 || midElement > searchelement) {
		            high = mid - 1;
		        } else {
		            low = mid + 1;
		        }
		    }
		    
		    return -1; // Element not found
		}
	}

	public static void main(String[] args) {
		// Sample sorted array
		int[] arr = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 ,21,22};

		// Create a Listy object
		Listy listy = new Listy(arr);
		System.out.println(listy.findElement(11));
		// Test elementAt method
	
	}

}
