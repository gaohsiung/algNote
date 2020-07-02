import java.util.*;

/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */

// @lc code=start
class Solution {
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        List<Integer> res = new ArrayList<>();
        res.add(0);
        dfs(n, new LinkedList<Integer>(), res);
        return res.get(0);
        
    }

    private void dfs(int n, LinkedList<Integer> sol, List<Integer> res) {
        if (sol.size() == n) {
            res.set(0, res.get(0) + 1);
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
    private boolean isValid(LinkedList<Integer> sol, int col) {
        if (sol.contains(col)) {
            return false;
        }
        int row = sol.size();
        for (int i = 0; i < sol.size(); i++) {
            if (i - sol.get(i) == row - col ||i + sol.get(i) == row + col) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.totalNQueens(4));
    }
}
// @lc code=end

