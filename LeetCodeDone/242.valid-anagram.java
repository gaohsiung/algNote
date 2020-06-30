/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            map[s.charAt(i)-'a']++;
            map[t.charAt(i)-'a']--;
        }
        for (int i: map) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

