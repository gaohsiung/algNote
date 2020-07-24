import java.util.*;

/*
 * @lc app=leetcode id=324 lang=java
 *
 * [324] Wiggle Sort II
 */

// @lc code=start
class Solution {
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        int medianVal = getMedian(nums, 0, len-1, len/2+1); // idx: len/2-1
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < len/2; i++) {
            ret.add(nums[i]);
        }
        if (len%2 == 1) {
            for(int i = len/2+1; i < len; i++) {
                ret.add(2*(i-(len/2)-1)+1, nums[i]);
            }
            ret.add(nums[len/2]);
        } else {
            for(int i = len/2; i< len; i++) {
                ret.add(1+(i-len/2)*2,nums[i]);
            }
        }
        for(int i = 0; i < len; i++) {
            nums[i] = ret.get(i);
        }
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
        sol.wiggleSort(new int[]{4,5,5,6});
    }
}
// @lc code=end

