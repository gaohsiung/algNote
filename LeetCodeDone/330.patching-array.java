/*
 * @lc app=leetcode id=330 lang=java
 *
 * [330] Patching Array
 */

// @lc code=start
class Solution {
    public int minPatches(int[] nums, int n) {
        int bound = 1;
        int count = 0;
        int index = 0;
        while (bound <= n) {
            if (index < nums.length && nums[index] <= bound) { // cur within bound
                bound += nums[index];
                index++;
            } else if (index < nums.length) { // cur greater than bound
                count++;
                bound *= 2;
            } else {
                for (int i = 1; i < 31; i++) {
                    int mask = 1 << i;
                    if (mask > n / bound) {
                        return i+count;
                    }
                }

            }
        }
        return count;
    }
}
// @lc code=end

