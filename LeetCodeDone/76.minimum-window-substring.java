/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return "";
        }
        int[] countMap = new int[256];
        for(char c: t.toCharArray()) {
            countMap[c]++;
        }
        int left = 0;
        int right = 0;
        int minLeft = -1;
        int minRight = s.length();
        int counter = t.length();
        while (right < s.length()) {
            if (countMap[s.charAt(right)] > 0) {
                counter--;
            }
            countMap[s.charAt(right)]--;
            right++;
            while (counter == 0) {
                if (countMap[s.charAt(left)] == 0) {
                    counter++;
                }
                countMap[s.charAt(left)]++;
                left++;
                if (minRight - minLeft > right - (left - 1)) {
                    minRight = right;
                    minLeft = left - 1;
                }
            }
        }
        return minLeft == -1? "":s.substring(minLeft, minRight);

    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minWindow("a", "a"));
    }
}
// @lc code=end

