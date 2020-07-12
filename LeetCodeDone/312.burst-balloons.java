/*
 * @lc app=leetcode id=312 lang=java
 *
 * [312] Burst Balloons
 */

// @lc code=start
class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[][] dp = new int[len][len];
        dp[len-1][len-1] = nums[len-1];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                // leftBound
                int leftBound;
                if (i-1 < 0) {
                    leftBound = 1;
                } else {
                    leftBound = nums[i-1];
                }
                // rightBound
                int rightBound;
                if (j+1 >= len) {
                    rightBound = 1;
                } else {
                    rightBound = nums[j+1];
                }
                // i == j
                if (i == j) {
                    dp[i][j] = leftBound*nums[j]*rightBound;
                    continue;
                }
                dp[i][j] = 0;
                // i != j
                for (int k = i; k <= j; k++) {
                    // leftmost
                    if (k == i) {
                        dp[i][j] = Math.max(dp[i][j], dp[i+1][j]+nums[k]*leftBound*rightBound);
                    // rightmost
                    } else if (k == j) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][j-1]+nums[k]*leftBound*rightBound);
                    // normal case
                    } else {
                        dp[i][j] = Math.max(dp[i][j], dp[i][k-1]+nums[k]*leftBound*rightBound + dp[k+1][j]);
                    }
                }
            }
        }
        return dp[0][len-1];

    }
}
// @lc code=end

