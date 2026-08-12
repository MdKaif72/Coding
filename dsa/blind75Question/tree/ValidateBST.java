package dsa.blind75Question.tree;

/*
LC 98
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys strictly less than the node's key.
The right subtree of a node contains only nodes with keys strictly greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

 */

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        List<Integer> list = new ArrayList<>();

        InOrderTraversal.inOrderTraversal(root, list);

        int prev = list.get(0);

        for (int i = 1; i < list.size(); i++) {

            if (list.get(i) <= prev)
                return false;

            prev = list.get(i);
        }

        return true;


    }


    /*
    public boolean isValidBST(TreeNode root) {
       return help(root,null,null);
    }
    public boolean help(TreeNode root,Integer l ,Integer h){
        if(root==null)
        return true;
        if(l!=null && root.val<=l){
                return false;
        }
        if(h!=null && root.val>=h){
            return false;
        }
        boolean left=help(root.left,l,root.val);
        boolean right=help(root.right,root.val,h);
        return left &&  right;
    }
     */

}
