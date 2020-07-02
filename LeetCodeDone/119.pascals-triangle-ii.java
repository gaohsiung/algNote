import java.util.*;

/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if (rowIndex < 0) {
            return res;
        }
        for (int n = 0; n <= rowIndex; n++) {
            res.add(1);
            if (n <= 1) {
                continue;
            }
            for (int i = res.size() - 2; i > 0; i--) {
                res.set(i, res.get(i-1)+res.get(i));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.getRow(0));
    }
}
// @lc code=end

