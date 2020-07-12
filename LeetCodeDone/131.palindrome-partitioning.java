import java.util.*;

/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        dfs(s, 0, new LinkedList<String>(), res);
        return res;
    }

    private void dfs(String s, int index, List<String> path, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new LinkedList<String>(path));
            return;
        }
        StringBuilder sb = new StringBuilder();
        
        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (isPal(sb.toString())) {
                path.add(sb.toString());
                dfs(s, i + 1, path, res);
                path.remove(path.size() - 1);
            }


        }
    }

    private boolean isPal(String s) {
        if (s.length() == 1) {
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.partition("aab"));
    }
}
// @lc code=end

