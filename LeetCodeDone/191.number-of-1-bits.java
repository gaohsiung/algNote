/*
 * @lc app=leetcode id=191 lang=java
 *
 * [191] Number of 1 Bits
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {

        int count = 0;
        for(int i = 0; i < 32; i++) {
            if (((1 << i) & n) != 0) {
                count++;
            }
        }
        return count;
        
    }
}
// @lc code=end

