import java.util.*;

/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res= new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        dfs(nums, 0, new LinkedList<Integer>(), res);   
        return res;
    }

    private void dfs(int[] nums, int index, LinkedList<Integer> sol, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new LinkedList<Integer>(sol));
            return;
        }

        sol.add(nums[index]);
        dfs(nums, index+1, sol, res);
        sol.remove(sol.size() - 1);

        while (index + 1< nums.length && nums[index] == nums[index+1]) {
            index++;
        }
        dfs(nums, index + 1, sol, res);
    }
}
// @lc code=end

