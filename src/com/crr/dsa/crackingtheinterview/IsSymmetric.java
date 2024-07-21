package com.crr.dsa.crackingtheinterview;

public class IsSymmetric {
	public static void main(String[] args) {
        // Test Data
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);

        // Call isSymmetric method and print the result
        boolean result1 = isSymmetric(root1);
        System.out.println("Is the first tree symmetric? " + result1);

        // Another test case
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);

        // Call isSymmetric method and print the result
        boolean result2 = isSymmetric(root2);
        System.out.println("Is the second tree symmetric? " + result2);
    }

    public static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    public static boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return (root1.val == root2.val) && isSymmetric(root1.right, root2.left) && isSymmetric(root1.left, root2.right);
    }



}
