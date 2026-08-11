package dsa.blind75Question.tree;

/*
LC 105
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder
is the inorder traversal of the same tree, construct and return the binary tree.



Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]



 */


import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromPREAndINOrder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }

        return splitTree(preorder, inOrderIndexMap, 0, 0, inorder.length - 1);


    }

    private TreeNode splitTree(int[] preOrder, Map<Integer, Integer> inOrderIndexMap, int rootIndex, int left,
                               int right) {

        TreeNode root = new TreeNode(preOrder[rootIndex]);

        //create left and right subtree
        int mid = inOrderIndexMap.get(preOrder[rootIndex]);
        int numberOfLeftNodes = mid - left;
        if (mid > left)
            root.left = splitTree(preOrder, inOrderIndexMap, rootIndex + 1, left, mid - 1);
        if (mid < right)
            root.right = splitTree(preOrder, inOrderIndexMap, rootIndex + numberOfLeftNodes + 1, mid + 1, right);

        return root;

    }


}
