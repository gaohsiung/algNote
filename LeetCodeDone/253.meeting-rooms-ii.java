import java.util.*;

/*
 * @lc app=leetcode id=253 lang=java
 *
 * [253] Meeting Rooms II
 */

// @lc code=start
class Solution {
    private class Endpoint implements Comparable<Endpoint>{
        int val;
        boolean isStart;
        Endpoint(int val, boolean isStart) {
            this.val = val;
            this.isStart = isStart;
        }
        @Override
        public int compareTo(Endpoint that) {
            if(this.val != that.val) {
                return this.val - that.val;
            } else {
                return (!this.isStart) ? -1 : 1;
            }
        }
    }
    public int minMeetingRooms(int[][] intervals) {
        List<Endpoint> endpoints = new ArrayList<>();
        for(int[]itv: intervals) {
            endpoints.add(new Endpoint(itv[0], true));
            endpoints.add(new Endpoint(itv[1], false));
        }
        Collections.sort(endpoints);
        int count = 0;
        int max = 0;
        for(Endpoint e: endpoints) {
            if (e.isStart) {
                count++;
                max = Math.max(count, max);
            } else {
                count--;
            }
        }
        return max;
    }
}
// @lc code=end

