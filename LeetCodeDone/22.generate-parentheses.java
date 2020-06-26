import java.util.*;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        if (n <= 0) {
            return res;
        }
        dfs(n, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void dfs(int n, int left, int right, StringBuilder sb, List<String> res) {
        if (sb.length() == 2*n) {
            res.add(sb.toString());
            return;
        }
        int size = sb.length();
        if (left < n) {
            sb.append("(");
            dfs(n, left+1, right, sb, res);
            sb.setLength(size);
        }
        if (right < left) {
            sb.append(")");
            dfs(n, left, right+1, sb, res);
            sb.setLength(size);
        }
    }
}
// @lc code=end

