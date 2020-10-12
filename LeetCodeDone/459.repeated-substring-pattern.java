import java.util.*;
/*
 * @lc app=leetcode id=459 lang=java
 *
 * [459] Repeated Substring Pattern
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        // c.c.
        if (s == null || s.length() <= 1) {
            return false;
        }

        for (int i = 1; i <= s.length() / 2; i++) { // possible pattern length
            String pattern = s.substring(0, i);
            if (s.length() % pattern.length() == 0) {
                int ii = 0;
                boolean flag =true;
                while (ii < s.length()) {
                    if (!(s.substring(ii, ii + pattern.length()).equals(pattern))) {
                        flag = false;
                        break;
                    }
                    ii += pattern.length();
                }
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.repeatedSubstringPattern("ababc"));
    }
}
// @lc code=end

