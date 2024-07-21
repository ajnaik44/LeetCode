package com.crr.dsa.crackingtheinterview;

public class BitwiseOperator {
	public static void main(String[] args) {
	/*	int a = 5;
		int b = 6;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
		int c = a & b;
		System.out.println(c);
		System.out.println(Integer.toBinaryString(c));
		*/
		int number = 8;
		System.out.println(Integer.toBinaryString(number));
        // 2 bit left shift operation
        int Ans = number << 2;
     //   System.out.print("Binary representation of " + 1 + " is: ");
        printBits(2);
	}
	public static int getSum(int a, int b) {
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
        while (b != 0) {
            int answer = a ^ b;
            System.out.println(Integer.toBinaryString(answer));
            int carry = (a & b) << 1;
            System.out.println(Integer.toBinaryString(carry));
            a = answer;
            b = carry;
        }
        
        return a;
    }

	 public static void printBits(int num) {
	       
	        System.out.println(getSum(1, 3));
	    }
}
