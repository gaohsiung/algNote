/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int jumpSoFar = 0;
        for (int i = 0; i <= jumpSoFar; i++) {
            jumpSoFar = Math.max(jumpSoFar, nums[i] + i);
            if (jumpSoFar >= nums.length - 1) {
                return true;
            }
        }
        return false;

    }
}
// @lc code=end

// dp
// public boolean canJump(int[] nums) {
//     if (nums == null || nums.length <= 1) {
//         return true;
//     }
//     int[] dp = new int[nums.length];
//     dp[0] = 1;
//     for (int i = 1; i < nums.length; i++) {
//         for (int j = 0; j < i; j++) {
//             if (dp[j] == 1 && nums[j] + j >= i) {
//                 dp[i] = 1;
//                 break;
//             }
//         }
//     }
//     return dp[nums.length - 1] == 1? true:false;

// }
