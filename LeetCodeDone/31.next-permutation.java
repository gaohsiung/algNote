/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int tempMax = nums[nums.length - 1];
        int toBeSwitchIndex = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < tempMax) {
                toBeSwitchIndex = i;
                break;
            }
            tempMax = Math.max(nums[i], tempMax);
        }
        if (toBeSwitchIndex == -1) { // descending
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
            return;
        }
        int toBeSwitchIndexMax = 0;
        int difference = Integer.MAX_VALUE;
        for(int i = toBeSwitchIndex+1; i < nums.length; i++) {
            if (nums[i] <= nums[toBeSwitchIndex]) continue;
            if (nums[i] - nums[toBeSwitchIndex] < difference) {
                toBeSwitchIndexMax = i;
            }
        }
        swap(nums, toBeSwitchIndex, toBeSwitchIndexMax);
        int left = toBeSwitchIndex+1;
        int right = nums.length - 1;
        while (left <= right) {
            swap(nums, left, right);
            left++;
            right--;
        }
        return;        
    
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        return;
    }   

}
// @lc code=end

