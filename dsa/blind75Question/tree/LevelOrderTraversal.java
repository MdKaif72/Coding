package dsa.blind75Question.tree;

/*

LC 102
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []

 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                currLevel.add(currNode.val);

                if (currNode.left != null)
                    queue.offer(currNode.left);
                if (currNode.right != null)
                    queue.offer(currNode.right);
            }

            ans.add(currLevel);

        }

        return ans;

    }


}
