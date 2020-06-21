/*
 * @lc app=leetcode id=275 lang=java
 *
 * [275] H-Index II
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        int left = 0;
        int right = citations.length - 1;
        int mid;
        if (citations[right] == 0) {
            return 0;
        }
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (citations[mid] >= citations.length - mid) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (citations[left] >= citations.length - left) {
            return citations.length - left;
        } else {
            return citations.length - right;
        }
    }
}
// @lc code=end

