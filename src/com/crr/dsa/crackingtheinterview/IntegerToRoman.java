package com.crr.dsa.crackingtheinterview;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
	private static final int[] values =     {1000,900,500, 400, 100,90,  50,  40,  10, 9,  5,   4,   1};
	private static final String[] symbols= { "M","CM","D","CD","C", "XC","L","XL","X","IX","V","IV","I"}; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(intToRomanOptimize(3999));
		System.out.println(3999/1000);
		System.out.println(3999 % 1000 / 100);
		System.out.println(3999 % 100 / 10);
		System.out.println(3999 % 10);
		System.out.println(romanToInt("MMCMLXXXIX"));
	}
	public static String intToRoman(int num)
	{
		StringBuilder sb = new StringBuilder();
		
		for( int i=0; i< values.length &&  num>0;i++ )
		{
			while(values[i]<=num)
			{
				num-=values[i];
				sb.append(symbols[i]);
			}
		}
		return sb.toString();
	}
	
	
	    private static final String[] thousands = {"", "M", "MM", "MMM"};
	    private static final String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; 
	    private static final String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	    private static final String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	    
	    public static String intToRomanOptimize(int num) { 
	        return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 / 10] + ones[num % 10];
	    }
	    static Map<String, Integer> valuesRomanToInt = new HashMap<>();
	    
	    static {
	    	valuesRomanToInt.put("M", 1000);
	    	valuesRomanToInt.put("D", 500);
	    	valuesRomanToInt.put("C", 100);
	    	valuesRomanToInt.put("L", 50);
	    	valuesRomanToInt.put("X", 10);
	    	valuesRomanToInt.put("V", 5);
	    	valuesRomanToInt.put("I", 1);
	    }

	    public static int romanToInt(String s) {
	        
	        String lastSymbol = s.substring(s.length() - 1);
	        int lastValue = valuesRomanToInt.get(lastSymbol);
	        int total = lastValue;

	        for (int i = s.length() - 2; i >= 0; i--) {
	            String currentSymbol = s.substring(i, i + 1);
	            int currentValue = valuesRomanToInt.get(currentSymbol);
	            if (currentValue < lastValue) {
	                total -= currentValue;
	            } else {
	                total += currentValue;
	            }
	            lastValue = currentValue;
	        }
	        return total;
	    }
}
