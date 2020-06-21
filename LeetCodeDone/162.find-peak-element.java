/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException();
        
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int prev;
        int next;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            prev = Math.max(left, mid - 1);
            next = Math.min(right, mid + 1);
            if (nums[mid] > nums[prev] && nums[mid] > nums[next]) {
                return mid;
            } else if (nums[mid] > nums[prev]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[left] > nums[right]? left:right;
    }
}
// @lc code=end

