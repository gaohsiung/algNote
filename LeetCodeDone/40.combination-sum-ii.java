import java.util.*;

/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        dfs(candidates, target, 0, new LinkedList<Integer>(), res);
        return res;
    }

    private void dfs(int[] candidates, int remain, int index, LinkedList<Integer> sol, List<List<Integer>> res) {
        if (remain == 0) {
            res.add(new LinkedList<Integer>(sol));
            return;
        }
        if (remain < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i - index > 0 && candidates[i] == candidates[i-1]) {
                continue;
            }
            sol.add(candidates[i]);
            dfs(candidates, remain - candidates[i], i+1, sol, res);
            sol.remove(sol.size() - 1);
        }
    }
}
// @lc code=end

