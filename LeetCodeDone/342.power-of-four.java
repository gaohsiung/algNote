/*
 * @lc app=leetcode id=342 lang=java
 *
 * [342] Power of Four
 */

// @lc code=start
class Solution {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        long mask = 1;
        while (mask <= Integer.MAX_VALUE) {
            if (mask == num) {
                return true;
            }
            mask *= 4;
        }
        return false;
    }
}
// @lc code=end

