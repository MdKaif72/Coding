package dsa.blind75Question.tree;

/*
LC 108
Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary
search tree.



Example 1:


Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:


Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.

 */
public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode h = make(nums, 0, nums.length - 1);
        return h;

    }

    public TreeNode make(int[] nums, int i, int j) {
        if (i < 0 || i > j || j > nums.length - 1)
            return null;
        int mid = 0;
        if ((i + j) % 2 == 0)
            mid = (i + j) / 2;
        else
            mid = (i + j) / 2 + 1;
        TreeNode r = new TreeNode(nums[mid]);


        r.left = make(nums, i, mid - 1);
        r.right = make(nums, mid + 1, j);
        return r;

    }
}
