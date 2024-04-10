package com.crr.dsa.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {
	int size;
	int n;
	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> combinationSum3Ajay(int k, int n) {

		this.n = n;
		this.size = k;
		LinkedList<Integer> list = new LinkedList<>();
		checkCombinationAjay(0, 1, list);
		return result;
	}

	public void checkCombinationAjay(int sum, int k, LinkedList<Integer> list) {

		for (int i = k; i <= 9; i++) {
			
			list.add(i);
			if (list.size() == size) {
				if (i + sum == n) {
					result.add(new ArrayList<>(list));
				}
				list.removeLast();
				continue;
			} else
				checkCombinationAjay(i + sum,  i+ 1, list);
			 list.removeLast();

		}

	}
	public static void main(String[] args) {
		CombinationSumIII combinationSumIII = new CombinationSumIII();
		System.out.println(combinationSumIII.combinationSum3Ajay(3, 7));
	}
	protected void backtrack(int remain, int k,
            LinkedList<Integer> comb, int next_start,
            List<List<Integer>> results) {

        if (remain == 0 && comb.size() == k) {
            // Note: it's important to make a deep copy here,
            // Otherwise the combination would be reverted in other branch of backtracking. 
            results.add(new ArrayList<Integer>(comb));
            return;
        } else if (remain < 0 || comb.size() == k) {
            // Exceed the scope, no need to explore further.
            return;
        }

        // Iterate through the reduced list of candidates.
        for (int i = next_start; i < 9; ++i) {
            comb.add(i + 1);
            this.backtrack(remain - i - 1, k, comb, i + 1, results);
            comb.removeLast();
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();

        this.backtrack(n, k, comb, 0, results);
        return results;
    }
	
}
