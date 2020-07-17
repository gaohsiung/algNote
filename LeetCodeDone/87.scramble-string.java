/*
 * @lc app=leetcode id=87 lang=java
 *
 * [87] Scramble String
 */

// @lc code=start
class Solution {
    public boolean isScramble(String s1, String s2) {
        // base case
        if (s1 == null && s2 == null) return true;
        if (s1 == null || s2 == null) return false;
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) return false;
        if (s1.equals(s2)) return true;
        int[] dicts = new int[256];
        for (int i = 0; i < len1; i++) {
            dicts[s1.charAt(i)]++;
            dicts[s2.charAt(i)]--;
        }
        for (int i: dicts) {
            if (i != 0) return false;
        }

        // recursion
        for (int i = 1; i < len1; i++) {
            if(isScramble(s1.substring(0,i), s2.substring(0,i)) 
            && isScramble(s1.substring(i, len1), s2.substring(i, len2))) {
                return true;
            }
            if(isScramble(s1.substring(0,i), s2.substring(len2 - i, len2)) 
            && isScramble(s1.substring(i, len1), s2.substring(0, len2 - i))) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isScramble("abcdefghijklmnopq", "efghijklmnopqcadb"));
    }
}
// @lc code=end

