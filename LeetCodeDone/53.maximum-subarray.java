/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int dp = nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(dp, max);
            if (dp < 0) {
                dp = nums[i];
            } else {
                dp += nums[i];
            }
        }
        return Math.max(dp, max);
    }
}
// @lc code=end

