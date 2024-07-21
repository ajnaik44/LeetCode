package com.crr.dsa.crackingtheinterview;

public class DivideTwoIntegers {
public static void main(String[] args) {
	System.out.println(new DivideTwoIntegers().divide(16, 2));
	System.out.println(18%10);
	System.out.println(8/10);
}
	 public int divide(int dividend, int divisor) {
	     
		 int negative=2;
		 if(dividend>0)
		 {
			 negative--;
			 dividend =-dividend;
		 }
		 if(divisor>0)
		 {
			 negative--;
			 divisor=-divisor;
		 }
		 
		 int quotient = 0;
		 
		 while(dividend<=divisor)
		 {
			 
			 int value = divisor;
			 int quTwice = -1;
			 while(value+value>=dividend)
			 {
				 value+=value;
				 quTwice+=quTwice;
			 }
			 quotient +=quTwice;
			 dividend =  dividend-value;
		 }
		 if(negative!=-1)
			 quotient =-quotient;
		 return quotient;
	    }
	
	
	
	
}
