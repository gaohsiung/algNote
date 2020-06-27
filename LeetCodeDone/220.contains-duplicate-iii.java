import java.util.TreeSet;

/*
 * @lc app=leetcode id=220 lang=java
 *
 * [220] Contains Duplicate III
 */

// @lc code=start
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null| nums.length == 0) {
            return false;
        }
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long cur = (long) nums[i];
            Long ceiling = set.ceiling(cur);
            Long floor = set.floor(cur);
            if (ceiling != null && ceiling - cur <= t) {
                return true;
            }
            if (floor != null && cur - floor <= t) {
                return true;
            }
            set.add(cur);
            if (set.size() > k) {
                set.remove((long) nums[i-k]);
            }
        }
        return false;
        
    }
}
// @lc code=end

