/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 */

// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {
        // c.c.
        if (s == null || s.length() == 0 || k < 0) return 0;

        int[] counts = new int[26];
        int start = 0;
        int end = 0;
        int curMaxNo = 0;
        int ret = Integer.MIN_VALUE;
        while(end < s.length()) {
            while(end < s.length() && end - start <= curMaxNo + k) {
                counts[s.charAt(end) - 'A']++;
                if (counts[s.charAt(end) - 'A'] > curMaxNo) {
                    curMaxNo = counts[s.charAt(end) - 'A'];
                }
                ret = Math.max(ret, end - start);
                end++;
            }

            while(start < end && end - start > curMaxNo + k) {
                counts[s.charAt(start) - 'A']--;
                for(int i = 0; i < counts.length; i++) {
                    if (counts[i] > curMaxNo) {
                        curMaxNo = counts[i];
                    }
                }
                start++;

            }
            ret = Math.max(ret, end - start);
        }
        return ret;

    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.characterReplacement("AAAB", 0));
    }
}
// @lc code=end

