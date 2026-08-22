package dsa.blind75Question.matrix;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] ans = FloodFill.floodFill(new int[][]{{0, 0, 0}, {0, 0, 0}}, 0, 0, 0);
      printMatrix(MatrixZeroOne.updateMatrix(new int[][]{{0,0,0},{0,1,0},{1,1,1}}));
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

}
