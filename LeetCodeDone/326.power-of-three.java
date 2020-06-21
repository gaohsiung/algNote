/*
 * @lc app=leetcode id=326 lang=java
 *
 * [326] Power of Three
 */

// @lc code=start
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        long mask = 1;
        while (mask <= Integer.MAX_VALUE) {
            if (mask == n) {
                return true;
            }
            mask *= 3;
        }
        return false;
    }
}
// @lc code=end

