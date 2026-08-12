package dsa.blind75Question.tree;

/*
LC 230
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values
 of the nodes in the tree.



Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:


Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

 */

public class KthSmallestElement {
    int pos = 0;

    public int kthSmallest(TreeNode root, int k) {

        TreeNode helper = helper(root, k);

        if (helper == null)
            return -1;

        return helper.val;


    }

    public TreeNode helper(TreeNode node, int k) {


        if (node == null)
            return node;


        TreeNode left = helper(node.left, k);
        if (left != null)
            return left;
        pos++;

        if (pos == k)
            return node;

        return helper(node.right, k);


    }

}
