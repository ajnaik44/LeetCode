package com.crr.dsa.tree;

public class PlusOne {
	  public int[] plusOne(int[] digits) {

	        for(int i=digits.length-1 ; i>=0 ; i--){
	            if(digits[i]==9)
	                digits[i]=0;
	            else{
	                digits[i] = digits[i]+1;  
	                return digits; 
	            }   
	        }

	        digits = new int[digits.length+1];
	        digits[0] = 1;
	        return digits;
	    }
	  public static void main(String[] args) {
		PlusOne one = new PlusOne();
		int nums[]= {1,2,3};
		System.out.println(one.plusOne(nums));
	}
}
