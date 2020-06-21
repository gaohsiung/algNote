/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        List<Integer> numSoFar = new ArrayList<>();
        numSoFar.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > numSoFar.get(numSoFar.size() - 1)) {
                numSoFar.add(nums[i]);
            } else {
                update(numSoFar, nums[i]);
            }
        }
        return numSoFar.size();
    }
    private void update(List<Integer> list, int n) {
        int left = 0;
        int right = list.size() - 1;
        int mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (list.get(mid) == n) {
                return;
            } else if (list.get(mid) < n) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (list.get(left) >= n) {
            list.set(left, n);
        } else {
            list.set(right, n);
        }
    }
}
// @lc code=end

