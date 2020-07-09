import java.util.*;


/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

// @lc code=start
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new LinkedList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        dfs(s, wordDict, 0, new StringBuilder(), res, new boolean[s.length()]);
        return res;
    }

    private void dfs(String s, List<String> wordDict, int index, StringBuilder path, List<String> res,
                     boolean[] visited) {
        int oldResList = res.size();
        if (index == s.length()) {
            res.add(path.toString());
            return;
        }
        if (visited[index]) {
            return;
        }
        int oldPathLen = path.length();
        for(int i = index + 1; i <= s.length(); i++) {
            String cur = s.substring(index, i);
            if (wordDict.contains(cur)) {

                if (index != 0) {
                    path.append(" ");
                }
                path.append(cur);
                dfs(s, wordDict, i, path, res, visited);
                path.setLength(oldPathLen);
            }
        }
        if (res.size() == oldResList) {
            visited[index] = true;
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.wordBreak("catsanddog", new ArrayList<String>(Arrays.asList(new String[]{"cat","cats","and","sand","dog"}))));
    }



}
// @lc code=end

