import java.util.*;
/*
 * @lc app=leetcode id=89 lang=java
 *
 * [89] Gray Code
 */

// @lc code=start
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        if (n == 0) {
            return res;
        }
        res.add(1);
        for (int i = 2; i <= n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add((1<< (i-1)) + res.get(j));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.grayCode(4));
    }

}
// @lc code=end

