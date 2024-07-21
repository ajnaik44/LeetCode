package com.crr.dsa.crackingtheinterview;

class SegmentTree {
    private int[] tree;
    private int n;

    public SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[2 * n];
        build(arr);
    }

    private void build(int[] arr) {
        for (int i = 0; i < n; i++) {
            tree[n + i] = arr[i];
        }
        for (int i = n - 1; i > 0; --i) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    public void update(int pos, int value) {
        pos += n;
        tree[pos] = value;
        while (pos > 1) {
            pos /= 2;
            tree[pos] = tree[2 * pos] + tree[2 * pos + 1];
        }
    }

    public int query(int l, int r) {
        int sum = 0;
        l += n;
        r += n;
        while (l <= r) {
            if ((l % 2) == 1) sum += tree[l++];
            if ((r % 2) == 0) sum += tree[r--];
            l /= 2;
            r /= 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree segmentTree = new SegmentTree(arr);
        System.out.println(segmentTree.query(1, 3)); // Output: 15
        segmentTree.update(1, 10);
        System.out.println(segmentTree.query(1, 3)); // Output: 22
    }
}

