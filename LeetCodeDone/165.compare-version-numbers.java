/*
 * @lc app=leetcode id=165 lang=java
 *
 * [165] Compare Version Numbers
 */

// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len = Math.max(v1.length, v2.length);
        for (int i = 0; i < len; i++) {
            int value1;
            if (i >= v1.length) {
                value1 = 0;
            } else {
                value1 = Integer.parseInt(v1[i]);
            }
            int value2;
            if (i >= v2.length) {
                value2 = 0;
            } else {
                value2 = Integer.parseInt(v2[i]);
            }
            if (value1 > value2) return 1;
            if (value1 < value2) return -1;
        }
        return 0;
    }
}
// @lc code=end

