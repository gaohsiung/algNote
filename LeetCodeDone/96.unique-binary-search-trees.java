/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) return n;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = 0;
            for (int ii = 0; ii < i; ii++) {
                dp[i] += dp[ii]*dp[i-ii-1];
            }
        }
        return dp[n];
    }
}
// @lc code=end

