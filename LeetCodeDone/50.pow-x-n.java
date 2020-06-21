/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return myPow(1/x, -(n+1)) * 1/x;
            }
            return myPow(1/x, -n);
        }
        if (n == 1) {
            return x;
        }
        double temp = myPow(x, n/2);
        if (n%2 == 0) {
            return temp*temp;
        } else {
            return temp*temp*x;
        }





    }

    public static void main(String[] sss) {
        Solution sol = new Solution();
        double x = 1.00000;
        int n = -2147483648;
		System.out.println(sol.myPow(x, n));
    }
}
// @lc code=end

