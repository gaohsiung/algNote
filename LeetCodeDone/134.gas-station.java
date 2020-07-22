/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // c.c.
        if (gas.length != cost.length) return -1;

        int end = -1;
        int start = gas.length - 1;
        if (start == 0) return gas[start] >= cost[start]?start:-1;
        int tank = gas[start] - cost[start];
        while(start > end) {
            if (tank < 0) {
                start --;
                if (start == -1) break;
                tank += gas[start] - cost[start];
            } else {
                end++;
                tank += gas[end] - cost[end];
            }
        }
        return tank >= 0? start:-1;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canCompleteCircuit(new int[]{6,0,1,3,2}, new int[]{4,5,2,5,5}));
    }
}
// @lc code=end

