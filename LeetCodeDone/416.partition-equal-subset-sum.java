/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j < target + 1; j++) {
            dp[0][j] = false;
        }
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (j - nums[i-1] >= 0) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length][target];
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canPartition(new int[]{1,2,5}));
    }
}
// @lc code=end

