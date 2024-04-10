package com.crr.dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import javax.swing.tree.TreeNode;

public class Problem32printingallancestors {
	public static boolean printancestors(BinaryTreeNode root, BinaryTreeNode node) {
		if (root == null)
			return false;
		if (root.left == node || root.right == node || printancestors(root.left, node)
				|| printancestors(root.right, node)) {
			System.out.println(root.data);
			return true;
		}
		return false;

	}

	public static void zigZagTraversal(BinaryTreeNode root) {
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		Stack<BinaryTreeNode> stack = new Stack<>();
		queue.add(root);
		int counter = 0;
		while (!queue.isEmpty()) {
			counter++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				if (counter % 2 != 0) {

					if (stack.isEmpty()) {
						stack = new Stack<>();
						while (!queue.isEmpty())
							stack.add(queue.poll());
					}
					BinaryTreeNode current = stack.pop();

					System.out.print(current.data + " ");
					if (counter == 1) {
						if (current.right != null) {
							queue.add(current.right);
						}
						if (current.left != null) {
							queue.add(current.left);
						}
					} else {
						if (current.left != null) {
							queue.add(current.left);
						}
						if (current.right != null) {
							queue.add(current.right);
						}

					}
				}

				if (counter % 2 == 0) {

					BinaryTreeNode current = queue.poll();

					System.out.print(current.data + " ");
					if (current.right != null) {
						queue.add(current.right);
					}
					if (current.left != null) {
						queue.add(current.left);
					}

				}

			}
		}
	}

	public static void zigZagTraversalOptimize(BinaryTreeNode root) {
		if (root == null) {
			return;
		}

		Stack<BinaryTreeNode> currentLevel = new Stack<>();
		Stack<BinaryTreeNode> nextLevel = new Stack<>();
		boolean leftToRight = true; // To indicate the current traversal direction

		currentLevel.push(root);

		while (!currentLevel.isEmpty()) {
			BinaryTreeNode node = currentLevel.pop();
			System.out.print(node.data + " ");

			if (leftToRight) {
				if (node.left != null) {
					nextLevel.push(node.left);
				}
				if (node.right != null) {
					nextLevel.push(node.right);
				}
			} else {
				if (node.right != null) {
					nextLevel.push(node.right);
				}
				if (node.left != null) {
					nextLevel.push(node.left);
				}
			}

			if (currentLevel.isEmpty()) {
				leftToRight = !leftToRight;
				Stack<BinaryTreeNode> temp = currentLevel;
				currentLevel = nextLevel;
				nextLevel = temp;
			}
		}
	}

	public static void verticalSum(Map<Integer, Integer> map, BinaryTreeNode root, int c) {
		if (root.left != null)
			verticalSum(map, root.left, c - 1);
		if (root.right != null)
			verticalSum(map, root.right, c + 1);
		int data = 0;
		if (map.containsKey(c))
			data = map.get(c);
		map.put(c, root.data + data);
	}
	public static int numsofBST(int n)
	{
		int []count =  new int[n+1];
		count[0]=1;
		count[1]=1;
		for(int i=2;i<=n;i++)
		{
			for(int j=0;j<i;j++)
			{
				count[i] += count[j]* count[i-j-1];  
			}
		}
		return count[n];
	}
	public static List<BinaryTreeNode> generateAllBSTs(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    private static List<BinaryTreeNode> generateTrees(int start, int end) {
        List<BinaryTreeNode> trees = new ArrayList<>();
        if (start > end) {
            trees.add(null); // Add null for empty subtrees
            return trees;
        }

        for (int i = start; i <= end; i++) {
            List<BinaryTreeNode> leftSubtrees = generateTrees(start, i - 1);
            List<BinaryTreeNode> rightSubtrees = generateTrees(i + 1, end);

            for (BinaryTreeNode left : leftSubtrees) {
                for (BinaryTreeNode right : rightSubtrees) {
                	BinaryTreeNode root = new BinaryTreeNode(i);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }

        return trees;
    }

    // Helper function to print BSTs
    public static void printBSTs(List<BinaryTreeNode> trees) {
        for (BinaryTreeNode root : trees) {
            printTree(root);
            System.out.println();
        }
    }

    private static void printTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        int n = 3;
        List<BinaryTreeNode> allBSTs = generateAllBSTs(n);
        System.out.println("All different BSTs with " + n + " nodes:");
        printBSTs(allBSTs);
    }
/*	public static void main(String[] args) {
		BinaryTreeNode binaryTreeNode = new BinaryTreeNode(1);
		binaryTreeNode.left = new BinaryTreeNode(2);
		binaryTreeNode.right = new BinaryTreeNode(3);
		binaryTreeNode.left.left = new BinaryTreeNode(4);
		binaryTreeNode.left.right = new BinaryTreeNode(5);
		binaryTreeNode.right.left = new BinaryTreeNode(6);
		binaryTreeNode.right.right = new BinaryTreeNode(7);

		// printancestors(binaryTreeNode, node);
		// zigZagTraversalOptimize(binaryTreeNode);
		Map<Integer, Integer> map = new HashMap<>();
		//verticalSum(map, binaryTreeNode, 0);
		//System.out.println(map);
		System.out.println(numsofBST(3));

	}
	*/
}
