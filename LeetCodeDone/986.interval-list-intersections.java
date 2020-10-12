import java.util.*;
/*
 * @lc app=leetcode id=986 lang=java
 *
 * [986] Interval List Intersections
 */

// @lc code=start
class Solution {
    public int[][] intervalIntersection(int[][] arr1, int[][] arr2) {
        // c.c.

        int pointer1 = 0;
        int pointer2 = 0;
        int len1 = arr1.length;
        int len2 = arr2.length;
        List<int[]> res = new ArrayList<>();
        while(pointer1 < len1 && pointer2 < len2) {
            int[] itv1 = arr1[pointer1];
            int[] itv2 = arr2[pointer2];
            int[] intersected = findIntersect(itv1, itv2);
            if (intersected != null) {
                res.add(intersected);
            }
            if (itv1[1] < itv2[1]) {
                pointer1++;
            } else {
                pointer2++;
            }
        }
        int[][] ret = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
    private int[] findIntersect(int[] itv1, int[] itv2) {
        if (itv1[0] > itv2[0]) {
            return findIntersect(itv2, itv1);
        }
        if (itv1[1] < itv2[0]) {
            return null;
        }
        if (itv1[1] >= itv2[0] && itv1[1] <= itv2[1]) {
            return new int[]{itv2[0], itv1[1]};
        }
        if (itv1[1] > itv2[1]) {
            return itv2;
        }
        return null;
    }
}
// @lc code=end

