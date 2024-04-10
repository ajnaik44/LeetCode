package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MultiplyStringsAjay {

	public static void main(String[] args) {
	System.out.println(	new MultiplyStringsAjay().multiply("4986379436526147432469958204718329158211863797453691789509292244161982290580525007195048267692",
			"2044896994719"));
	}

	public Queue<Integer> addMuliplicationResult(ArrayList<Queue<Integer>> multiplicationResult) {
		Queue<Integer> firstResult = multiplicationResult.get(multiplicationResult.size() - 1);
		Queue<Integer> finalResult = new LinkedList<Integer>();
		int carry = 0;
		for (int i = 0; i <= multiplicationResult.size() - 2; i++) {
			
			Queue<Integer> secondResult = multiplicationResult.get(i);
			
			int maxHeight = firstResult.size() > secondResult.size() ? firstResult.size() : secondResult.size();
			
			int j = 0;
			
			
			
			while (j < maxHeight) {
				long firstnum = firstResult.isEmpty() ? 0 : firstResult.poll();
				long secondnum = multiplicationResult.get(i).isEmpty() ? 0 : multiplicationResult.get(i).poll();
				long addResult =  firstnum+secondnum +carry;
				carry =  (int) (addResult/10);
				finalResult.add((int) (addResult%10));
				j++;
			}
			System.out.println(finalResult);
			firstResult =  finalResult;
			Character.isDigit(0)

		}
		if(carry!=0)
		finalResult.add(carry);
		return finalResult.isEmpty() ? firstResult :  finalResult ;
	}

	public String multiply(String num1, String num2) {
		ArrayList<Queue<Integer>> multiplicationResult = new ArrayList();
		int counter = 0;
		int carry = 0;
		for (int i = num2.length() - 1; i >= 0; i--) {
			carry = 0;
			carry = multiplyString(num1, num2.charAt(i), counter, carry, multiplicationResult);
			counter++;
		}
		
		System.out.println(multiplicationResult);
		Queue<Integer> finalIntegers =  addMuliplicationResult(multiplicationResult);
		System.out.println(finalIntegers);
		StringBuilder sb = new StringBuilder();
		while(!finalIntegers.isEmpty())
		{
			sb.append(finalIntegers.poll());
		}
		return sb.reverse().toString();
	}

	public int multiplyString(String nums1, char num2, int numberofZero, int carry,
			ArrayList<Queue<Integer>> multiplicationResult) {
		Queue<Integer> result = new LinkedList<>();
		for (int i = 0; i < numberofZero; i++)
			result.add(0);

		for (int i = nums1.length() - 1; i >= 0; i--) {
			int mupliply = (nums1.charAt(i) - '0') * (num2 - '0') + carry;
			carry = mupliply / 10;
			result.add(mupliply % 10);
		}
		if(carry!=0)
			result.add(carry);
		multiplicationResult.add(result);
		return carry;

	}

}
