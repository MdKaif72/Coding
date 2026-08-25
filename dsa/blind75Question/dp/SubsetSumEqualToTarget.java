package dsa.blind75Question.dp;

public class SubsetSumEqualToTarget {


    public static boolean subsetSumEqualToTarget(int[] arr, int indx, int target) {


        if (target == 0)
            return true;
        if (indx == 0)
            return target == arr[indx];

        boolean notTake = subsetSumEqualToTarget(arr, indx - 1, target);
        boolean take = false;
        if (target >= arr[indx])
            take = subsetSumEqualToTarget(arr, indx - 1, target - arr[indx]);

        return notTake || take;

    }
}
