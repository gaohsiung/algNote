import java.util.*;

/*
 * @lc app=leetcode id=259 lang=java
 *
 * [259] 3Sum Smaller
 */

// @lc code=start
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[i] + nums[start] + nums[end] >= target) {
                    end--;
                } else {
                    count += (end-start);
                    start++;
                }
            }
        }
        return count;
    }
}
// @lc code=end

