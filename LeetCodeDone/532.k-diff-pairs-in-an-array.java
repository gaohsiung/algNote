import java.util.*;

/*
 * @lc app=leetcode id=532 lang=java
 *
 * [532] K-diff Pairs in an Array
 */

// @lc code=start
class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        if (k < 0) return 0;
        
        int res = 0;

        if (k == 0) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int n: nums) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> e: map.entrySet()) {
                if (e.getValue() > 1) {
                    res++;
                }
            }
            return res;
        }


        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            set.add(n);
        }

        for (int n: nums) {
            if (set.contains(n) && set.contains(n-k)) {
                res++;
            }
            if (set.contains(n) && set.contains(n+k)) {
                res++;
            }
            if (set.contains(n)) {
                set.remove(n);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findPairs(new int[]{1,2,3,4,5}, 1);
    }
}
// @lc code=end

