import java.util.*;
/*
 * @lc app=leetcode id=819 lang=java
 *
 * [819] Most Common Word
 */

// @lc code=start
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("\\W+");
        Set<String> banSet = new HashSet<>();
        for (String s: banned) {
            banSet.add(s);
        }
        Map<String, Integer> counts = new HashMap<>();
        for(String word: words) {
            if (banSet.contains(word)) continue;
            counts.put(word, counts.getOrDefault(word,0) + 1);
        }
        String res = "";
        int max = 0;
        for (Map.Entry<String, Integer> e: counts.entrySet()) {
            if (e.getValue() > max) {
                res = e.getKey();
                max = e.getValue();
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.mostCommonWord( "Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
    }
}
// @lc code=end

