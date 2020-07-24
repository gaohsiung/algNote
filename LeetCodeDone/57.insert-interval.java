import java.util.*;

/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // c.c.
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }

        List<int[]> res = new LinkedList<>();
        int[] prev;
        boolean isAdd = false;
        if (newInterval[0] < intervals[0][0]) {
            isAdd = true;
            prev = newInterval;
        } else {
            prev = intervals[0];
        }
        for(int[] cur: intervals) {
            // try to merge new interval
            if(newInterval[0] <= prev[1]) {
                isAdd = true;
                prev[1] = Math.max(prev[1], newInterval[1]);
            } else if (newInterval[0] <= cur[0]) {
                isAdd = true;
                res.add(prev);
                prev = newInterval;
            }
            // try to merge cur
            if(cur[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], cur[1]);
            } else {
                res.add(prev);
                prev = cur;
            }
        }
        if (!isAdd && newInterval[0] <= prev[1]) {
            res.add(new int[]{Math.min(prev[0], newInterval[0]), Math.max(prev[1],newInterval[1])});
        } else if (isAdd) {
            res.add(prev);
        } else {
            res.add(prev);
            res.add(newInterval);
        }

        int[][] resArr = new int[res.size()][];
        for(int i = 0; i < resArr.length; i++) {
            resArr[i] = res.get(i);
        }
        return resArr;        
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.insert(new int[][]{{1,5}}, new int[]{6,8});
    }
}
// @lc code=end

