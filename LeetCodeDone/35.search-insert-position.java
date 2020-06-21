/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException();
        
        int left = 0;
        int right = nums.length;
        int mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return nums[left] >= target? left:right;
    }
}
// @lc code=end

