/*
 * @lc app=leetcode id=159 lang=java
 *
 * [159] Longest Substring with At Most Two Distinct Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() <= 2) {
            return s.length();
        }
        int[] countMap = new int[256];
        int left = 0;
        int right = 0;
        int counter = 0;
        int maxLength = 0;
        while (right < s.length()) {
            if (countMap[s.charAt(right)] == 0) {
                counter++;
            }
            countMap[s.charAt(right)]++;
            right++;
            while (counter > 2) {
                if (countMap[s.charAt(left)] == 1){
                    counter--;
                }
                countMap[s.charAt(left)]--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
// @lc code=end

