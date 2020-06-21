/*
 * @lc app=leetcode id=231 lang=java
 *
 * [231] Power of Two
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int mask = 1;
        int i = 31;
        while (i-- > 0) {
            if (n == mask) {
                return true;
            }
            mask <<= 1;
        }
        return false;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPowerOfTwo(255));
    }
}
// @lc code=end

