import java.util.*;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        dfs(nums, 0, res);
        return res;

    }

    private void dfs(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length) {
            List<Integer> sol = new LinkedList<>();
            for (int i: nums) {
                sol.add(i);
            }
            res.add(sol);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            dfs(nums, index+1, res);
            swap(nums, index, i);
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

