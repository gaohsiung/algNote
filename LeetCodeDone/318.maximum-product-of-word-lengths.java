import java.util.*;

/*
 * @lc app=leetcode id=318 lang=java
 *
 * [318] Maximum Product of Word Lengths
 */

// @lc code=start
class Solution {
    public int maxProduct(String[] words) {
        // c.c.
        if (words == null || words.length == 0) return 0;

        int[] freqs = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            for(char c: words[i].toCharArray()) {
                freqs[i] |= (1 << (c-'a'));
            }
        }
        int maxVal = 0;
        for(int i = 0; i < words.length-1; i++) {
            for(int j = i+1; j < words.length; j++) {
                if ((freqs[i] & freqs[j]) == 0) {
                    maxVal = Math.max(maxVal, words[i].length()*words[j].length());
                }
            }
        }
        return maxVal;
    }
}
// @lc code=end

