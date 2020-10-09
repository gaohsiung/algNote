import java.util.*;
/*
 * @lc app=leetcode id=992 lang=java
 *
 * [992] Subarrays with K Different Integers
 */

// @lc code=start
class Solution {
    public int subarraysWithKDistinct(int[] a, int k) {
        return subarrayAtMostKDistinct(a, k) - subarrayAtMostKDistinct(a, k-1);
    }
    private int subarrayAtMostKDistinct(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int count = 0;
        int res = 0;
        while(right < a.length) {
            map.put(a[right], map.getOrDefault(a[right], 0) + 1);
            if (map.get(a[right]) == 1) {
                count++;
            }
            right++;
            while(count > k && left < right) {
                if (map.get(a[left]) == 1) {
                    count--;
                }
                map.put(a[left], map.get(a[left]) - 1);
                
                left++;
            }
            res += right - left;
        }
        return res;
    }
}
// @lc code=end

