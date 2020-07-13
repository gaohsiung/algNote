/*
 * @lc app=leetcode id=486 lang=java
 *
 * [486] Predict the Winner
 */

// @lc code=start
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if (nums.length == 0) {
            return false;
        }        
        int len = nums.length;
        int[][] dp = new int[len][len];
        int sum = 0;
        for (int i = len - 1; i >= 0; i--) {
            sum += nums[i];
            for (int j = i; j < len; j++) {
                int dpi2j = i+2>=len ? 0 : dp[i+2][j];
                int dpij2 = j-2<i ? 0 : dp[i][j-2];
                int dpi1j1 = (i+1>=len || j-1<i) ? 0 : dp[i+1][j-1];
                dp[i][j] = Math.max(nums[i] + Math.min(dpi2j, dpi1j1), nums[j] + Math.min(dpij2, dpi1j1));
            }
        }
        return dp[0][len-1] >= sum - dp[0][len-1];
    }
}
// @lc code=end

