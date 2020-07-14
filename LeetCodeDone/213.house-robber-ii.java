import java.util.Arrays;

/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int len = nums.length;
        int[] dp = new int[len];
        // rob index 0
        for (int i = 0; i< len; i++) {
            if (i == 0) {
                dp[i] = nums[i];
            } else if (i == 1) {
                dp[i] = dp[i-1];
            } else if (i == len - 1) { // can't rob the last house
                dp[i] = dp[i-1];
            } else {
                dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
            }
        }
        int max = dp[len-1];
        Arrays.fill(dp, 0);
        // not rob index 0
        for (int i = 0; i< len; i++) {
            if (i == 0) {
                dp[i] = 0;
            } else if (i == 1) {
                dp[i] = nums[1];
            } else { // could rob or not rob the last house
                dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
            }
        }
        return Math.max(max, dp[len-1]);

    }
}
// @lc code=end

