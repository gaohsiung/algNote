

/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i < amount+1; i++) {
            dp[i] = Integer.MAX_VALUE;
            int curMin = Integer.MAX_VALUE;
            for (int c: coins) {
                if (i - c < 0) continue;
                curMin = Math.min(curMin, dp[i - c]);
            }
            if (curMin != Integer.MAX_VALUE) {
                dp[i] = curMin + 1;
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[amount];
        }


    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.coinChange(new int[]{474,83,404,3}, 264));
    }
}
// @lc code=end

