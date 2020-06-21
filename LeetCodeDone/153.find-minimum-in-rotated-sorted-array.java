/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;

            if (nums[mid] > nums[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] > nums[right]) {
            return nums[right];
        } else {
            return nums[left];
        }
    }
}
// @lc code=end

