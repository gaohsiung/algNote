/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }
        return findKthLargest(nums, k, 0, nums.length - 1);
    }

    private int findKthLargest(int[] nums, int k, int left, int right) {
        int pivot = nums[right];
        int moveInd = left;
        for (int i = left; i < right; i++) {
            if (nums[i] >= pivot) {
                swap(nums, i, moveInd);
                moveInd++;
            }
        }
        swap(nums, moveInd, right);
        if (moveInd + 1 == k) {
            return nums[moveInd];
        } else if (moveInd + 1 > k) {
            return findKthLargest(nums, k, left, moveInd - 1);
        } else {
            return findKthLargest(nums, k, moveInd + 1, right);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = new int[] {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(s.findKthLargest(nums, k));
    }
    
}
// @lc code=end

