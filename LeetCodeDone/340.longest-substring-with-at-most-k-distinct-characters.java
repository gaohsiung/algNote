/*
 * @lc app=leetcode id=340 lang=java
 *
 * [340] Longest Substring with At Most K Distinct Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || k <= 0) {
            return 0;
        }
        int[] countMap = new int[256];
        int left = 0;
        int right = 0;
        int counter = 0;
        int maxLength = 0;
        while (right < s.length()) {
            if (countMap[s.charAt(right)] == 0) {
                counter ++;
            }
            countMap[s.charAt(right)]++;
            right++;
            while(counter > k) {
                if (countMap[s.charAt(left)] == 1) {
                    counter--;
                }
                countMap[s.charAt(left)]--;
                left++;
            }
            if (maxLength < right - left) {
                maxLength = right - left;
            }

        }
        return maxLength;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLongestSubstringKDistinct("eceba", 1));
    }
}
// @lc code=end

