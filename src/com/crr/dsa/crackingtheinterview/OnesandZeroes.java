package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OnesandZeroes {
	public static void main(String[] args) {
		OnesandZeroes one = new OnesandZeroes();
		System.out.println(one.findMaxForm(new String[] {"10","1","0"}, 1, 1));
	}
	Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
	int m, n;

	public int findMaxForm(String[] strs, int m, int n) {
		this.m = m;
		this.n = n;
		dfs(strs, 0, 0, 0, new ArrayList<String>());
		
		return max;
	}

	int max = 0;

	public void dfs(String[] str, int msum, int nsum, int index, List<String> list) {
		if (index > str.length)
			return;
		if (msum > this.m || nsum > this.n)
			return;
		if (msum >= 0 && msum <= this.m && nsum >= 0 && nsum <= this.n) {

			max = Math.max(max, list.size());
		}

		for (int i = index; i < str.length; i++) {
			countOneZero(str[i]);
		

			list.add(str[i]);
			dfs(str, msum + map.get(str[i]).get(0),
					nsum + map.get(str[i]).get(1), i + 1, list);
			list.remove(list.size() - 1);

		}

	}

	public void countOneZero(String str) {
		if (map.get(str) != null)
			return;
		int one = 0;
		int zero = 0;
		for (char c : str.toCharArray()) {
			if (c == '0')
				zero++;
			if (c == '1')
				one++;
		}
		if (map.get(str) == null)
			map.put(str, new ArrayList());
		map.get(str).add(zero);
		map.get(str).add(one);
	}
}
