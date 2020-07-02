import java.util.*;

/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<>();
        if (n <= 0) {
            return res;
        }
        dfs(n, new LinkedList<Integer>(), res);
        return res;
    }

    private void dfs(int n, List<Integer> sol, List<List<String>> res) {
        if (sol.size() == n) {
            res.add(transfer(sol));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(sol, i)) {
                sol.add(i);
                dfs(n, sol, res);
                sol.remove(sol.size() - 1);
            }
        }

    }

    private List<String> transfer(List<Integer> sol) {
        List<String> ret = new LinkedList<>();
        for (int i = 0; i < sol.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < sol.size(); j++) {
                if (j == sol.get(i)) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            ret.add(sb.toString());
        }
        return ret;
    }

    private boolean isValid(List<Integer> sol, int col) {
        if (sol.contains(col)) {
            return false;
        }
        int row = sol.size();
        for (int i = 0; i < sol.size(); i++) {
            if (i - sol.get(i) == row - col || i + sol.get(i) == row + col) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        // System.out.println(sol.transfer(Arrays.asList(0,1,2,3)));
        System.out.println(sol.isValid(Arrays.asList(0,2), 4));
    }
}
// @lc code=end

