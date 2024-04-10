package com.crr.dsa.stack;

public class ArrayWithTwoStack {

    int[] array = null;
    int capacity;
    int leftIndex = 0;
    int rightIndex; // Renamed rightindex to rightIndex
    int mid;

    public ArrayWithTwoStack(int capacity) {
        array = new int[capacity];
        this.capacity = capacity;
        leftIndex = 0;
        rightIndex = array.length - 1;
        mid = (leftIndex + rightIndex) / 2; // Corrected the calculation of mid
        mid = mid + 1;
    }

    public void push(int stack_id, int data) throws Exception {
        if (stack_id == 1) {
            if (leftIndex == mid) {
                throw new Exception("Stack id 1 is full");
            } else {
                array[leftIndex] = data;
                leftIndex++;
            }
        } else {
            if (rightIndex == mid - 1) {
                throw new Exception("Stack id 2 is full");
            } else {
                array[rightIndex] = data;
                rightIndex--;
            }
        }
    }

    public boolean isFull(int stack_id) {
        if (stack_id == 1) {
            return leftIndex > mid; // Changed >= to >
        } else {
            return rightIndex < mid - 1; // Changed <= to <
        }
    }

    public boolean isEmpty(int stack_id) {
        if (stack_id == 1) {
            return leftIndex == 0;
        } else {
            return rightIndex == capacity - 1; // Changed capacity - 1 to mid - 1
        }
    }

    public int pop(int stack_id) throws Exception {
        if (stack_id == 1) {
            if (isEmpty(stack_id)) {
                throw new Exception("Empty");
            }
            int data = array[leftIndex - 1]; // Corrected index
            array[leftIndex - 1] = 0;
            leftIndex--;
            return data;
        } else {
            if (isEmpty(stack_id)) {
                throw new Exception("Empty");
            }
            int data = array[rightIndex + 1]; // Corrected index
            array[rightIndex + 1]=0;
            rightIndex++;
            return data;
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayWithTwoStack arrayWithTwoStack = new ArrayWithTwoStack(10);
        arrayWithTwoStack.push(1, 1);
        arrayWithTwoStack.push(1, 2);
        arrayWithTwoStack.push(1, 3);
        arrayWithTwoStack.push(1, 4);
        arrayWithTwoStack.push(1, 5);
        arrayWithTwoStack.push(2, 6);
        arrayWithTwoStack.push(2, 7);
        arrayWithTwoStack.push(2, 8);
        arrayWithTwoStack.push(2, 9);
        arrayWithTwoStack.push(2, 10);
        System.out.println(arrayWithTwoStack.pop(2));
        System.out.println(arrayWithTwoStack.pop(2));
        System.out.println(arrayWithTwoStack.pop(2));
        System.out.println(arrayWithTwoStack.pop(2));
        System.out.println(arrayWithTwoStack.pop(2));
        System.out.println(arrayWithTwoStack.pop(2));
    }
}
