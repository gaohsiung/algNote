/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        
        int left = 1;
        int right = x;
        long mid;
        while (left + 1 < right) {
            mid = (long) left + (right - left) / 2;
            if (mid*mid == x) {
                return (int) mid;
            } else if (mid*mid > x) {
                right = (int) mid;
            } else {
                left = (int) mid;
            }
        }
        return left;
    }
}
// @lc code=end

