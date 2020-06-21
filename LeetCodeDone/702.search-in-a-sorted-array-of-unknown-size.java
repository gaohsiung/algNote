/*
 * @lc app=leetcode id=702 lang=java
 *
 * [702] Search in a Sorted Array of Unknown Size
 */

// @lc code=start
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int rightBound = 1;
        while (reader.get(rightBound) != 2147483647) {
            rightBound *= 2;
        }
        int mid;
        while (left <= rightBound) {
            mid = left + (rightBound - left) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) == 2147483647 || reader.get(mid) > target) {
                rightBound = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
// @lc code=end

