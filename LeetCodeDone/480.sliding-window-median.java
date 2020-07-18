import java.util.*;

/*
 * @lc app=leetcode id=480 lang=java
 *
 * [480] Sliding Window Median
 */

// @lc code=start
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {

        TreeSet<Integer> lowerSection = new TreeSet<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2) {
                if (nums[i1] != nums[i2]) return -Integer.compare(nums[i1], nums[i2]); // use Integer.compare avoid integer overflow
                return i1 - i2;
            }
        });

        TreeSet<Integer> upperSection = new TreeSet<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2) {
                if (nums[i1] != nums[i2]) return Integer.compare(nums[i1], nums[i2]);
                return i1 - i2;
            }
        });
        int len = nums.length;
        for (int i = 0; i < len && i < k; i++) {
            upperSection.add(i);
            lowerSection.add(upperSection.pollFirst());
        }
        balance(lowerSection, upperSection);
        if (len <= k) {
            return new double[]{getMedian(lowerSection, upperSection, nums, k)};
        }
        double[] res = new double[len - k + 1];
        res[0] = getMedian(lowerSection, upperSection, nums, k);
        for (int i = 1; i < len - k + 1; i++) {
            lowerSection.remove(i-1);
            upperSection.remove(i-1);
            upperSection.add(i+k-1);
            lowerSection.add(upperSection.pollFirst());
            balance(lowerSection, upperSection);
            res[i] = getMedian(lowerSection, upperSection, nums, k);
        }
        return res;
    }

    private void balance(TreeSet<Integer> lowerSection, TreeSet<Integer> upperSection) {
        while(lowerSection.size() > upperSection.size()) {
            upperSection.add(lowerSection.pollFirst());
        }
    }

    private double getMedian(TreeSet<Integer> lowerSection, TreeSet<Integer> upperSection, int[] nums, int k) {
        if (k % 2 == 0) {
            return ((double) nums[lowerSection.first()] + (double) nums[upperSection.first()]) / 2;
        } else {
            return (double) nums[upperSection.first()];
        }
    }


}
// @lc code=end

