/*
 * @lc app=leetcode id=1155 lang=java
 *
 * [1155] Number of Dice Rolls With Target Sum
 */

// @lc code=start
class Solution {
    private static final int MODVAL = 1000000007;
    public int numRollsToTarget(int d, int f, int target) {
        int[][] dp = new int[d+1][target+1];
        dp[0][0] = 1;
        for(int i = 1; i < dp.length; i++) {
            for (int j = i; j < dp[0].length; j++) {
                if (j > i*f) break;
                for (int k = 1; k <= f && k <= j; k++) {
                    dp[i][j] += dp[i-1][j - k];
                    dp[i][j] %= MODVAL;
                }
            }
        }
        return dp[d][target];
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.numRollsToTarget(1, 6, 3);
    }
}
// @lc code=end

