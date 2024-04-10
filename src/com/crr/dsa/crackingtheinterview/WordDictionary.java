package com.crr.dsa.crackingtheinterview;

import java.util.HashMap;
import java.util.Map;

class WordDictionary {
    class Node{
        Map<Character,Node> child =  new HashMap<Character,Node>();
        String word;
    }
    Node root;
    public WordDictionary() {
        root =  new Node();
    }
    
    public void addWord(String word) {
        Node current = root;
        for(char c: word.toCharArray())
        {
            if(current.child.containsKey(c))
            {
                current =  current.child.get(c);
            }else{
                Node newNode = new Node();
                current.child.put(c,newNode);
                current = current.child.get(c);
            }
        }
        current.word=word;

    }
    
    public boolean search(String word) {
        
        Node current = root;
        return dfs(current,word,0);
    }
    public boolean dfs(Node current,String word,int index)
    {
        
        if(word.length()==index){
          System.out.println("word  " + word + "  " +  index);
            return true;
        }
        if(current!=null && current.word!=null &&  current.word.equals(word))
            return true;
        if(word.charAt(index)!='.')
        {
           
          current = current.child.get(word.charAt(index));
         
          if(current!=null && current.child.isEmpty() && current.word.equals(word))
            return true;
         index++;
           return dfs(current , word,index);
        }
        else if(word.charAt(index)=='.'){
           
            for(char c='a';c<='z';c++)
            {
                if(current.child.get(c)!=null)
                {
                    if(dfs(current.child.get(c) , word,index+1))
                        return true;

                }
            }
        }
      
        return false;
    }
    public static void main(String[] args) {
    	  WordDictionary obj = new WordDictionary();
    	  obj.addWord("bad");
    	  boolean param_2 = obj.search("b..");
    	  System.out.println(param_2);
	}
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
