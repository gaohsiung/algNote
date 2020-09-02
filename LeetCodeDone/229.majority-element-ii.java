import java.util.*;

/*
 * @lc app=leetcode id=229 lang=java
 *
 * [229] Majority Element II
 */

// @lc code=start
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // c.c.
        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
        Integer cand1 = null;
        Integer cand2 = null;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(cand1 != null && cand1 == nums[i]) {
                count1++;
            } else if (cand2 != null && cand2 == nums[i]) {
                count2++;
            } else if (cand1 == null || count1 == 0) {
                cand1 = nums[i];
                count1++;
            } else if (cand2 == null || count2 == 0) {
                cand2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        List<Integer> res = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for(int n: nums) {
            if (cand1 != null && n == cand1) count1++;
            if (cand2 != null && n == cand2) count2++;
        }
        if (count1 > nums.length/3) res.add(cand1);
        if (count2 > nums.length/3) res.add(cand2);
        return res;
    }
}
// @lc code=end

