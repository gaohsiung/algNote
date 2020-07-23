/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // c.c.
        if (nums1 == null || nums2 ==null) {
            throw new IllegalArgumentException();
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        if ((len1 + len2) % 2 == 1) {
            int k = (len1 + len2) / 2 + 1;
            return findKth(nums1, 0, len1-1, nums2, 0, len2-1, k);
        } else {
            int k1 = (len1 + len2) / 2;
            int k2 = k1 + 1;
            return (findKth(nums1, 0, len1-1, nums2, 0, len2-1, k1)
                  +findKth(nums1, 0, len1-1, nums2, 0, len2-1, k2))/2.0;
        }
    }

    private int findKth(int[] nums1, int s1, int e1, int[] nums2, int s2, int e2, int k) {
        if (e1-s1 > e2-s2) {
            return findKth(nums2, s2, e2, nums1, s1, e1, k);
        }
        if(s1 > e1) return nums2[s2+k-1];
        if (k == 1) return Math.min(nums1[s1], nums2[s2]);

        int len1 = e1-s1+1;
        int numsProvidedBynums1 = Math.min(len1, k / 2);
        int numsProvidedBynums2 = k - numsProvidedBynums1;
        int criticalNum1 = nums1[s1 + numsProvidedBynums1 - 1];
        int criticalNum2 = nums2[s2 + numsProvidedBynums2 - 1];
        if(criticalNum1 == criticalNum2) {
            return criticalNum1;
        } else if (criticalNum1 < criticalNum2) {
            return findKth(nums1, s1+numsProvidedBynums1, e1, nums2, s2, e2, k - numsProvidedBynums1);
        } else {
            return findKth(nums1, s1, e1, nums2, s2 + numsProvidedBynums2, e2, k - numsProvidedBynums2);
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findMedianSortedArrays(new int[]{1,3}, new int[]{2});
    }
}
// @lc code=end

