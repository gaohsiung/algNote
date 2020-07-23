import java.util.*;

/*
 * @lc app=leetcode id=475 lang=java
 *
 * [475] Heaters
 */

// @lc code=start
class Solution {
    public int findRadius(int[] houses, int[] heaters) { // m, n
        if (heaters == null || heaters.length == 0 || houses == null || houses.length == 0) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(heaters); // O(nlogn)
        int curMaxRadius = 0;

        for(int h: houses) { // O(m)
            int[] bounds = binarySearch(heaters, h);
            if (bounds[0] == bounds[1]) {
                curMaxRadius = Math.max(Math.abs(h-bounds[0]), curMaxRadius);
            } else {
                curMaxRadius = Math.max(Math.min(Math.abs(h-bounds[0]), Math.abs(h-bounds[1])), curMaxRadius);
            }
        }
        return curMaxRadius;

    }

    private int[] binarySearch(int[] heaters, int h) {
        int left = 0;
        int right = heaters.length - 1;
        if (h < heaters[0]) return new int[]{heaters[left], heaters[left]};
        if (h > heaters[heaters.length - 1]) return new int[]{heaters[right], heaters[right]};
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (heaters[mid] == h) {
                return new int[]{heaters[mid], heaters[mid]};
            } else if (heaters[mid] > h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{heaters[right], heaters[left]};
    }
}
// @lc code=end

