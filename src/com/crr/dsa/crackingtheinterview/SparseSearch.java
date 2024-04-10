package com.crr.dsa.crackingtheinterview;

public class SparseSearch {

	public static void main(String[] args) {
		String[] str = {"", "apple", "", "banana", "", "orange", "pear", "", "strawberry"};
		System.out.println(search(str, "strawberry", 0, str.length));
	}

	public static int search(String str[], String searchString, int left, int right) {
		if (left > right)
			return -1;
		int mid = (left + right) / 2;
		if (str[mid].isEmpty()) {
			int left_temp = mid - 1;
			int right_temp = mid + 1;
			while (true) {
				if (left_temp < left && right_temp > right)
					return -1;
				else if (right_temp <= right && !str[right_temp].isEmpty()) {
					mid = right_temp;
					break;
				} else if (left_temp >= left && !str[left_temp].isEmpty()) {
					mid = left_temp;
					break;
				}
				right++;
				left--;
			}
		}

		if (searchString.equals(str[mid]))
			return mid;
		else if (str[mid].compareTo(searchString) < 0) {
			return search(str, searchString, mid + 1, right);
		} else {
			return search(str, searchString, left, mid - 1);
		}

	}

}
