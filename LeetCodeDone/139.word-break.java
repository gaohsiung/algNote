import java.util.*;


/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }

        List<Integer> index = new ArrayList<>();

        for (int i = 1; i <= s.length(); i++) {
            String curS = s.substring(0, i);
            if (wordDict.contains(curS)) {
                index.add(i);
                continue;
            }
            for (int prevIndex: index) {
                if (wordDict.contains(s.substring(prevIndex, i))) {
                    index.add(i);
                    break;
                }
            }
        }
        if (index.size() == 0) {
            return false;
        }
        return index.get(index.size() - 1) == s.length();
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.wordBreak("a", new ArrayList<String>(Arrays.asList("leet"))));;
    }
}
// @lc code=end

