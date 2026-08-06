package dsa.blind75Question.tree;

/*
LC 226
Given the root of a binary tree, invert the tree, and return its root.
basically we have to swap the right with left and vice versa.
 */

public class InvertBT {

    public TreeNode invertTree(TreeNode root) {

        swap(root);
        return root;
    }
    public void swap(TreeNode root){
        if(root==null)
            return ;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        swap(root.left);
        swap(root.right);
    }

}
