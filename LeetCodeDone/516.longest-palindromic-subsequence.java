/*
 * @lc app=leetcode id=516 lang=java
 *
 * [516] Longest Palindromic Subsequence
 */

// @lc code=start
class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;

        // initial
        int[][] mem = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            mem[i][i] = 1;
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    mem[i][j] = 2 + mem[i+1][j-1];
                } else {
                    mem[i][j] = Math.max(mem[i][j-1], mem[i+1][j]);
                }
            }
        }
        return mem[0][s.length()-1];

    }
}
// @lc code=end
/* pruning
class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        int[][] mem = new int[s.length()][s.length()];
        return helper(s, 0, s.length() - 1, mem);
    }

    private int helper(String s, int left, int right, int[][] mem) {
        if (left == right) return 1;
        if (left > right) return 0;
        if (mem[left][right] != 0) return mem[left][right];
        if (s.charAt(left) == s.charAt(right)) {
            mem[left][right] = 2 + helper(s, left+1, right-1, mem);
        } else {
            mem[left][right] = Math.max(helper(s, left, right - 1, mem), helper(s, left+1, right, mem));
        }
        return mem[left][right];
    }
}
*/

