package dsa.blind75Question.stack;

import java.util.Stack;


public class NextGreaterElementUsingStack {

    public static int[] nextGreaterElement(int[] nums) {

        int [] ans=new int[nums.length];

        Stack<Integer> stack = new Stack<>();

        for(int i=nums.length-1;i>=0;i--){

            while(!stack.isEmpty() && stack.peek()<nums[i]){
                stack.pop();


            }
            ans[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i]);


        }

        return ans;

    }

}
