package com.crr.dsa.priorityqueue;

public class Heap {
	public int[] array;
	public int count;
	public int capacity;
	public int heap_type;

	public Heap(int capacity, int head_type) {
		// TODO Auto-generated constructor stub
		this.capacity = capacity;
		this.heap_type = head_type;
		this.count = 0;
		this.array = new int[capacity];
	}

	public int Parent(int i) {
		if (i <= 0 || i >= this.count)
			return -1;
		return i - 1 / 2;
	}

	public int leftChild(int i) {
		int left = 2 * i + 1;
		if (left >= count)
			return -1;
		return left;
	}

	public int rightChild(int i) {
		int right = 2 * i + 2;
		if (right >= count)
			return -1;
		return right;
	}

	public int getMaximum() {
		if (count == 0)
			return -1;
		return this.array[0];
	}

	public void PercolateDown(int i) {
		int l, r, max, temp;
		l = leftChild(i);
		r = rightChild(i);
		if (l != -1 && this.array[l] > this.array[i])
			max = l;
		else
			max = i;
		if (r != -1 && this.array[r] > this.array[max])
			max = r;
		if (max != i) {
			temp = this.array[i];
			this.array[i] = this.array[max];
			this.array[max] = temp;
			PercolateDown(max);
		}

	}

	public void insert(int data) {
		if (this.count == this.capacity) {
			resize();
		}
		this.count++;
		int i = this.count - 1; // Adjusted index

		this.array[i] = data;

		// Percolate up to maintain the max-heap property
		while (i > 0 && data > this.array[Parent(i)]) {
			this.array[i] = this.array[Parent(i)];
			i = Parent(i);
		}
		this.array[i] = data;
	}

	public void resize() {
		int _new_array[] = new int[this.array.length * 2];
		System.arraycopy(this.array, 0, _new_array, 0, this.capacity);
		;
	}

	public int deleteMax() {
		if (this.count == 0)
			return -1;
		int data = this.array[0];
		this.array[0] = this.array[this.count - 1];
		this.count--;
		PercolateDown(0);
		return data;
	}

	public static void main(String[] args) {
		// Create a max heap with a capacity of 10
		Heap maxHeap = new Heap(10, 1);

		// Insert some elements into the heap
		maxHeap.array[0] = 4;
		maxHeap.array[1] = 10;
		maxHeap.array[2] = 8;
		maxHeap.array[3] = 5;
		maxHeap.array[4] = 9;
		maxHeap.array[5] = 2;
		maxHeap.count = 6;
		maxHeap.insert(3);
		// Print the maximum element in the heap
		System.out.println("Maximum element in the max heap: " + maxHeap.getMaximum());

		// Perform percolate down on the heap
		maxHeap.PercolateDown(0);
		System.out.println(maxHeap.array[0]);
		// Print the maximum element in the heap after percolate down
		System.out.println("Maximum element after percolate down: " + maxHeap.getMaximum());
	}
}
