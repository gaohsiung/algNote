/*
 * @lc app=leetcode id=324 lang=java
 *
 * [324] Wiggle Sort II
 */

// @lc code=start
class Solution {
    public void wiggleSort(int[] nums) {
        int medianVal = getMedian(nums, 0, nums.length-1, nums.length/2);

        return;
    }

    private int getMedian(int[] nums, int start, int end, int k) {
        if (start == end) return nums[start];

        int pivotIdx = partition(nums, start, end);
        if (pivotIdx-start+1 == k) {
            return nums[pivotIdx];
        } else if (pivotIdx-start+1 < k) {
            return getMedian(nums, pivotIdx+1, end, k - (pivotIdx-start+1));
        } else {
            return getMedian(nums, start, pivotIdx-1, k);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int pivotVal = nums[end];
        int left = start;
        int right = end - 1;
        while(left <= right) {
            if(nums[left] > pivotVal) {
                swap(nums, left, right);
                right--;
            } else {
                left++;
            }
        }
        swap(nums, left, end);
        return left;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.wiggleSort(new int[]{11,7,5,2,4,1,18,3});
    }
}
// @lc code=end

