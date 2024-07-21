package com.crr.dsa.tree;

import java.util.ArrayList;
import java.util.List;


import java.util.ArrayList;
import java.util.List;

public class AddOperators {
    public static void main(String[] args) {
        AddOperators addOperators = new AddOperators();
        System.out.println(addOperators.addOperators("123", 6));
        System.out.println(addOperators.addOperators("232", 8));
        System.out.println(addOperators.addOperators("105", 5));
        System.out.println(addOperators.addOperators("00", 0));
        System.out.println(addOperators.addOperators("3456237490", 9191));
    }

 
    List<String> answer = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        if (num == null || num.length() == 0) {
            return answer;
        }
        backtracking(num, target, 0, 0, 0, new StringBuilder());
        return answer;
    }

    public void backtracking(String num, int target, int index, long currentSum, long lastOperand, StringBuilder path) {
        if (index == num.length()) {
            if (currentSum == target) {
                answer.add(path.toString());
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            // Skip numbers with leading zero
            if (i != index && num.charAt(index) == '0') {
                break;
            }

            long currentNumber = Long.parseLong(num.substring(index, i + 1));
            int lengthBeforeAppend = path.length();

            if (index == 0) {
                // First number, pick it without any operator
                path.append(currentNumber);
                backtracking(num, target, i + 1, currentSum + currentNumber, currentNumber, path);
                path.setLength(lengthBeforeAppend);
            } else {
                // Addition
                path.append('+').append(currentNumber);
                backtracking(num, target, i + 1, currentSum + currentNumber, currentNumber, path);
                path.setLength(lengthBeforeAppend);

                // Subtraction
                path.append('-').append(currentNumber);
                backtracking(num, target, i + 1, currentSum - currentNumber, -currentNumber, path);
                path.setLength(lengthBeforeAppend);

                // Multiplication
                path.append('*').append(currentNumber);
                backtracking(num, target, i + 1, currentSum - lastOperand + lastOperand * currentNumber, lastOperand * currentNumber, path);
                path.setLength(lengthBeforeAppend);
            }
        }
    }
}

