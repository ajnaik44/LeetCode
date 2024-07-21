package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestStrChain {
	
	public List<List<String>> partition(String s) {
		   List<List<String>> list = new ArrayList<>();
		   backtrack(list, new ArrayList<>(), s, 0);
		   return list;
		}

		public void backtrack(List<List<String>> list, List<String> tempList, String s, int start){
		   if(start == s.length())
		      list.add(new ArrayList<>(tempList));
		   else{
		      for(int i = start; i < s.length(); i++){
		         if(isPalindrome(s, start, i)){
		            tempList.add(s.substring(start, i + 1));
		            backtrack(list, tempList, s, i + 1);
		            tempList.remove(tempList.size() - 1);
		         }
		      }
		   }
		}

		public boolean isPalindrome(String s, int low, int high){
		   while(low < high)
		      if(s.charAt(low++) != s.charAt(high--)) return false;
		   return true;
		} 
	public List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	}

	private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
	    list.add(new ArrayList<>(tempList));
	    for(int i = start; i < nums.length; i++){
	        tempList.add(nums[i]);
	        backtrack(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
	}
	public List<List<Integer>> permute(int[] nums) {
		   List<List<Integer>> list = new ArrayList<>();
		   // Arrays.sort(nums); // not necessary
		   backtrack(list, new ArrayList<>(), nums);
		   return list;
		}

		private void backtrack(List<List<Integer>> list, ArrayList<Integer> tempList, int [] nums){
		   if(tempList.size() == nums.length){
			  list.add(new ArrayList<Integer>(tempList));
		   } else{
		      for(int i = 0; i < nums.length; i++){ 
		         if(tempList.contains(nums[i])) continue; // element already exists, skip
		         tempList.add(nums[i]);
		         backtrack(list, tempList, nums);
		         tempList.remove(tempList.size() - 1);
		      }
		   }
		} 
	public static void main(String[] args) {
		String words[]= {"a","b","ba","bca","bda","bdca"};
		LongestStrChain  chain = new LongestStrChain();
		System.out.println(chain.longestStrChain(words));
		
		int nums[]= {1,2,3};
		System.out.println(chain.partition("aab"));
		
	}
	private int dfs(Set<String> words, Map<String, Integer> memo, String currentWord) {
        // If the word is encountered previously we just return its value present in the map (memoization).
        if (memo.containsKey(currentWord)) {
            return memo.get(currentWord);
        }
        // This stores the maximum length of word sequence possible with the 'currentWord' as the
        int maxLength = 1;
        StringBuilder sb = new StringBuilder(currentWord);

        // creating all possible strings taking out one character at a time from the `currentWord`
        for (int i = 0; i < currentWord.length(); i++) {
            sb.deleteCharAt(i);
            String newWord = sb.toString();
            // If the new word formed is present in the list, we do a dfs search with this newWord.
            if (words.contains(newWord)) {
                int currentLength = 1 + dfs(words, memo, newWord);
                maxLength = Math.max(maxLength, currentLength);
            }
            sb.insert(i, currentWord.charAt(i));
        }
        memo.put(currentWord, maxLength);

        return maxLength;
    }

    public int longestStrChain(String[] words) {
        Map<String, Integer> memo = new HashMap<>();
        Set<String> wordsPresent = new HashSet<>();
        Collections.addAll(wordsPresent, words);
        int ans = 0;
        for (String word : words) {
            ans = Math.max(ans, dfs(wordsPresent, memo, word));
        }
        return ans;
    }
}
