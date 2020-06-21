/*
 * @lc app=leetcode id=410 lang=java
 *
 * [410] Split Array Largest Sum
 */

// @lc code=start
class Solution {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0 || m < 1) {
            return -1;
        }
        
        long minSum = Integer.MIN_VALUE;
        long maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            minSum = Math.max(minSum, nums[i]);
            maxSum += nums[i];
        }

        return binarySearch(nums, m, minSum, maxSum);
    }


    

    private int binarySearch(int[] nums, int m, long minSum, long maxSum) {
        long left = minSum;
        long right = maxSum;
        long mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (valid(nums, m, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }


    private boolean valid(int[] nums, int m, long sum) {
        int curSplitNo = 0;
        long curSubarraySum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSubarraySum += (long) nums[i];
            if (curSubarraySum > sum) {
                curSplitNo++;
                curSubarraySum = nums[i];
                if (curSplitNo >= m) {
                    return false;
                }
            }
        }
        return true;
    }

    // public static void main(String[] args) {
    //     Solution sol = new Solution();
    //     int[] nums = new int[] {1,2147483647};
    //     int m = 2;
    //     System.out.println(sol.splitArray(nums, m));

    // }
}
// @lc code=end

