import java.util.*;

/*
 * @lc app=leetcode id=320 lang=java
 *
 * [320] Generalized Abbreviation
 */

// @lc code=start
class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new LinkedList<>();
        if (word == null || word.length() == 0) {
            res.add("");
            return res;
        }
        dfs(word, new StringBuilder(), res, 0, 0);
        return res;
    }

    private void dfs(String word, StringBuilder path, List<String> res, int count, int index) {
        if (index == word.length()) {
            int pathLen = path.length();
            if (count != 0) {
                path.append(count);
            }
            res.add(path.toString());
            path.setLength(pathLen);
            return;
        }

        // add count
        dfs(word, path, res, count + 1, index + 1);
        // append char
        int pathLen = path.length();
        if (count != 0) {
            path.append(count);
        }
        path.append(word.charAt(index));
        dfs(word, path, res, 0, index+1);
        path.setLength(pathLen);

    }
}
// @lc code=end

