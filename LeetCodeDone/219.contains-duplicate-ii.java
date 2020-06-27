import java.util.*;

/*
 * @lc app=leetcode id=219 lang=java
 *
 * [219] Contains Duplicate II
 */

// @lc code=start
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0|| k <= 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        int slow = 0;
        int fast = 1;
        set.add(nums[slow]);
        while (fast < nums.length) {
            if (set.contains(nums[fast])) {
                return true;
            }
            set.add(nums[fast]);
            fast++;
            if (fast - slow > k) {
                set.remove(nums[slow]);
                slow++;
            }
        }
        return false;
    }
}
// @lc code=end

