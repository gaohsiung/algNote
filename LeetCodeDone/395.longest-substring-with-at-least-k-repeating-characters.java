import java.util.*;

/*
 * @lc app=leetcode id=395 lang=java
 *
 * [395] Longest Substring with At Least K Repeating Characters
 */

// @lc code=start
class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] charCount = new int[26];
        for (char c: s.toCharArray()) {
            charCount[c-'a']++;
        }
        int leftBound = -1;
        int rightBound = s.length();
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (charCount[s.charAt(left) - 'a'] < k) {
                while (leftBound < left) {
                    leftBound++;
                    charCount[s.charAt(leftBound) - 'a']--;
                }
                left++;
                right = rightBound - 1;
            } else if (charCount[s.charAt(right) - 'a'] < k) {
                while (right < rightBound) {
                    rightBound--;
                    charCount[s.charAt(rightBound) - 'a']--;
                }
                right--;
                left = leftBound + 1;
            } else {
                left++;
                right--;
            }
        }
        return rightBound - leftBound - 1;

    }
}
// @lc code=end

