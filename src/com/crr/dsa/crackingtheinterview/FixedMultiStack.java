package com.crr.dsa.crackingtheinterview;

import java.util.EmptyStackException;

public class FixedMultiStack {
    private int numberOfStacks=3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    public void push(int stackNum, int value) throws Exception {
        if (isFull(stackNum)) {
            throw new Exception();
        }
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];
        values[topIndex] = 0;
        sizes[stackNum]--;
        return value;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        return values[indexOfTop(stackNum)];
    }

    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }
        public static void main(String[] args) {
            // Create a FixedMultiStack with stack size of 3
            FixedMultiStack stack = new FixedMultiStack(3);

            // Push some elements into stack 0
            try {
                stack.push(1, 1);
                stack.push(1, 2);
                stack.push(1, 3);
                stack.push(1, 4);
            } catch (Exception e) {
                System.out.println("Stack is full.");
            }

            // Peek at the top element of stack 0
            System.out.println("Top element of stack 0: " + stack.peek(0));

            // Pop an element from stack 0
            System.out.println("Popped element from stack 0: " + stack.pop(0));

            // Check if stack 0 is empty
            System.out.println("Is stack 0 empty? " + stack.isEmpty(0));
    }

}

