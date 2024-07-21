package com.crr.dsa.crackingtheinterview;

public class GetMaxRepetitions {
	public static void main(String[] args) {
		GetMaxRepetitions getMaxRepetitions = new GetMaxRepetitions();
		System.out.println(getMaxRepetitions.getMaxRepetitionsApproach1("abcdgft", 3, "ad", 2));
	}

	public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
		int res = 0;
		StringBuilder sb = new StringBuilder(s1);

		if (n1 > 1) {
			sb.append(s1);
		}

		for (int i = 2; i <= n1; i++) {

			int temp[] = checkMatching(sb, s2);

			sb.append(s1);

			res += temp[1];

		}
		if (sb.length() >= s2.length()) {
			int temp[] = checkMatching(sb, s2);
			if (temp[0] < sb.length())
				sb = new StringBuilder(sb.toString().substring(temp[0] + 1) + s1);
			res += temp[1];
		}
		System.out.println(sb.toString());
		System.out.println(res);

		return res / n2;

	}

	public int[] checkMatching(StringBuilder sb, String s2) {
		int j = 0;
		int k = 0;
		int res = 0;
		while (j < sb.length() && k < s2.length()) {

			if (sb.charAt(j) == s2.charAt(k)) {
				j++;
				k++;
			} else {
				j++;
			}
			if (k == s2.length()) {
				res++;
				k = 0;
			}

		}
		if (k == s2.length()) {
			res++;
		}
		if (j < sb.length())
			sb.substring(j);
		else
			sb.setLength(0);
		return new int[] { j, res };
	}
	
	    public int getMaxRepetitionsApproach1(String s1, int n1, String s2, int n2) {
	        char[] array1 = s1.toCharArray(), 
	        array2 = s2.toCharArray();
	        
	        int count1 = 0, count2 = 0,
	        i = 0, j = 0;
	        
	        while (count1 < n1) {
	            if (array1[i] == array2[j]) {
	                j++;
	                if (j == array2.length) {
	                    j = 0;
	                    count2++;
	                }
	            }
	            i++;
	            if (i == array1.length) {
	                i = 0;
	                count1++;
	            }
	        }
	        
	        return count2 / n2;
	    }
	
}
