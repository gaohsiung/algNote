/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if ((s == null || t == null) || s.length() != t.length()) {
            return false;
        }
        int[] sMap = new int[256];
        int[] tMap = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sCur = s.charAt(i);
            char tCur = t.charAt(i);
            if (sMap[sCur] != tMap[tCur]) {
                return false;
            }
            sMap[sCur] = i+1;
            tMap[tCur] = i+1;

        }
        return true;
    }
}
// @lc code=end

