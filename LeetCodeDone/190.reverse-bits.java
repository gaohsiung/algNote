/*
 * @lc app=leetcode id=190 lang=java
 *
 * [190] Reverse Bits
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int mask = 1;
        for (int i = 0; i < 16; i++) {
            if ((n >> i & 1) != (n >> (31-i) & 1)) {
                n = n ^ (1 << i);
                n = n ^ (1 << (31 - i));
            }
        }
        return n;
    }
}
// @lc code=end

