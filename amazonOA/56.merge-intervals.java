import java.util.*;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0) {
            return new int[][]{};
        }
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a1, int[] a2) {
                if(a1[0] != a2[0]) {
                    return a1[0] - a2[0];
                } else {
                    return a1[1] - a2[1];
                }
            }
        });
        List<int[]> res = new LinkedList<>();
        int[] prev = intervals[0];
        for(int[] cur: intervals) {
            if(prev[1] >= cur[0]) {
                prev[1] = Math.max(prev[1], cur[1]);
            } else {
                res.add(prev);
                prev = cur;
            }
        }
        res.add(prev);
        int[][] resArr = new int[res.size()][];
        for(int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
}
// @lc code=end

