package dsa.blind75Question.array;

/*
LC 11
ou are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the
 ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.



Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of
water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1


 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {

        return maxAreaByTwoPointer(height);

    }

    public static int maxAreaByTwoPointer(int[] height) {
        int maxArea = Integer.MIN_VALUE;

        int left=0;
        int right=height.length-1;

        while(left<right){

            int area=Math.min(height[left],height[right])*(right-left);
            maxArea=Math.max(maxArea,area);

            if(height[left]>height[right])
                right--;
            else
                left++;

        }

        return maxArea;


    }

    public static int maxAreaByBruteForce(int[] height) {
        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int heightWeShouldConsider = Math.min(height[i], height[j]);
                int currArea = heightWeShouldConsider * (j - i);
                maxArea = Math.max(currArea, maxArea);
            }
        }

        return maxArea;


    }
}
