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
        int[] dp = new int[s.length()];
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') { // (
                dp[i] = 0;
            } else { // )
                if (s.charAt(i - 1) == '(') { // ()
                    if (i - 2 < 0) {
                        dp[i] = 2;
                    } else {
                        dp[i] = 2 + dp[i-2];
                    }
                } else { // ))
                    int tempLeft = i - dp[i-1] - 1;
                    if (tempLeft < 0 || s.charAt(tempLeft) == ')') {
                        dp[i] = 0;
                    } else if (tempLeft - 1 < 0) {
                        dp[i] = dp[i-1]+2;
                    } else {
                        dp[i] = dp[tempLeft - 1] + dp[i-1] + 2;
                    }
                }
            }
            max = Math.max(dp[i], max);
        }

        return max;

    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestValidParentheses("))(())()((((((())(()))((())(((((((()))())((((())())(()())))))))))((()((()(()(()()((()()()(()()()))(()()(()(())())))()())()((((("));
    }
}
// @lc code=end

