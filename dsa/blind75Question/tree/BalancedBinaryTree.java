package dsa.blind75Question.tree;
/*
LC 110
Given a binary tree, determine if it is height-balanced.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true
 A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by
  more than one.
 */

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {

        if (root == null)
            return true;

        if (Math.abs(depth(root.left) - depth(root.right)) <= 1)
            return isBalanced(root.left) && isBalanced(root.right);
        else
            return false;

    }

    private int depth(TreeNode root) {
        if (root == null)
            return 0;
        int left = 1 + depth(root.left);
        int right = 1 + depth(root.right);
        return Math.max(left, right);
    }

}
