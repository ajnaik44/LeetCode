package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	public List<String> fullJustify(String[] words, int maxWidth) {
        List<String>  result = new ArrayList<String>();
        int i=0;
       while(i<words.length)
       {
    	   List<String> currentWord =  numberOfWords(i, words, maxWidth);
    	   result.add(populateString(currentWord,maxWidth));
    	   i+=currentWord.size();
    	   
       }
        return result;

    }
	private String populateString(List<String> currentWord, int maxWidth) {
		int currentWordCount=0;
		for(String word: currentWord)
		{
			currentWordCount+=word.length();
		}
		int totalWord = currentWord.size()-1;
		int extraSpace =  maxWidth -  currentWordCount;
		int needSpace=0;
		if(totalWord>0)
			needSpace = extraSpace/totalWord;
		else
			needSpace =  extraSpace;
		
		StringBuilder sb = new StringBuilder();
		
		int wordIndex=0;
		int totalspaceConsume = extraSpace;
		while(wordIndex < currentWord.size()   &&  sb.length()+currentWord.get(wordIndex).length() <= maxWidth)
		{
			sb.append(currentWord.get(wordIndex));
			if(totalspaceConsume>=0)
			{	if(totalspaceConsume== extraSpace &&   extraSpace==currentWord.size())
				addSpace(maxWidth, sb, needSpace+1);
			else
				addSpace(maxWidth, sb, needSpace);
			}
			totalspaceConsume-=needSpace;
			wordIndex++;
		}
		return sb.toString();
	}
	public void addSpace(int maxWidth,StringBuilder sb, int numberofSpace)
	{
		while(sb.length()<maxWidth && numberofSpace>0)
		{
			numberofSpace--;
			sb.append(" ");
			
		}
	}
	public static List<String> numberOfWords(int i, String[] words, int maxWidth)
	{
		List<String>  currenword = new ArrayList<String>();
		int currentSize = 0;
		while(i<words.length &&  currentSize+words[i].length()+1<= maxWidth)
		{
			currentSize += words[i].length()+1;
			currenword.add(words[i]);
			i++;
		}
		return currenword;
		
	}
	public static void main(String[] args) {
		String words[] = {   "This", "is", "an", "example", "of", "text", "justification."};
		System.out.println(new TextJustification().fullJustify(words, 16));
		
	}
}
