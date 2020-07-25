/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int[] counts = new int[32];
        for(int n: nums) {
            for(int i = 0; i< 32; i++) {
                counts[i] += ((n >> i) & 1);
            }
        }
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if (counts[i] > nums.length / 2) {
                ret += (1 << i);
            }
        }
        return ret;
    }
}
// @lc code=end

