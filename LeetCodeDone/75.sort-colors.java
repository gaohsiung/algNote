/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int p0 = 0; // [0, p0) is 0
        int p1 = 0; // [p0, p1) is 1
        int p2 = nums.length - 1; // (p2, nums.length - 1] is 2

        int cur;
        // [p1, p2] has elements
        while (p1 <= p2) {
            cur = nums[p1];
            if (cur == 0) {
                swap(nums, p1, p0);
                p0++;
                p1++;
            } else if (cur == 1) {
                p1++;
            } else {
                swap(nums, p1, p2);
                p2--;
            }
        }
    }

    private void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
    
}
// @lc code=end

