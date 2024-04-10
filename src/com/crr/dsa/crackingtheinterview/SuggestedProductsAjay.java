package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuggestedProductsAjay {
	static class SearchWords{
		
		class Node{
			boolean isWord;
			List<Node> suggestWords = Arrays.asList(new Node[26]);
		}
		Node root,curr;
		
		 SearchWords() {
			root= new Node();
		}
		public void insert(String word)
		{
			this.curr =  this.root;
			for(char c: word.toCharArray())
			{
				if(this.curr.suggestWords.get(c-'a')==null)
				{
					this.curr.suggestWords.set(c-'a', new Node());
				}
				this.curr=  this.curr.suggestWords.get(c-'a');
			}
			this.curr.isWord=true;
		}
		
		public List<List<String>> searchWord(String [] words,String searchWord)
		{
			List<List<String>> result = new ArrayList<>();
			for(String word: words)
			{
				this.insert(word);
			}
			String prefix="";
			System.out.println("dd");
			for(char c: searchWord.toCharArray())
			{
				prefix+=c;
				List<String> list = new ArrayList<>();
				search( prefix,result,list);
			}
			return result;
		}
		private void search(String prefix, List<List<String>> result, List<String> list) {
			this.curr = this.root;
			
			for(char c:prefix.toCharArray())
			{
				if(	this.curr.suggestWords.get(c-'a')==null)
					return;
				this.curr =  this.curr.suggestWords.get(c-'a');
			}
			dfs(prefix,list,this.curr);
			result.add(list);
			
		}
		private void dfs(String prefix, List<String> list, Node curr2) {
			if(list.size()==3)
				return;
			if(curr2.isWord)
				list.add(prefix);
			
			for(char c='a' ;  c<='z';c++)
			{
				if(curr2.suggestWords.get(c-'a')!=null)
				{
					dfs(prefix+c, list, curr2.suggestWords.get(c-'a'));
				}
				
			}
			
		}
		
	};

	public static void main(String[] args) {
		String arr[] = { "a", "mouse", "moneypot", "monitor", "mousepad" };
		//System.out.println(new SuggestedProductsAjay().getSuggestsWord(arr, "mou"));
		SearchWords searchWords = new SearchWords();
		System.out.println(searchWords.searchWord(arr, "mou"));
	}

}
