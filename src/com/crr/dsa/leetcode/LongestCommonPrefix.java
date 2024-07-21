package com.crr.dsa.leetcode;

import java.util.HashMap;
import java.util.Map;

class Trei{
	Map<Character,Trei>  children;
	boolean isWord;
	public Trei() {
		children = new HashMap<Character,Trei>();

	}
	
}
class TreiNode{
	Trei root=null;
	public TreiNode() {
		// TODO Auto-generated constructor stub
		root = new Trei();
	}
	public void addWord(String word)
	{
		Trei current =  this.root;
		
		for(char c: word.toCharArray())
		{
			
			if(!current.children.containsKey(c))
				current.children.put(c, new Trei());
			current =  current.children.get(c);
		}
		current.isWord= true;
		
	}
	
	public String prefix(String word)
	{
		StringBuilder sb = new StringBuilder();
		Trei current =  this.root;
		int i = 0;
		while(i <  word.length() && current!=null && current.children.size()==1)
		{
			sb.append(word.charAt(i));
			current =  current.children.get(word.charAt(i));
			i++;
		}
		return sb.toString();
	}
}
public class LongestCommonPrefix {
	public String longestCommonPrefixApproach3(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		return bs(strs, 0, strs.length - 1);
	}

	public String bs(String[] strs, int left, int right) {
		if (left == right)
			return strs[left];
		else {
			int mid = left + (right - left) / 2;
			String left1 = bs(strs, left, mid);
			String left2 = bs(strs, mid + 1, right);
			return common(left1, left2);
		}
	}

	public String common(String left, String right) {
		int min = Math.min(left.length(), right.length());
		int i = 0;
		for (; i < min; i++) {
			if (left.charAt(i) != right.charAt(i))
				break;
		}
		return left.substring(0, i);

	}

	public String longestCommonPrefixApproach2(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		for (int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			
			for (int j = 1; j < strs.length; j++) {
				if (i == strs[j].length() || strs[j].charAt(i) != c)
					return strs[0].substring(0, i);
			}
		}
		return strs[0];
	}

	public static void main(String[] args) {
		LongestCommonPrefix commonPrefix = new LongestCommonPrefix();
		

		String[] array = new String[] { "a" };
		TreiNode node = new TreiNode();
		for(String word: array)
				node.addWord(word);
		
		System.out.println(node.prefix(array[0]));
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {

			System.out.println("================");
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty())
					return "";
			}
			System.out.println(strs[i].indexOf(prefix));
			System.out.println("ddddddddddddddddddd");
		}

		return prefix;
	}

	public String longestCommonPrefixApproach4(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		int minLen = Integer.MAX_VALUE;
		for (String str : strs)
			minLen = Math.min(minLen, str.length());
		int low = 1;
		int high = minLen;
		while (low <= high) {
			int middle = (low + high) / 2;
			if (isCommonPrefix(strs, middle))
				low = middle + 1;
			else
				high = middle - 1;
		}
		return strs[0].substring(0, (low + high) / 2);
	}

	private boolean isCommonPrefix(String[] strs, int len) {
		String str1 = strs[0].substring(0, len);
		for (int i = 1; i < strs.length; i++)
			if (!strs[i].startsWith(str1))
				return false;
		return true;
	}
}
