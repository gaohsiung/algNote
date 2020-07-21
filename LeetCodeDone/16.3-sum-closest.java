import java.util.*;

/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // c.c.
        if (nums == null || nums.length <= 2) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(nums);

        int close = nums[0] + nums[1] + nums[nums.length-1];
        for(int i = 0; i < nums.length; i++) {
            int start = i+1;
            int end = nums.length - 1;
            while(start < end) {
                if (nums[start] + nums[end] + nums[i] == target) {
                    return target;
                }
                if (Math.abs(nums[start] + nums[end] + nums[i] - target) < Math.abs(close - target)) {
                    close = nums[start] + nums[end] + nums[i];
                }
                if (nums[start] + nums[end] + nums[i] < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return close;
    }
}
// @lc code=end

