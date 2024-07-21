package com.crr.dsa.crackingtheinterview;

public class FaceBook1 {
	public static void main(String[] args) {
		FaceBook1 book1 = new FaceBook1();
		System.out.println(book1.removeDuplicates("deeedbbcccbdaa",3));
	}

	public boolean isValid(String num) {
		num = num.trim();
		if (num.isEmpty())
			return false;

		for (int i = 0; i < num.length(); i++) {
			if (Character.isDigit(num.charAt(i)) || num.charAt(i) == '-' || num.charAt(i) == '+') {
				if ((num.charAt(i) == '-' || num.charAt(i) == '+') && i != 0)
					return false;

			} else
				return false;
		}
		return true;

	}

	public static boolean canSumToTarget(String num, int targetSum) {
		return canSumToTargetHelper(num, targetSum, 0, 0);
	}

	private static boolean canSumToTargetHelper(String num, int targetSum, int index, long currentSum
			) {
		if (index == num.length()) {
			return currentSum == targetSum;
		}

		for (int i = index; i < num.length(); i++) {
			if (i != index && num.charAt(index) == '0') {
				break; // Skip numbers with leading zeros
			}
			long currentNumber = Long.parseLong(num.substring(index, i + 1));
			if (index == 0) {
				if (canSumToTargetHelper(num, targetSum, i + 1, currentNumber)) {
					return true;
				}
			} else {
				if (canSumToTargetHelper(num, targetSum, i + 1, currentSum + currentNumber)) {
					return true;
				}
				if (canSumToTargetHelper(num, targetSum, i + 1, currentSum - currentNumber)) {
					return true;
				}
			}
		}

		return false;
	}
	 public String removeDuplicates(String s, int k) {
	     while(!s.isEmpty())
	    {
	        boolean deleteFlag =false;
	        int match=1;
	        for(int i=1;i<s.length();i++)
	        {
	            if(s.charAt(i-1)==s.charAt(i))
	            {
	                match++;
	                if(match==k)
	                {
	                    s = s.substring(0,i-k+1) +  s.substring(i+1);
	                    deleteFlag= true;
	                    break;
	                }
	                continue;
	            }else {
	            	match=1;
	            }
	        }
	        if(!deleteFlag)
	            return s;
	    }
	    return s;   
	    }
}
