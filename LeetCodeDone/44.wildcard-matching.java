/*
 * @lc app=leetcode id=44 lang=java
 *
 * [44] Wildcard Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        }
        if (s == null && p == null) {
            return false;
        }
        Boolean[][] mem = new Boolean[s.length()][p.length()];
        return isMatch(s, 0, p, 0, mem);
    }

    private boolean isMatch(String s, int sIndex, String p, int pIndex, Boolean[][] mem) {

        if (sIndex == s.length() && pIndex == p.length()) {
            return true;
        }
        if (pIndex == p.length()) {
            return false;
        }
        if (sIndex == s.length()) {
            return p.charAt(pIndex) == '*' && isMatch(s, sIndex, p, pIndex+1, mem);
        }
        if (mem[sIndex][pIndex] != null) {
            return mem[sIndex][pIndex];
        }
        if (p.charAt(pIndex) == '?' || p.charAt(pIndex) == s.charAt(sIndex)) {
            mem[sIndex][pIndex] = isMatch(s, sIndex+1, p, pIndex+1, mem);
            return mem[sIndex][pIndex];
        }
        if (p.charAt(pIndex) == '*') {
            mem[sIndex][pIndex] = isMatch(s, sIndex+1, p, pIndex, mem) || isMatch(s, sIndex, p, pIndex+1, mem);
            return mem[sIndex][pIndex];
        }
        mem[sIndex][pIndex] = false;
        return false;
    }
    public static void main(String[] ss) {
        Solution sol = new Solution();
        System.out.println(sol.isMatch("abc", "ab"));
    }

}
// @lc code=end

