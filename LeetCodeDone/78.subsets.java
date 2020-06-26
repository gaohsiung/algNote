import java.util.*;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null) {
            return res;
        }
        dfs(nums, 0, new LinkedList<Integer>(), res);
        return res;
    }

    private void dfs(int[] nums, int level, LinkedList<Integer> sol, List<List<Integer>> res) {
        if (level == nums.length) {
            List<Integer> solCopy = new LinkedList<>();
            for (Integer i: sol) {
                solCopy.add(i);
            }
            res.add(solCopy);
            return;
        }
        sol.add(nums[level]);
        dfs(nums, level+1, sol, res);
        sol.remove(sol.size()-1);
        dfs(nums, level+1, sol, res);
        return;
    }
}
// @lc code=end

