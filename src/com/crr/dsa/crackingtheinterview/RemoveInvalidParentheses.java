package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {
	
	
	
	
	
	
	
	 private void recurse(
		      String s,
		      int index,
		      int leftCount,
		      int rightCount,
		      int leftRem,
		      int rightRem,
		      StringBuilder expression) {

		    // If we reached the end of the string, just check if the resulting expression is
		    // valid or not and also if we have removed the total number of left and right
		    // parentheses that we should have removed.
		    if (index == s.length()) {
		      if (leftRem == 0 && rightRem == 0) {
		        this.validExpressions.add(expression.toString());
		      }

		    } else {
		      char character = s.charAt(index);
		      int length = expression.length();

		      // The discard case. Note that here we have our pruning condition.
		      // We don't recurse if the remaining count for that parenthesis is == 0.
		      if ((character == '(' && leftRem > 0) || (character == ')' && rightRem > 0)) {
		        this.recurse(
		            s,
		            index + 1,
		            leftCount,
		            rightCount,
		            leftRem - (character == '(' ? 1 : 0),
		            rightRem - (character == ')' ? 1 : 0),
		            expression);
		      }

		      expression.append(character);

		      // Simply recurse one step further if the current character is not a parenthesis.
		      if (character != '(' && character != ')') {

		        this.recurse(s, index + 1, leftCount, rightCount, leftRem, rightRem, expression);

		      } else if (character == '(') {

		        // Consider an opening bracket.
		        this.recurse(s, index + 1, leftCount + 1, rightCount, leftRem, rightRem, expression);

		      } else if (rightCount < leftCount) {

		        // Consider a closing bracket.
		        this.recurse(s, index + 1, leftCount, rightCount + 1, leftRem, rightRem, expression);
		      }

		      // Delete for backtracking.
		      expression.deleteCharAt(length);
		    }
		  }

		  public List<String> removeInvalidParenthesesOptimize(String s) {

		    int left = 0, right = 0;

		    // First, we find out the number of misplaced left and right parentheses.
		    for (int i = 0; i < s.length(); i++) {

		      // Simply record the left one.
		      if (s.charAt(i) == '(') {
		        left++;
		      } else if (s.charAt(i) == ')') {
		        // If we don't have a matching left, then this is a misplaced right, record it.
		        right = left == 0 ? right + 1 : right;

		        // Decrement count of left parentheses because we have found a right
		        // which CAN be a matching one for a left.
		        left = left > 0 ? left - 1 : left;
		      }
		    }

		    this.recurse(s, 0, 0, 0, left, right, new StringBuilder());
		    return new ArrayList<String>(this.validExpressions);
		  }
	private Set<String> validExpressions = new HashSet<String>();
	private int minimumRemoved;

	public List<String> removeInvalidParentheses(String s) {
		backtracking(s, 0, new StringBuilder(), 0, 0);
		return new ArrayList<String>(validExpressions);
	}

	private void reset() {
		this.validExpressions.clear();
		this.minimumRemoved = Integer.MAX_VALUE;
	}

	public void backtracking(String s, int index, StringBuilder sb, int balance, int removed) {
		if (index >= s.length()) {
			if (balance == 0) {
				if (removed <= this.minimumRemoved) {
					if (removed < this.minimumRemoved) {
						this.validExpressions.clear();
						this.minimumRemoved = removed;
					}
					this.validExpressions.add(sb.toString());
				}

			}

		} else {
			int length = sb.length();

			if (Character.isLetter(s.charAt(index))) {
				backtracking(s, index + 1, sb.append(s.charAt(index)), balance , removed);
				sb.deleteCharAt(length);
			} else {
				backtracking(s, index + 1, sb, balance, removed + 1);
				if (s.charAt(index) == '(') {
					backtracking(s, index + 1, sb.append('('), balance + 1, removed);
					sb.setLength(length);
				}

				else if (balance > 0 && s.charAt(index) == ')') {
					backtracking(s, index + 1, sb.append(')'), balance - 1, removed);
					sb.setLength(length);
				}
			}

		}
	}

	public static void main(String[] args) {

		RemoveInvalidParentheses invalidParentheses = new RemoveInvalidParentheses();
		invalidParentheses.reset();
		System.out.println(invalidParentheses.removeInvalidParenthesesOptimize("(a)())()"));
	}
}
