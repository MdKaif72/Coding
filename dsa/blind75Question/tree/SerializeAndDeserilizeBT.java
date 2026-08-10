package dsa.blind75Question.tree;

/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.


 */

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserilizeBT {

    class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {

            if (root == null)
                return "";

            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {

                TreeNode node = queue.poll();
                if (!sb.isEmpty())
                    sb.append(",");

                if (node == null)
                    sb.append("n");
                else {
                    sb.append(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }

            }
            return sb.toString();

        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {

            if (data == null || data.isEmpty())
                return null;

            String[] node = data.split(",");

            TreeNode root = new TreeNode(Integer.parseInt(node[0]));

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            int i = 1;
            while (!queue.isEmpty() && i < node.length) {

                TreeNode parent = queue.poll();

                //Left child
                if (i < node.length && !node[i].equals("n")) {
                    TreeNode left = new TreeNode(Integer.parseInt(node[i]));
                    parent.left = left;
                    queue.offer(left);
                }

                i++;


                //Right child
                if (i < node.length && !node[i].equals("n")) {
                    TreeNode right = new TreeNode(Integer.parseInt(node[i]));
                    parent.right = right;
                    queue.offer(right);
                }

                i++;

            }


            return root;


        }
    }


}
