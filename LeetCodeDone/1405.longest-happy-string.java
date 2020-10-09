/*
 * @lc app=leetcode id=1405 lang=java
 *
 * [1405] Longest Happy String
 */

// @lc code=start
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        return helper(a, b, c, "a", "b", "c", new StringBuilder()).toString();

    }
    private StringBuilder helper(int a, int b, int c, String aa, String bb, String cc, StringBuilder sb) {
        if (a < b) {
            return helper(b, a, c, bb, aa, cc, sb);
        }
        if (b < c) {
            return helper(a, c, b, aa, cc, bb, sb);
        }
        if (b == 0) {
            int numOfaToBeAppend = Math.min(2, a);
            for (int i = 0; i < numOfaToBeAppend; i++) {
                sb.append(aa);
            }
            return sb;
        }
        int numOfaToBeAppend = Math.min(2, a);
        for (int i = 0; i < numOfaToBeAppend; i++) {
            sb.append(aa);
        }
        // critical section!!!
        int numOfbToBeAppend;
        if (a - numOfaToBeAppend >= b) {
            numOfbToBeAppend = 1;
        } else {
            numOfbToBeAppend = 0;
        }
        for (int i = 0; i < numOfbToBeAppend; i++) {
            sb.append(bb);
        }
        return helper(a - numOfaToBeAppend, b - numOfbToBeAppend, c, aa, bb, cc, sb);


    }
}
// @lc code=end

