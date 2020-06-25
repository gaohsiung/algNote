/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int size = nums.length;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
        }
        int correctSum = (1+size)*(size)/2;
        return correctSum - sum;
    }
}
// @lc code=end

