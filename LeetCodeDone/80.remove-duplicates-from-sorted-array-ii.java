/*
 * @lc app=leetcode id=80 lang=java
 *
 * [80] Remove Duplicates from Sorted Array II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast++) {
            if (slow < 2 || nums[fast] != nums[slow-2]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
// @lc code=end

