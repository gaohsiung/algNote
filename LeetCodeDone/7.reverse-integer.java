/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE / 10) {
                return 0;
            } else if (res == Integer.MAX_VALUE / 10) {
                if (digit <= Integer.MAX_VALUE % 10) {
                    res = res * 10 + digit;
                } else {
                    return 0;
                }
            } else if (res < Integer.MAX_VALUE / 10 && res > Integer.MIN_VALUE / 10) {
                res = res * 10 + digit;
            } else if (res == Integer.MIN_VALUE / 10) {
                if (digit >= Integer.MIN_VALUE % 10) {
                    res = res * 10 + digit;
                } else {
                    return 0;
                }
            } else if (res < Integer.MIN_VALUE / 10) {
                return 0;
            }

        }
        return res;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverse(Integer.MAX_VALUE));

    }
}
// @lc code=end

