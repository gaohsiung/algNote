/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int start = 0;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();
        while(start < end) {
            while(start < end && !isVowels(chars[start])) {
                start++;
            }
            while(start < end && !isVowels(chars[end])) {
                end--;
            }
            swap(chars, start, end);
            start++;
            end--;
        }
        return new String(chars);
    }

    private void swap(char[] chars, int start, int end) {
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
    }

    private boolean isVowels(char c) {
        if (c == 'a' || c== 'e' || c == 'i' || c== 'o' || c=='u' 
        || c == 'A' || c== 'E' || c == 'I' || c== 'O' || c=='U') {
            return true;
        }
        return false;
    }
}
// @lc code=end

