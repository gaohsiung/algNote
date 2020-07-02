import java.util.*;

/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        if (numRows <= 0) {
            return res;
        }
        for (int n = 0; n < numRows; n++) {
            List<Integer> curList = new ArrayList<>();
            for (int j = 0; j < n + 1; j++) {
                if (j == 0 || j == n) {
                    curList.add(1);
                } else {
                    curList.add(res.get(n-1).get(j-1)+res.get(n-1).get(j));
                }
            }
            res.add(curList);
        }
        return res;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.generate(6));
    }
}
// @lc code=end

