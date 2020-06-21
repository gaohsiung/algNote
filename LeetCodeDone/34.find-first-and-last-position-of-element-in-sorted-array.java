/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        if (nums[left] > target || nums[right] < target) {
            return new int[] {-1, -1};
        }
        
        int mid;
        while (left + 1 < right) {
            mid = left + (right- left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        int first;
        if (nums[left] == target) {
            first = left;
        } else if (nums[right] == target) {
            first = right;
        } else {
            first = -1;
        }
        
        left = 0;
        right = nums.length - 1;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        int last;
        if (nums[right] == target) {
            last = right;
        } else if (nums[left] == target) {
            last = left;
        } else {
            last = -1;
        }
        return new int[] {first, last};
    }
}
// @lc code=end

