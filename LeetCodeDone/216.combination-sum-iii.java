import java.util.*;

/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(k, n, 1, new LinkedList<Integer>(), res);
        return res;
    }

    private void dfs(int k, int remain, int start, LinkedList<Integer> sol, List<List<Integer>> res) {
        if (sol.size() == k && remain == 0) {
            res.add(new LinkedList<Integer>(sol));
            return;
        }
        if (sol.size() >= k || remain < 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            sol.add(i);
            dfs(k, remain - i, i+1, sol, res);
            sol.remove(sol.size() - 1);
        }

    }
    public static void main(String[] ss) {
        Solution s = new Solution();
        s.combinationSum3(3,7);
    }
}
// @lc code=end

