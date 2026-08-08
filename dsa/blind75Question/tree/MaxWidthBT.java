package dsa.blind75Question.tree;

/*
LC 662

Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

It is guaranteed that the answer will in the range of a 32-bit signed integer.



Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
Example 2:


Input: root = [1,3,2,5,null,null,9,6,null,7]
Output: 7
Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
Example 3:


Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width exists in the second level with length 2 (3,2).

 */

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxWidthBT {
    class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.index = index;
            this.node = node;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null)
            return 0;
        int maxWidth = 0;
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {

            int size = queue.size();
            int minIndexToMinus = queue.peek().index;// to avoid overflow we are starting the index from 0
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {

                TreeNode currNode = queue.peek().node;
                int curr_index = queue.poll().index - minIndexToMinus;

                if (i == 0)
                    first = curr_index;
                if (i == size - 1)
                    last = curr_index;

                if (currNode.left != null)
                    queue.offer(new Pair(currNode.left, curr_index * 2 + 1));
                if (currNode.right != null)
                    queue.offer(new Pair(currNode.right, curr_index * 2 + 2));

            }
            maxWidth = Math.max(maxWidth, last - first + 1);

        }
        return maxWidth;


    }

}
