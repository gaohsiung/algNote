/*
 * @lc app=leetcode id=260 lang=java
 *
 * [260] Single Number III
 */

// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for(int n: nums) {
            diff ^= n;
        }
        int mask = 1;
        while((mask & diff) == 0) {
            mask <<= 1;
        }
        int g1 = 0;
        int g2 = 0;
        for(int n: nums) {
            if ((n & mask) == 0) {
                g1 ^= n;
            } else {
                g2 ^= n;
            }
        }
        return new int[]{g1, g2};
    }
}
// @lc code=end

