/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            while (fast < nums.length && nums[fast] == nums[slow]) {
                fast++;
            }
            if (fast == nums.length) { //!!!
                break;
            }
            slow++;
            nums[slow] = nums[fast];
            fast++;
        }
        return slow+1;

    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.removeDuplicates(new int[]{1,1,2});
    }
}
// @lc code=end

