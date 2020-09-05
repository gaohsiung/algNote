import java.util.*;
/*
 * @lc app=leetcode id=472 lang=java
 *
 * [472] Concatenated Words
 */

// @lc code=start
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        Set<String> dict = new HashSet<>();
        for (String word: words) {
            dict.add(word);
        }
        for (String word: words) {
            dict.remove(word);
            if (isWordBreak(word, dict)) {
                res.add(word);
            }
            dict.add(word);
        }
        return res;
    }
    private boolean isWordBreak(String word, Set<String> dict) {
        if (word.equals("")) return false; // important
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] == false) continue;
                if (dict.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }
}
// @lc code=end

