/*
 * @lc app=leetcode id=137 lang=java
 *
 * [137] Single Number II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        // c.c.
        int[] counts = new int[32];
        for(int n: nums) {
            for(int i = 0; i < 32; i++) {
                counts[i] += (n >> i) & 1;
            }
        }
        int ret = 0;
        for(int i = 0; i < 32; i++) {
            if (counts[i] % 3 != 0) {
                ret += 1 << i;
            }
        }
        return ret;
    }
}
// @lc code=end

