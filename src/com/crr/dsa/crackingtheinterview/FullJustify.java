package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.List;

public class FullJustify {
	public List<String> fullJustify(String[] words, int maxWidth) {
        List<String>  result = new ArrayList<String>();
        int i=0;
        while(i< words.length)
        {
            List<String> line = numberOfWords( words, i , maxWidth);
            System.out.println(line);
              i+=line.size();
            result.add(createLine(line,words, i, maxWidth));
          
        }
        return result;

    }
   public String createLine( List<String> line ,String words[], int start ,int maxWidth)
	    {
	        StringBuilder sb = new StringBuilder();
	        int totalCharacters =  0;
	        
	        if(  line.size()==1 || start >=  words.length )
	        {
	        	for(int i=0;i<line.size();i++){
	        	    sb.append(line.get(i));
	                sb.append(" ");
	            }
	            while(sb.length()<maxWidth)
	                sb.append(" ");
	        	return sb.toString();
	        }

	        for(int i=0;i<line.size();i++)
	        {
	            totalCharacters+=  line.get(i).length();
	        }

	        int totalSpace = maxWidth -  totalCharacters;
	        int appendSpace =  totalSpace;
	        int needsExtraSpace = totalSpace % (line.size()-1);
	        if(line.size()>1)
	         appendSpace =  totalSpace / (line.size()-1);
	         for(int i=0;i<line.size() ;i++)
	        {
	            sb.append(line.get(i));
	            while(appendSpace-->0 &&  sb.length()<maxWidth){
	                sb.append(" ");
                    
                }
	             while(needsExtraSpace-->0 &&  i+1 <  line.size() && sb.length()+1+ line.get(i+1).length() < maxWidth) {
	            	sb.append(" ");
	            	 break;
	             }
	            appendSpace =  totalSpace / (line.size()-1);
	            needsExtraSpace = totalSpace % (line.size()-1);
	        }
	    return sb.toString();


	    }
    public List<String>  numberOfWords(String[] words,int i ,int maxWidth)
    {
        int length =  0;
        List<String> word = new ArrayList<>();
        for( int j=i;
                        j <words.length &&
                        length + words[j].length()<=maxWidth;
                        j++   )   
        {
            length+=words[j].length();
            word.add(words[j]);
            length++;
        }
        return word;

    }
    public static void main(String[] args) {
		String [] words = {
				"This", "is", "an", "example", "of", "text", "justification."
		};
		FullJustify fullJustify = new FullJustify();
		System.out.println(fullJustify.fullJustify(words, 16));
	}
}
