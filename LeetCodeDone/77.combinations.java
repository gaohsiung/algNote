import java.util.*;

/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        if (n <= 0 || k  > n) {
            return res;
        }
        dfs(n, k, 1, new LinkedList<Integer>(), res);
        return res;
    }

    private void dfs(int n, int k, int cur, LinkedList<Integer> sol, List<List<Integer>> res) {
        if (sol.size() == k) {
            res.add(new LinkedList<Integer>(sol));
            return;
        }
        for (int i = cur; i <= n; i++) {
            sol.add(i);
            dfs(n, k, i+1, sol, res);
            sol.remove(sol.size()-1);
        }

    }
}
// @lc code=end

