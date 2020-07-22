/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        // c.c.
        if (nums == null || nums.length == 0) return 0;

        int start = 0;
        int end = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while(end < nums.length) {
            while(sum < s && end < nums.length) { // [start, end)
                sum += nums[end];
                end++;
            }
            if (start == 0 && sum < s) return 0;
            while(start <= end && sum >= s) {
                sum -= nums[start];
                start++;
            }
            minLen = Math.min(minLen, (end - start + 1));
        }
        return minLen;
    }
}
// @lc code=end

