/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        int tStart = 0;
        for (int sIndex = 0; sIndex < s.length(); sIndex++) {
            boolean flag = false;
            for (int tIndex = tStart; tIndex < t.length(); tIndex++) {
                if (t.charAt(tIndex) == s.charAt(sIndex)) {
                    tStart = tIndex + 1;
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                return false;
            }
        }
        return true;
        
    }
}
// @lc code=end

