/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int longestLowerIndex = 0;
        int longestUpperIndex = 0;
        int lower;
        int upper;
        for (int i = 0; i < s.length(); i++) {
            lower = i;
            upper = i;
            while(lower >= 0 && upper <= s.length()-1 && s.charAt(lower) == s.charAt(upper)) {
                lower--;
                upper++;
            }
            if (upper - lower - 1 > longestUpperIndex - longestLowerIndex - 1) {
                longestLowerIndex = lower;
                longestUpperIndex = upper;
            }
            if (i+1 == s.length()) {
                continue;
            }
            lower = i;
            upper = i+1;
            while(lower >= 0 && upper <= s.length()-1 && s.charAt(lower) == s.charAt(upper)) {
                lower--;
                upper++;
            }
            if (upper - lower - 1 > longestUpperIndex - longestLowerIndex - 1) {
                longestLowerIndex = lower;
                longestUpperIndex = upper;
            }

        }
        return s.substring(longestLowerIndex+1, longestUpperIndex);
    }
}
// @lc code=end

