import java.util.*;

/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */

// @lc code=start
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }
        Map<String, Integer> wordMap = new HashMap<>();
        for(String str: words) {
            wordMap.put(str, wordMap.getOrDefault(str, 0) + 1);
        }
        int wordLen = words[0].length();
        
        for(int i = 0; i < s.length(); i++) {
            if (i + wordLen > s.length()) break;
            int j = i;
            Map<String, Integer> countMap = new HashMap<>();
            while (j + wordLen <= s.length()) {
                String cur = s.substring(j, j + wordLen);
                if (wordMap.containsKey(cur)) {
                    countMap.put(cur, countMap.getOrDefault(cur, 0) + 1);
                } else {
                    break;
                }
                if (countMap.get(cur) > wordMap.get(cur)) {
                    break;
                }
                j += wordLen;
                if (j-i == wordLen * words.length) {
                    res.add(i);
                    break;
                }
            }
        }
        return res;

    }
}
// @lc code=end

