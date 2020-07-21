import java.util.*;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i != 0 && nums[i-1] == nums[i]) continue;
            int start = i + 1;
            int end = nums.length - 1;
            int target = -nums[i];
            while(start < end) {
                if (nums[start] + nums[end] > target) {
                    end--;
                } else if (nums[start] + nums[end] < target) {
                    start++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                    while(start < end && nums[start] == nums[start-1]) {
                        start++;
                    }
                    while(start < end&& nums[end] == nums[end+1]) {
                        end--;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
// @lc code=end

