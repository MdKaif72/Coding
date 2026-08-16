package dsa.blind75Question.matrix;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int [][]ans=FloodFill.floodFill(new int[][]{{0,0,0},{0,0,0}},0,0,0);
        for(int i=0;i<ans.length;i++){
            System.out.println(Arrays.toString(ans[i]));
        }
    }

}
