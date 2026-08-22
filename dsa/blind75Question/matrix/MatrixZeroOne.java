package dsa.blind75Question.matrix;

/*
LC 542
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two cells sharing a common edge is 1.



Example 1:


Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]


Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.
 */
public class MatrixZeroOne {
    public static int[][] updateMatrix(int[][] mat) {

        int INF = mat.length + mat[0].length; // maximum possible distance

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != 0)
                    mat[i][j] = INF;
            }
        }

        //Min of left and top
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0)
                    continue;
                //left
                if (j > 0)
                    mat[i][j] = Math.min(mat[i][j - 1] + 1, mat[i][j]);
                //top
                if (i > 0)
                    mat[i][j] = Math.min(mat[i][j], mat[i - 1][j] + 1);


            }
        }

        //Min of right and bottom
        for (int i = mat.length - 1; i >= 0; i--) {
            for (int j = mat[0].length - 1; j >= 0; j--) {
                if (mat[i][j] == 0)
                    continue;
                //right
                if (j < mat[0].length - 1)
                    mat[i][j] = Math.min(mat[i][j + 1] + 1, mat[i][j]);
                //bottom
                if (i < mat.length - 1)
                    mat[i][j] = Math.min(mat[i][j], mat[i + 1][j] + 1);
            }
        }

        return mat;


    }

}
