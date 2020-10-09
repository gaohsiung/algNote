/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        // c.c.
        if (s == null || s.length() <= 1 || numRows <= 1) {
            return s;
        }

        StringBuilder[] sbs = new StringBuilder[numRows];
        boolean downDirection = true;
        int cur = 0;
        for(char c: s.toCharArray()) {
            if (sbs[cur] == null) sbs[cur] = new StringBuilder(); // important!
            sbs[cur].append(c);
            if (downDirection) {
                cur++;
                if (cur == numRows) {
                    cur = numRows - 2;
                    downDirection = false;
                }
            } else {
                cur--;
                if (cur == -1) {
                    cur = 1;
                    downDirection = true;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb: sbs) {
            if (sb == null) continue; // important!
            res.append(sb);
        }
        return res.toString();
    }
}
// @lc code=end

