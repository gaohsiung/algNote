import java.util.*;

/*
 * @lc app=leetcode id=252 lang=java
 *
 * [252] Meeting Rooms
 */

// @lc code=start
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a1, int[] a2) {
                if (a1[0] != a2[0]) {
                    return a1[0] - a2[0];
                } else {
                    return a1[1] - a2[1];
                }
            }
        });
        int[] prev = null;
        for(int[] itv: intervals) {
            if (prev == null) {
                prev = itv;
            } else {
                if (prev[1] > itv[0]) {
                    return false;
                } else {
                    prev = itv;
                }
            }
        }
        return true;
    }
}
// @lc code=end

