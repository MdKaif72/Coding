package dsa.blind75Question.matrix;

/*
LC 54
Given an m x n matrix, return all elements of the matrix in spiral order.



Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */


import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        int rowBegin = 0, rowEnd = matrix.length - 1;
        int columnBegin = 0, columnEnd = matrix[0].length - 1;
        List<Integer> ans = new ArrayList<>();

        while (rowBegin <= rowEnd && columnBegin <= columnEnd) {

            //Traverse Right
            for (int j = columnBegin; j <= columnEnd; j++) {
                ans.add(matrix[rowBegin][j]);

            }
            rowBegin++;

            //Traverse Down
            for (int j = rowBegin; j <= rowEnd; j++) {
                ans.add(matrix[j][columnEnd]);
            }
            columnEnd--;

            //Traverse Left
            if (rowBegin <= rowEnd) {
                for (int j = columnEnd; j >= columnBegin; j--) {
                    ans.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            //Traverse UP
            if (columnBegin <= columnEnd) {
                for (int j = rowEnd; j >= rowBegin; j--) {
                    ans.add(matrix[j][columnBegin]);
                }
            }
            columnBegin++;


        }
        return ans;
    }

}
