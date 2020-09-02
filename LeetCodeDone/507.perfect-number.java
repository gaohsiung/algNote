/*
 * @lc app=leetcode id=507 lang=java
 *
 * [507] Perfect Number
 */

// @lc code=start
class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 2) return false;
        int sqrt = (int) Math.sqrt(((double) num));
        int sum = 1;
        if (sqrt*sqrt == num) {
            sum += sqrt;
        }
        for (int i = 2; (i == 2 || i < sqrt); i++) {
            if (num % i == 0) {
                sum += i;
                sum += num/i;
            }
        }
        return sum == num;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.checkPerfectNumber(28));
    }
}
// @lc code=end

