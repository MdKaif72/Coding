package dsa.blind75Question.tree;

/*

LC 104
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2


 */

public class MaxDepthBT {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = 1 + maxDepth(root.left);
        int rightDepth = 1 + maxDepth(root.right);
        return Math.max(leftDepth, rightDepth);
    }

}
