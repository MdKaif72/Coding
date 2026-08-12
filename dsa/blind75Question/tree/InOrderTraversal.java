package dsa.blind75Question.tree;

import java.util.List;

public class InOrderTraversal {

    public static void inOrderTraversal(TreeNode root, List<Integer> list){

        if(root == null)
            return ;

        inOrderTraversal(root.left,list);
        list.add(root.val);
        inOrderTraversal(root.right,list);



    }

}
