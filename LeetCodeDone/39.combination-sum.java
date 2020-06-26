import java.util.*;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res= new LinkedList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        dfs(candidates, 0, target, new LinkedList<Integer>(), res);
        return res;
    }

    private void dfs(int[] candidates, int level, int remain, LinkedList<Integer> sol, List<List<Integer>> res) {
        if (remain == 0) {
            res.add(new LinkedList<Integer>(sol));
            return;
        }
        if (remain < 0) {
            return;
        }
        for (int i = level; i< candidates.length; i++ ) {
            sol.add(candidates[i]);
            dfs(candidates, i, remain - candidates[i], sol, res);
            sol.remove(sol.size() - 1);
        }

    }

}
// @lc code=end

