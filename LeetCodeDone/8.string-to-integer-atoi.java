/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }
        int sign = 1;
        int cur = 0;
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (i < str.length() && str.charAt(i) =='-') {
            sign = -1;
            i++;
        } else if (i < str.length() && str.charAt(i) == '+') {
            i++;
        }
        while (i < str.length() && str.charAt(i) <= '9' && str.charAt(i) >= '0') {
            if (cur > Integer.MAX_VALUE / 10 || (cur == Integer.MAX_VALUE / 10 && str.charAt(i) > '7')) {
                return sign == 1? Integer.MAX_VALUE:Integer.MIN_VALUE;

            }
            cur = cur * 10 + (str.charAt(i) - '0');
            i++;
        }
        return cur*sign;
    }
}
// @lc code=end

