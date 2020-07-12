/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return dfs(s, 0, new int[s.length()]);
    }

    private int dfs(String s, int index, int[] mem) {
        if (index == s.length()) {
            return 1;
        }
        if (mem[index] != 0) {
            return mem[index];
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (sb.length() > 2) break;
            if (isValid(Integer.valueOf(sb.toString()))) {
                count = count + dfs(s, i + 1, mem);
                
            }
        }
        mem[index] = count;
        return count;
    }

    private boolean isValid(Integer i) {
        if (i >= 1 && i <= 26) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numDecodings("01"));
    }
}
// @lc code=end

