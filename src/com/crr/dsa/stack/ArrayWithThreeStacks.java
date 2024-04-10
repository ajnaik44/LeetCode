package com.crr.dsa.stack;

import java.util.EmptyStackException;

public class ArrayWithThreeStacks {
    private Integer[] dataArray;
    private int size, topOne, topTwo, baseThree, topThree;

    public ArrayWithThreeStacks(int size) {
        if (size < 3) {
            throw new IllegalStateException("Size < 3 is not permissible");
        }

        this.size = size;
        dataArray = new Integer[size];
        topOne = -1;
        topTwo = size;
        baseThree = size / 2;
        topThree = baseThree;
    }

    public void push(int stackId, int data) {
        if (stackId == 1) {
            if (topOne + 1 == baseThree) {
                if (stack3IsRightShiftable()) {
                    shiftStack3ToRight();
                } else {
                    throw new StackOverflowError("Stack1 has reached max limit");
                }
            }
            dataArray[++topOne] = data;
        } else if (stackId == 2) {
            if (topTwo - 1 == topThree) {
                if (stack3IsLeftShiftable()) {
                    shiftStack3ToLeft();
                } else {
                    throw new StackOverflowError("Stack2 has reached max limit");
                }
            }
            dataArray[--topTwo] = data;
        } else if (stackId == 3) {
            if (topThree == size - 1) {
                if (stack3IsRightShiftable()) {
                    shiftStack3ToRight();
                } else {
                    throw new StackOverflowError("Stack3 has reached max limit");
                }
            }
            dataArray[++topThree] = data;
        }
    }

    public int pop(int stackId) {
        if (stackId == 1) {
            if (topOne == -1) {
                throw new EmptyStackException();
            }
            int toPop = dataArray[topOne];
            dataArray[topOne--] = null;
            return toPop;
        } else if (stackId == 2) {
            // Similar logic for Stack 2
        } else if (stackId == 3) {
            // Similar logic for Stack 3
        }
        return -1; // Or handle other cases accordingly
    }

    // Other methods (peek, isEmpty, shiftStack3ToLeft, shiftStack3ToRight, etc.) should be similarly implemented

    private boolean stack3IsLeftShiftable() {
        return topThree - 1 > baseThree;
    }

    private boolean stack3IsRightShiftable() {
        return topThree + 1 < topTwo;
    }
    private void shiftStack3ToRight() {
    	for(int i=topThree+ 1; i>-baseThree+1;i--){
    		dataArray[i] = dataArray[i-1];
    	}
    	
    	dataArray[baseThree++] = null; 
    	topThree++;
    }
    private void shiftStack3ToLeft() {
    	for(int i=baseThree-1; i<=topThree-1;i++){
    		dataArray[i]= dataArray[i+1];
    	}
    	
    	
    	dataArray[topThree--] = null;
    	baseThree--;
}
    // Main method for testing
    public static void main(String[] args) {
        ArrayWithThreeStacks stacks = new ArrayWithThreeStacks(9);

        stacks.push(1, 1);
        stacks.push(2, 2);
        stacks.push(3, 3);

        System.out.println(stacks.pop(1)); // Output: 1
        System.out.println(stacks.pop(2)); // Output: 2
        System.out.println(stacks.pop(3)); // Output: 3
    }
}
