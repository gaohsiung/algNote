import java.util.*;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for(int i = 1; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            }
            if(map.containsKey(nums[i])) continue;
            map.put(nums[i], i);

        }
        return null;
    }
}
// @lc code=end

