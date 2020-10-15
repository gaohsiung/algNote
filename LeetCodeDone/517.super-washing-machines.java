/*
 * @lc app=leetcode id=517 lang=java
 *
 * [517] Super Washing Machines
 */

// @lc code=start
class Solution {
    public int findMinMoves(int[] machines) {
        // c.c.

        int sum = 0;
        int len = machines.length;
        for (int n: machines) {
            sum += n;
        }
        if (sum % len != 0) {
            return -1;
        }
        int avg = sum / len;
        int[] diffArr = new int[len];
        for (int i = 0; i < len; i++) {
            diffArr[i] = machines[i] - avg;
        }
        int res = 0;
        int maxThroughput = 0;
        for (int i = 0; i < len; i++) {
            maxThroughput += diffArr[i];
            // max(max(throughput of every washer), max(give out of every washer)
            res = Math.max(Math.max(res, Math.abs(maxThroughput)), diffArr[i]);
        }
        return res;

    }
}
// @lc code=end

