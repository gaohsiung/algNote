/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = m-1;
        int idx2 = n-1;
        for(int i = m+n-1; i>= 0; i--) {
            if (idx1 >= 0 && (idx2 < 0 || nums1[idx1] >= nums2[idx2])) {
                nums1[i] = nums1[idx1];
                idx1--;
            } else if (idx2 >= 0) {
                nums1[i] = nums2[idx2];
                idx2--;
            }
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.merge(new int[] {1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }
}
// @lc code=end

