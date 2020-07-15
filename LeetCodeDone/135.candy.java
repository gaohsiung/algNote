import java.util.*;

/*
 * @lc app=leetcode id=135 lang=java
 *
 * [135] Candy
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        int[] result = new int[ratings.length];
        Arrays.fill(result, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                result[i] = result[i-1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                result[i] = Math.max(result[i], result[i+1] + 1);
            }
        }
        int sum = 0;
        for (int r: result) {
            sum += r;
        }
        return sum;
    }
}
// @lc code=end

