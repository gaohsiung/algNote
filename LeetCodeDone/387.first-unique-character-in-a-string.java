import java.util.Arrays;

/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        int[] count = new int[26];
        Arrays.fill(count, -1);

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count[c - 'a'] == -1) { // first meet
                count[c - 'a'] = i;
            } else if (count[c - 'a'] == -2) { // third meet
                continue;
            } else { // second meet
                count[c - 'a'] = -2;
            }
        }
        int returnIndex = Integer.MAX_VALUE;
        for(int n: count) {
            if (n == -1 || n == -2) {
                continue;
            }
            returnIndex = Math.min(returnIndex, n);
        }
        return returnIndex == Integer.MAX_VALUE? -1: returnIndex;
    }
}
// @lc code=end

