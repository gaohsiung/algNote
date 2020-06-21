/*
 * @lc app=leetcode id=912 lang=java
 *
 * [912] Sort an Array
 */

// @lc code=start
class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = nums[end];
        int pointer = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, pointer);
                pointer++;
            }
        }
        swap(nums, pointer, end);
        quickSort(nums, start, pointer - 1);
        quickSort(nums, pointer + 1, end);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[] {5,4,3,6,7};
        System.out.println((s.sortArray(arr)).toString());
    }
}
// @lc code=end

