import java.util.*;

/*
 * @lc app=leetcode id=377 lang=java
 *
 * [377] Combination Sum IV
 */

// @lc code=start
class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] mem = new int[target+1];
        for (int i = 1; i < mem.length; i++) {
            mem[i] = -1;
        }
        mem[0] = 1;
        dfs(nums, target, mem);
        return mem[target];
    }

    private int dfs(int[] nums, int remain, int[] mem) {
        if (mem[remain] != -1) {
            return mem[remain];
        }
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            if (remain >= nums[i]) {
                ret += dfs(nums, remain - nums[i], mem);
            }
        }
        mem[remain] = ret;
        return ret;

    }
    public static void main(String[] ss) {
        Solution s = new Solution();
        System.out.println(s.combinationSum4(new int[]{3,33,333}, 10000));
    }
}
// @lc code=end

