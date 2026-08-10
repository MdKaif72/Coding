package dsa.blind75Question.dp;

/*
LC 322
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.



Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0

 */

public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        int dp[] = new int[amount + 1];
        //For each amount fill the array

        for (int i = 1; i <= amount; i++) {

            dp[i] = Integer.MAX_VALUE;


            //Will Try Each Coin

            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);


                }
            }

        }
        if (dp[amount] != Integer.MAX_VALUE)
            return dp[amount];
        return -1;

    }

}
