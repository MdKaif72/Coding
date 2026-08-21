package dsa.blind75Question.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
LC 101
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).



Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false


Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            TreeNode l = q.poll();
            TreeNode r = q.poll();
            if (l == null && r == null)
                continue;
            if (l == null || r == null)
                return false;
            if (l.val != r.val) {
                return false;
            }
            q.add(l.left);
            q.add(r.right);
            q.add(l.right);
            q.add(r.left);

        }
        return true;
    }
}
