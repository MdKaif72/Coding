package dsa.blind75Question.array;

public class Array {

    public static int[] getIntegerArray(int n) {
        int [] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i;
        }
        return arr;
    }
}
