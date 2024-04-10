package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Parens {
	Set<String> generateParens(int remaining) {
        Set<String> set = new HashSet<String>();
        if (remaining == 0) {
            set.add("");
        } else {
            Set<String> prev = generateParens(remaining - 1);
            for (String str : prev) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(') {
                        String s = insertInside(str, i);
                        /*Add s to set if it's not already in there. Note: HashSet
                         * automatically checks for duplicates before adding, so an explicit
                         * check is not necessary. */
                        set.add(s);
                    }
                }
                set.add("()" + str);
            }
        }
        return set;
    }

    String insertInside(String str, int leftIndex) {
        String left = str.substring(0, leftIndex + 1);
        String right = str.substring(leftIndex + 1);
        return left + "()" + right;
    }
    void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index) {
        if (leftRem < 0 || rightRem < leftRem) return; // invalid state
        
        if (leftRem == 0 && rightRem == 0) { // Out of left and right parentheses
            list.add(String.valueOf(str));
        } else {
            str[index] = '('; // Add left and recurse
            addParen(list, leftRem - 1, rightRem, str, index + 1);
            
            str[index] = ')'; // Add right and recurse
            addParen(list, leftRem, rightRem - 1, str, index + 1);
        }
    }
    
    ArrayList<String> generateParensOptimize(int count) {
        char[] str = new char[count * 2];
        ArrayList<String> list = new ArrayList<String>();
        addParen(list, count, count, str, 0);
        return list;
    }	
    public static void main(String[] args) {
    	Parens generator = new Parens();
        List<String> result = generator.generateParensOptimize(3);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
