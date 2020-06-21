/*
 * @lc app=leetcode id=154 lang=java
 *
 * [154] Find Minimum in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left + 1 < right) {
            if (nums[left] < nums[right]) {
                return nums[left];
            }

            mid = left + (right - left) / 2;

            if (nums[mid] == nums[left]) {
                left ++;
            } else if (nums[mid] > nums[left]){
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

