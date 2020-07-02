/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int curSoFar = 0;
        int nextSoFar = 0;
        int level = 0;
        int i = 0;
        while (i <= curSoFar) {
            level++;
            while (i <= curSoFar) {
                nextSoFar = Math.max(nextSoFar, nums[i] + i);
                i++;
                if (nextSoFar >= nums.length - 1) {
                    return level;
                }
            }
            curSoFar= nextSoFar;
        }
        return -1;   
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.jump(new int[]{2,3,1,1,4}));
    }
}
// @lc code=end
// dp
    // public int jump(int[] nums) {
    //     if (nums == null || nums.length == 0) {
    //         return 0;
    //     }
    //     if (nums.length == 1) {
    //         return 0;
    //     }
    //     int[] dp = new int[nums.length];
    //     dp[0] = 0;
    //     for (int i = 1; i < nums.length; i++) {
    //         for (int j = 0; j < i; j++) {
    //             if (nums[j] + j >= i) {
    //                 if (dp[i] == 0) {
    //                     dp[i] = dp[j] + 1;
    //                 } else {
    //                     dp[i] = Math.min(dp[i], dp[j] + 1);
    //                 }
    //             }
    //         }
    //     }
    //     return dp[nums.length - 1] == 0 ?-1:dp[nums.length - 1];
    // }

