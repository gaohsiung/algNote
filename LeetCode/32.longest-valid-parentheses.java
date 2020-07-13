/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < s.length(); i++) {

        }

        return max;

    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestValidParentheses("()(()"));
    }
}
// @lc code=end

