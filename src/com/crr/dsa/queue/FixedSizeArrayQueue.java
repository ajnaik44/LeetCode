package com.crr.dsa.queue;

import java.util.Arrays;

public class FixedSizeArrayQueue {
	int[] array;
	int front, rear;
	int capacity = 16;
	int size;

	public FixedSizeArrayQueue() {
		// TODO Auto-generated constructor stub
		this.capacity = 16;
		array = new int[capacity];
		front = -1;
		rear = -1;
		size = 0;
	}

	public FixedSizeArrayQueue(int capacity) {
		// TODO Auto-generated constructor stub
		this.capacity = capacity;
		array = new int[capacity];
		front = -1;
		rear = -1;
		size = 0;
	}

	public void enQueue(int data) throws Exception {
		if (size == 0) {
			array[size] = data;
			front++;
			rear++;
			size++;
		} else {
			if (!isFull()) {
				array[++rear] = data;
				size++;
			} else {
				throw new Exception("Queue is full");
			}
		}
	}

	public void deQueue() throws Exception {
		if (isEmpty()) {
			throw new Exception("Queue is empty");
		} else {
			array[front] = 0;
			front++;
			size--;
			if (isEmpty()) {
				front = -1;
				rear = front;
			}
		}
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public boolean isFull() {
		return (size == capacity);
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) throws Exception {
		FixedSizeArrayQueue fixedSizeArrayQueue = new FixedSizeArrayQueue(4);
		fixedSizeArrayQueue.enQueue(4);
		fixedSizeArrayQueue.enQueue(4);
		fixedSizeArrayQueue.enQueue(4);
		fixedSizeArrayQueue.enQueue(4);
		fixedSizeArrayQueue.deQueue();
		fixedSizeArrayQueue.deQueue();
		fixedSizeArrayQueue.deQueue();
		fixedSizeArrayQueue.deQueue();
		fixedSizeArrayQueue.enQueue(4);
		fixedSizeArrayQueue.enQueue(4);
		fixedSizeArrayQueue.enQueue(4);
		fixedSizeArrayQueue.enQueue(4);
	
		fixedSizeArrayQueue.deQueue();
		System.out.println(fixedSizeArrayQueue.size());
		System.out.println(fixedSizeArrayQueue.front);
		System.out.println(fixedSizeArrayQueue.rear);
		Arrays.stream(fixedSizeArrayQueue.array).forEach(num -> System.out.print(num + " "));

	}
}
