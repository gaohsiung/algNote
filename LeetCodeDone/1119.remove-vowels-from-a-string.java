/*
 * @lc app=leetcode id=1119 lang=java
 *
 * [1119] Remove Vowels from a String
 */

// @lc code=start
class Solution {
    public String removeVowels(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (char c: S.toCharArray()) {
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
// @lc code=end

