/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input array is sorted
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //c.c.
        int start = 0;
        int end = numbers.length - 1;
        while(start < end) {
            if (numbers[start] + numbers[end] == target) {
                return new int[]{start+1, 1+end};
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        return null;
    }
}
// @lc code=end

